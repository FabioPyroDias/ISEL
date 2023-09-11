#define pinSel 3

#define pinS0 4
#define pinS1 5
#define pinS2 6
#define pinS3 7

bool Sel, D0, D1, S0, S1, S2, S3;
volatile bool Q0, Q1;

unsigned long now, ago;

boolean flip_flop_D(boolean D)
{
  return D;
}

void funcaoEstadoSeguinte()
{
  D1 = Sel ^ Q0 ^ Q1;
  D0 = !Q0;
}

void funcaoSaida()
{
  S0 = true;
  S1 = Q0;
  S2 = Q1;
  S3 = true;
}

void CLK()
{
  now = millis();
  
  if(now - ago >= 200)
  {
    Q0 = flip_flop_D(D0);
    Q1 = flip_flop_D(D1);
    ago = now;
  }
}

void clockGenerator(byte pino, float f)
{
  static boolean state = LOW;
  static unsigned long t1, t0;
  t1 = millis();
  
  if (t1 - t0 >= 500. / f)
  {
    digitalWrite(pino, state = !state);
    t0 = t1;
  }
}

void lerEntradas()
{
  Sel = digitalRead(pinSel);
}

void escreverSaidas()
{
  digitalWrite(pinS0, true);
  digitalWrite(pinS1, S1);
  digitalWrite(pinS2, S2);
  digitalWrite(pinS3, true);
}

void setup() {
  pinMode(pinSel, INPUT);
  pinMode(pinS0, OUTPUT);
  pinMode(pinS1, OUTPUT);
  pinMode(pinS2, OUTPUT);
  pinMode(pinS3, OUTPUT);
  pinMode(8, OUTPUT);
  
  attachInterrupt(0, CLK, RISING);
  interrupts();
}

void loop() {
  lerEntradas();
  funcaoEstadoSeguinte();
  funcaoSaida();
  escreverSaidas();
  clockGenerator(8, 1);
}
