#define pinSelector A0

#define pinA0 2
#define pinA1 3
#define pinA2 4
#define pinB0 5
#define pinB1 6
#define pinB2 7
#define pinS0 8
#define pinS1 9
#define pinS2 10

#define pinL_CarryBorrow 11
#define pinL_Overflow 12
#define pinL_Zero 13

boolean Sel, A_0, A_1, A_2, B_0, B_1, B_2, S_0, S_1, S_2, CBw_0, CBw_1, L_CyBw, L_Ov, L_Zero;

void calculateResult(boolean Sel, boolean An, boolean Bn, boolean CnBwnAnterior, boolean *Sn, boolean *CyBw)
{
  *Sn = CnBwnAnterior ^ An ^ Bn;
  *CyBw = (Sel ^ An) & Bn | CnBwnAnterior & (Sel ^ An) | CnBwnAnterior & Bn; 
}

boolean flagOverflow()
{
  return CBw_1 ^ L_CyBw;
}

boolean flagZero()
{
  return !(S_0 | S_1 | S_2);
}

void setFlags()
{
  L_Ov = flagOverflow();
  L_Zero = flagZero();
}

void readInputs()
{
  Sel = digitalRead(pinSelector);
  A_0 = digitalRead(pinA0);
  A_1 = digitalRead(pinA1);
  A_2 = digitalRead(pinA2);
  B_0 = digitalRead(pinB0);
  B_1 = digitalRead(pinB1);
  B_2 = digitalRead(pinB2);
}

void writeOutputs()
{
  digitalWrite(pinS0, S_0);
  digitalWrite(pinS1, S_1);
  digitalWrite(pinS2, S_2);
  digitalWrite(pinL_CarryBorrow, L_CyBw);
  digitalWrite(pinL_Overflow, L_Ov);
  digitalWrite(pinL_Zero, L_Zero);
}

void setup() {
  pinMode(pinSelector, INPUT);
  pinMode(pinA0, INPUT);
  pinMode(pinA1, INPUT);
  pinMode(pinA2, INPUT);
  pinMode(pinB0, INPUT);
  pinMode(pinB1, INPUT);
  pinMode(pinB2, INPUT);

  pinMode(pinS0, OUTPUT);
  pinMode(pinS1, OUTPUT);
  pinMode(pinS2, OUTPUT);
  pinMode(pinL_CarryBorrow, OUTPUT);
  pinMode(pinL_Overflow, OUTPUT);
  pinMode(pinL_Zero, OUTPUT);
}

void loop() {
  readInputs();
  
  calculateResult(Sel, A_0, B_0, 0, &S_0, &CBw_0);
  calculateResult(Sel, A_1, B_1, CBw_0, &S_1, &CBw_1);
  calculateResult(Sel, A_2, B_2, CBw_1, &S_2, &L_CyBw);    
  
  setFlags();
  writeOutputs();
}
