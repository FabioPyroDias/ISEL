//Definir botão para o CLK
#define pinCLK 2

unsigned long now, ago;

//Memória de Código
word ROM[128];

//Memória de Dados
byte RAM[32];

//Definições da ROM_MC
const int ROM_MC[16] = {0x2C00, 0x1C00, 0x2C80, 0x1500, 0x0800, 0x0C70, 0x1E10, 0x1E10, 0x1E10, 0x1E70, 0x1E70, 0x0C01, 0x0C08, 0x0C04, 0x0C02, 0x0C01};

//Entradas e Saídas dos Registos
byte DPC;               //Entrada Registo PC
volatile byte QPC;      //Saída Registo PC
byte DRn[2];            //Entrada Registo Rn
volatile byte QRn[2];   //Saída Registo Rn
byte DA;                //Entrada Registo A
volatile byte QA;       //Saída Registo A
boolean DCy;            //Entrada Flag Carry
volatile boolean QCy;   //Saída Flag Carry
boolean DOv;            //Entrada Flag Overflow
volatile boolean QOv;   //Saída Flag Overflow
boolean DZ;             //Entrada Flag Zero
volatile boolean QZ;    //Saída Flag Zero

//Saídas do Módulo de Controlo
boolean EnRn, EnA, RD, WR, S0A, S1A, SRn, EnCy, EnOv, EnZ, JC, JNZ, JOv, JMP;

//Variáveis de Saída
byte Y1, Y2, Y3, Y4, Y5, Y6, Y7;

//Código
word codigo;

//Debug
boolean displayed;

//MUX_2_1
void MUX_2x1(boolean sel, byte in_0, byte in_1, byte *y)
{
  *y = sel ? in_1 : in_0;
}

//MUX_4_1
void MUX_4x1(boolean sel_0, boolean sel_1, byte in_0, byte in_1, byte in_2, byte in_3, byte *y)
{
  switch(sel_1 << 1 | sel_0)
  {
    case B00:
        *y = in_0;

      break;
    
    case B01:
        *y = in_1;

      break;
  
    case B10:
        *y = in_2;
        
      break;
    
    case B11:
        *y = in_3;
        
      break;
  } 
}

//DMUX_1_2
byte DMUX_1x2(boolean sel, boolean D)
{
  return D << sel;
}

//Flip Flop D
void flip_flop_D_Enable(boolean enable, boolean D, boolean *Q)
{
  if(enable)
  {
    *Q = D;
  }
}

void registoComEnable(boolean enable, byte D, byte *Q)
{
  if(enable)
  {
    *Q =  D;
  }
}

//Função MCLK (Ascendente)
void MCLK()
{
  now = millis();
  
  if(now - ago >= 200)
  {
  //Atualizar o registo PC
  registoComEnable(1, Y3, &QPC);
      
  attachInterrupt(0, MCLKNeg, FALLING);

  Serial.println("Registou PC");
  ago = now;
  }
}

//Função MCLK Negado (Descendente)
void MCLKNeg()
{
  now = millis();
  
  if(now - ago >= 200)
  {
  //Atualizar os registos Rn e A, assim como as flags Cy, Ov e Z
  registoComEnable(EnRn, Y4, &QRn[bitRead(codigo, 7)]);
  registoComEnable(EnA, Y6, &QA);
  flip_flop_D_Enable(EnCy, DCy, &QCy);
  flip_flop_D_Enable(EnOv, DOv, &QOv);
  flip_flop_D_Enable(EnZ, DZ, &QZ);

  attachInterrupt(0, MCLK, RISING);

  Serial.println("Registou OUTROS");
  ago = now;
  }
}

void AfetarSinais()
{
  codigo = ROM[QPC];
  byte bitsDeInstrucao = bitRead(codigo, 9) << 3 | bitRead(codigo, 8) << 2 | bitRead(codigo, 1) << 1 | bitRead(codigo, 0);
  int sinais = ROM_MC[bitsDeInstrucao];
  
  JMP = bitRead(sinais, 0);
  JOv = bitRead(sinais, 1);
  JNZ = bitRead(sinais, 2);
  JC = bitRead(sinais, 3);
  EnZ = bitRead(sinais, 4);
  EnOv = bitRead(sinais, 5);
  EnCy = bitRead(sinais, 6);
  SRn = bitRead(sinais, 7);
  S1A = bitRead(sinais, 8);
  S0A = bitRead(sinais, 9);
  WR = bitRead(sinais, 10);
  RD = bitRead(sinais, 11);
  EnA = bitRead(sinais, 12);
  EnRn = bitRead(sinais, 13);
}

//Bloco de Registos
void BlocoDeRegistos()
{
  boolean sel = bitRead(codigo, 7);
  byte enableRegistos = DMUX_1x2(sel, EnRn);
  registoComEnable(bitRead(enableRegistos, 0), Y5, &DRn[0]);
  registoComEnable(bitRead(enableRegistos, 1), Y5, &DRn[1]);
  MUX_2x1(sel, QRn[0], QRn[1], &Y5);
}

//Bloco da ALU
void ALU(boolean S_0, boolean S_1, boolean S_2, boolean S_3, byte A, byte B, boolean CyIn, boolean OvIn, boolean ZIn, boolean *CyOut, boolean *OvOut, boolean *ZOut, byte *yOut)
{
  switch(S_3 << 3 | S_2 << 2| S_1 << 1 | S_0)
  {
    case B0101:
      //Comando CPLF
      *CyOut = !CyIn;
      *OvOut = !OvIn;
      *ZOut  = !ZIn;
      break;
      
    case B0110:
      //Comando NOT
      *yOut = bitRead(~A, 4) << 4 | bitRead(~A, 3) << 3 | bitRead(~A, 2) << 2 | bitRead(~A, 1) << 1 | bitRead(~A, 0);
      *ZOut = !(bitRead(*yOut, 4) << 4 | bitRead(*yOut, 3) << 3 | bitRead(*yOut, 2) << 2 | bitRead(*yOut, 1) << 1 | bitRead(*yOut, 0));
      break;
      
    case B0111:
      //Comando AND
      *yOut = bitRead(A & B, 4) << 4 | bitRead(A & B, 3) << 3 | bitRead(A & B, 2) << 2 | bitRead(A & B, 1) << 1 | bitRead(A & B, 0);
      *ZOut = !(bitRead(*yOut, 4) << 4 | bitRead(*yOut, 3) << 3 | bitRead(*yOut, 2) << 2 | bitRead(*yOut, 1) << 1 | bitRead(*yOut, 0));
      break;
      
    case B1000:
      //Comando OR
      *yOut = bitRead(A | B, 4) << 4 | bitRead(A | B, 3) << 3 | bitRead(A | B, 2) << 2 | bitRead(A | B, 1) << 1 | bitRead(A | B, 0);
      *ZOut = !(bitRead(*yOut, 4) << 4 | bitRead(*yOut, 3) << 3 | bitRead(*yOut, 2) << 2 | bitRead(*yOut, 1) << 1 | bitRead(*yOut, 0));
      break;
      
    case B1001:
      //Comando ADDC
      *yOut = bitRead(A + B + CyIn, 4) << 4 | bitRead(A + B + CyIn, 3) << 3 | bitRead(A + B + CyIn, 2) << 2 | bitRead(A + B + CyIn, 1) << 1 | bitRead(A + B + CyIn, 0);
      *CyOut = bitRead(A + B + CyIn, 5);
      *OvOut = bitRead(A, 4) ^ bitRead(B, 4) ^ bitRead(*yOut, 4) ^ *CyOut;
      *ZOut = !(bitRead(*yOut, 4) << 4 | bitRead(*yOut, 3) << 3 | bitRead(*yOut, 2) << 2 | bitRead(*yOut, 1) << 1 | bitRead(*yOut, 0));
      break;
      
    case B1010:
      //Comando SUBB
      *yOut = bitRead(A - B - CyIn, 4) << 4 | bitRead(A - B - CyIn, 3) << 3 | bitRead(A - B - CyIn, 2) << 2 | bitRead(A - B - CyIn, 1) << 1 | bitRead(A - B - CyIn, 0);
      *CyOut = bitRead(A - B - CyIn, 5);
      *OvOut = bitRead(A, 4) ^ bitRead(B, 4) ^ bitRead(*yOut, 4) ^ *CyOut;
      *ZOut = !(bitRead(*yOut, 4) << 4 | bitRead(*yOut, 3) << 3 | bitRead(*yOut, 2) << 2 | bitRead(*yOut, 1) << 1 | bitRead(*yOut, 0));
      break;
      
    default:
      break;
  }
}

void TriState()
{
  if(!WR)
  {
    RAM[Y5] = QA;
  }
}

void PreencherROM()
{
  for(int index = 0; index < 128; index++)
  {
    ROM[index] = random(0, 1024);
  }
}

void PreencherRAM()
{
  for(int index = 0; index < 32; index++)
  {
    RAM[index] = random(0, 32);
  }
}

void setup()
{
  Serial.begin(115200);
  pinMode(pinCLK, INPUT_PULLUP);

  PreencherROM();
  PreencherRAM();

  //Programa1();
  //Programa2();
  Programa3();

  attachInterrupt(0, MCLKNeg, FALLING);
  interrupts();
}

void loop()
{
  AfetarSinais();
  MUX_2x1((JC & QCy) | (JNZ & !QZ) | (JOv & QOv), 1, bitRead(codigo, 7) << 6 | bitRead(codigo, 7) << 5 | bitRead(codigo, 6) << 4 | bitRead(codigo, 5) << 3 | bitRead(codigo, 4) << 2 | bitRead(codigo, 3) << 1 | bitRead(codigo, 2), &Y1);
  Y2 = Y1 + QPC;
  MUX_2x1(JMP, Y2, bitRead(codigo, 8) << 6 | bitRead(codigo, 7) << 5 | bitRead(codigo, 6) << 4 | bitRead(codigo, 5) << 3 | bitRead(codigo, 4) << 2 | bitRead(codigo, 3) << 1 | bitRead(codigo, 2), &Y3);
  MUX_2x1(SRn, bitRead(codigo, 6) << 4 | bitRead(codigo, 5) << 3 | bitRead(codigo, 4) << 2 | bitRead(codigo, 3) << 1 | bitRead(codigo, 2), QA, &Y4);
  BlocoDeRegistos();
  ALU(bitRead(codigo, 0), bitRead(codigo, 1), bitRead(codigo, 8), bitRead(codigo, 9), QA, Y5, QCy, QOv, QZ, &DCy, &DOv, &DZ, &Y7);
  MUX_4x1(S0A, S1A, Y5, Y7, RAM[Y5], 0, &Y6);
  TriState();

  InputUtilizador();
}

//Métodos de Debug
void VerConteudoRegistos()
{
  byte registo0 = bitRead(QRn[0], 4) << 4 | bitRead(QRn[0], 3) << 3 | bitRead(QRn[0], 2) << 2 | bitRead(QRn[0], 1) << 1 | bitRead(QRn[0], 0);
  byte registo1 = bitRead(QRn[1], 4) << 4 | bitRead(QRn[1], 3) << 3 | bitRead(QRn[1], 2) << 2 | bitRead(QRn[1], 1) << 1 | bitRead(QRn[1], 0);
  byte registoA = bitRead(QA, 4) << 4 | bitRead(QA, 3) << 3 | bitRead(QA, 2) << 2 | bitRead(QA, 1) << 1 | bitRead(QA, 0);
  byte registoPC = bitRead(QPC, 4) << 4 | bitRead(QPC, 3) << 3 | bitRead(QPC, 2) << 2 | bitRead(QPC, 1) << 1 | bitRead(QPC, 0);
  
  Serial.println();
  Serial.println("Registos");
  Serial.print("R0 : ");
  Serial.print(registo0, BIN);
  Serial.print(" (");
  Serial.print(registo0, DEC);
  Serial.print(") | R1 : ");
  Serial.print(registo1, BIN);
  Serial.print(" (");
  Serial.print(registo1, DEC);
  Serial.print(") | A : ");
  Serial.print(registoA, BIN);
  Serial.print(" (");
  Serial.print(registoA, DEC);
  Serial.print(") | PC : ");
  Serial.print(registoPC, BIN);
  Serial.print(" (");
  Serial.print(registoPC, DEC);
  Serial.println(")");
  Serial.println();
  Serial.println();
}

void VerSinaisModuloControlo()
{
  Serial.println();
  Serial.println("Sinais");
  Serial.println("|   EnR   |   EnA   |   RD   |   WR   |   S0A   |   S1A   |   SRn   |   EnCy   |   EnOv   |   EnZ   |   JC   |   JNZ   |   JOv   |   JMP   |");
  Serial.print("|    ");
  Serial.print(EnRn);
  Serial.print("    |    ");
  Serial.print(EnA);
  Serial.print("    |   ");
  Serial.print(RD);
  Serial.print("    |   ");
  Serial.print(WR);
  Serial.print("    |    ");
  Serial.print(S0A);
  Serial.print("    |    ");
  Serial.print(S1A);
  Serial.print("    |    ");
  Serial.print(SRn);
  Serial.print("    |     ");
  Serial.print(EnCy);
  Serial.print("    |     ");
  Serial.print(EnOv);
  Serial.print("    |    ");
  Serial.print(EnZ);
  Serial.print("    |   ");
  Serial.print(JC);
  Serial.print("    |    ");
  Serial.print(JNZ);
  Serial.print("    |    ");
  Serial.print(JOv);
  Serial.print("    |    ");
  Serial.print(JMP);
  Serial.println("    |");
  Serial.println();
  Serial.println();
}

void VerFlags()
{ 
  Serial.println();
  Serial.println("Flags");
  Serial.print("Cy : ");
  Serial.print(QCy);
  Serial.print(" | Ov : ");
  Serial.print(QOv);
  Serial.print(" | Z : ");
  Serial.println(QZ);
  Serial.println();
  Serial.println();
}

void VerMemoriaDeCodigo()
{
  Serial.println();
  Serial.println(" Memória de Código");
  Serial.println("|---|   0   |   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |   A   |   B   |   C   |   D   |   E   |   F   |");
  
  for(int line = 0; line < 8; line++)
  {
    Serial.print("| ");
    Serial.print(line);
    Serial.print(" |");

    for(int index = line * 16; index < (line + 1) * 16 ; index++)
    {
      String valorROM = String(ROM[index], 16);
  
      int valorROMLength = valorROM.length();
      
      Serial.print("  ");
      for(int bitIndex = 0; bitIndex < 3 - valorROMLength; bitIndex++)
      {
        Serial.print("0");
      }
      Serial.print(ROM[index], HEX);
      Serial.print("  |");
    }
    Serial.println();
  }
  Serial.println();
}

void VerMemoriaDeDados()
{
  Serial.println();
  Serial.println(" Memória de Dados");
  Serial.println("|---|   0    |   1    |   2    |   3    |   4    |   5    |   6    |   7    |   8    |   9    |   A    |   B    |   C    |   D    |   E    |   F    |");
  
  for(int line = 0; line < 2; line++)
  {
    Serial.print("| ");
    Serial.print(line);
    Serial.print(" |");

    for(int index = line * 16; index < (line + 1) * 16 ; index++)
    {
      String valorRAM = String(RAM[index], 16);
  
      int valorRAMLength = valorRAM.length();
      
      Serial.print("   ");
      for(int bitIndex = 0; bitIndex < 2 - valorRAMLength; bitIndex++)
      {
        Serial.print("0");
      }
      Serial.print(RAM[index], HEX);
      Serial.print("   |");
    }
    Serial.println();
  }
  Serial.println();
}

void VerSaidas()
{
  Serial.println();
  Serial.println("Saidas");
  Serial.print("Y1 : ");
  Serial.print(Y1);
  Serial.print(" | Y2 : ");
  Serial.print(Y2);
  Serial.print(" | Y3 : ");
  Serial.print(Y3);
  Serial.print(" | Y4 : ");
  Serial.print(Y4);
  Serial.print(" | Y5 : ");
  Serial.print(Y5);
  Serial.print(" | Y6 : ");
  Serial.print(Y6);
  Serial.print(" | Y7 : ");
  Serial.println(Y7);
  Serial.println();
  Serial.println();
}

void VerCodigo()
{
  Serial.println();
  Serial.print("Código: ");
  for(int index = 9; index >= 0; index--)
  {
    Serial.print(bitRead(codigo, index));
  }
  Serial.println();
  Serial.println();
}

void InputUtilizador()
{
  if(!displayed)
  {
    Serial.println("Ver conteúdo de: ");
    Serial.println("(r) Registos | (s) Sinais do Módulo de Controlo | (f) Flags | (c) Memória de Código | (d) Memória de Dados | (y) Saídas | (a) Código");
    displayed = true;
  }

  if(Serial.available())
  {
    int character = Serial.read();
    boolean toBeDisplayed = true;
      
    switch(character)
    {
      case 'r':
        VerConteudoRegistos();
        break;
      case 's':
        VerSinaisModuloControlo();
        break;
      case 'f':
        VerFlags();
        break;
      case 'c':
        VerMemoriaDeCodigo();
        break;
      case 'd':
        VerMemoriaDeDados();
        break;
      case 'y':
        VerSaidas();
        break;
      case 'a':
        VerCodigo();
        break;
      default:
        toBeDisplayed = false;
        break;
    }

    if(toBeDisplayed)
    {
      displayed = false;
    }
  }
}

void Programa1()
{
  /* Com este programa, pretendemos somar 31 com 1, de forma a obtermos Cy.
     De seguida, testamos o JNZ, que falhará dado que o resultado é 0.
     Após isto, fazemos JC para saltarmos para duas instruções abaixo.
     Nesta, saltamos continuamente para a instrução 15, pelo JMP. */
  
  ROM[0] = 0b0001111100; //MOV R0, 31
  ROM[1] = 0b0000000001; //MOV A, R0
  ROM[2] = 0b0000000000; //MOV R0, 0
  ROM[3] = 0b0100000000; //MOV @R0, A
  
  ROM[4] = 0b0010000100; //MOV R1, 1
  ROM[5] = 0b0010000001; //MOV A, R1
  ROM[6] = 0b0110000000; //MOV @R1, A
  
  ROM[7] = 0b0000000001; //MOV A, R0
  ROM[8] = 0b0000000011; //MOV A, @R0
  ROM[9] = 0b0000000010; //MOV R0, A
  
  ROM[10] = 0b0010000011; //MOV A, @R1
  ROM[11] = 0b1000000001; //ADDC A, R0
  
  ROM[12] = 0b1100001101; //JNZ, 3
  ROM[13] = 0b1100001000; //JC, 2
  ROM[14] = 0b0000000000; //MOV R0, 0
  ROM[15] = 0b0100000001; //CPLF
  ROM[16] = 0b1100001000; //JC, 2
  ROM[17] = 0b1001000111; //JMP, 17
}

void Programa2()
{
  /* Neste programa, iremos subtrair 15 com -11, obtendo o resultado -6, de forma a obtermos Ov.
     De seguida, testaremos o JOv para a instrução para complementar as flags. Feito isto, não haverá Ov.
     Testamos novamento  o JOv, neste caso será passado à frente, e entraremos num JMP constante. */
  
  ROM[0] = 0b0000111100; //MOV R0, 15
  ROM[1] = 0b0000000001; //MOV A, R0
  ROM[2] = 0b0000000000; //MOV R0, 0
  ROM[3] = 0b0100000000; //MOV @R0, A
  
  ROM[4] = 0b0011010100; //MOV R1, -11
  ROM[5] = 0b0010000001; //MOV A, R1
  ROM[6] = 0b0010000100; //MOV R1, 1
  ROM[7] = 0b0110000000; //MOV @R1, A

  ROM[8] = 0b0000000001; //MOV A, R0
  ROM[9] = 0b0010000011; //MOV A, @R1
  ROM[10] = 0b0010000010; //MOV R1, A

  ROM[11] = 0b0000000011; //MOV A, @R0
  ROM[12] = 0b1010000010; //SUBB A, R1
  
  ROM[13] = 0b1111111110; //JOv, -1
  ROM[15] = 0b0100000001; //CPLF
  ROM[16] = 0b1111111110; //JOv, -1
  ROM[17] = 0b1001000111; //JMP, 17
}

void Programa3()
{
  /* Para o terceiro programa, vamos mover para A 21, movemos para R0 25 e fazemos AND bit a bit.
     De seguida, movemos para R0 o valor 10 e fazemos OR bit a bit.
     Finalmente, fazemos NOT e entramos num JMP constante. */   
  
  ROM[0] = 0b0001010100; //MOV R0, 21
  ROM[1] = 0b0000000001; //MOV A, R0

  ROM[2] = 0b0001100100; //MOV R0, 25
  ROM[3] = 0b0100000011; //AND A, R0

  ROM[4] = 0b0010000000; //MOV R1, 0
  ROM[5] = 0b0110000000; //MOV @R1, A

  ROM[6] = 0b0000101000; //MOV R0, 10
  ROM[7] = 0b1000000000; //OR A, R0

  ROM[8] = 0b0010000100; //MOV R1, 1
  ROM[9] = 0b0110000000; //MOV @R1, A

  ROM[10] = 0b0100000010; //NOT A

  ROM[11] = 0b0010001000; //MOV R1, 2
  ROM[12] = 0b0110000000; //MOV @R1, A

  ROM[13] = 0b1000110111; //JMP, 13
}
