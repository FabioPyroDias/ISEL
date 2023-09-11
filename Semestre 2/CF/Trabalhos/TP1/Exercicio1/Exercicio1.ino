#define pinA 2
#define pinB 3
#define pinF 4
#define pinS 5
#define pinL 6

boolean A, B, F, S, L;

boolean Led(boolean A, boolean B, boolean F, boolean S)
{
  return S & !F & A | F & !A & !B | !S & F & !B | !S & F & !A | S & !F & B | !F & A & B;
}

void readInputs()
{
  A = digitalRead(pinA);
  B = digitalRead(pinB);
  F = digitalRead(pinF);
  S = digitalRead(pinS);
}

void detectAnomally()
{
  L = Led(A, B, F, S);
}

void writeOutputs()
{
  digitalWrite(pinL, L);
}

void setup() {
  pinMode(pinA, INPUT);
  pinMode(pinB, INPUT);
  pinMode(pinF, INPUT);
  pinMode(pinS, INPUT);
  pinMode(pinL, OUTPUT);
}

void loop() {
  readInputs();
  detectAnomally();
  writeOutputs();
}
