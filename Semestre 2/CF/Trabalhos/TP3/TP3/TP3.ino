#include <Wire.h>

#define ENDERECO_DISPLAY 0x3E
#define COMANDOS 0x80
#define DADOS 0x40
#define ENDERECO_BMP180 0x77

short AC_1, AC_2, AC_3, B_1, B_2, MB, MC, MD;
unsigned short AC_4, AC_5, AC_6;
long UP, UT,T;
float P;
long H;
byte oss = 3;
byte delayOss[] = {5, 8, 14, 26};

boolean estado;
unsigned long now, ago;

//----- Métodos Display -----
void escreverComando8(byte oitoBits)
{
  Wire.beginTransmission(ENDERECO_DISPLAY);
  Wire.write(COMANDOS);
  Wire.write(oitoBits);
  Wire.endTransmission();
}

void escreverDados8(byte oitoBits)
{
  Wire.beginTransmission(ENDERECO_DISPLAY);
  Wire.write(DADOS);
  Wire.write(oitoBits);
  Wire.endTransmission();
}

//Comandos
void displayInit()
{
  delay(30);
  escreverComando8(0x38);
  delayMicroseconds(50);
  escreverComando8(0x0F);
  delayMicroseconds(50);
  escreverComando8(0x01);
  delay(10);
  escreverComando8(0x06);
}

void displayClear()
{
  escreverComando8(0x1);
  delay(10);
}

void displaySetCursor(byte linha, byte coluna)
{
  escreverComando8(0b10000000 | linha << 6 | coluna);
  delayMicroseconds(50);
}

void displayCursorOffBlinkOff()
{
  escreverComando8(0x0C);
  delayMicroseconds(50);
}

void displayCursorOnBlinkOn()
{
  escreverComando8(0x0F);
  delayMicroseconds(50);
}

void displayCursorHome()
{
  escreverComando8(0x02);
  delay(10);
}

//Dados
void displayPrintChar(char c)
{
  escreverDados8(c);
  delayMicroseconds(50);
}

void displayPrintString(String s)
{
  for(int charIndex = 0; charIndex < s.length(); charIndex++)
  {
    displayPrintChar(s.charAt(charIndex));
  }
}
// ----- Métodos Display -----

// ----- Métodos BMP180 -----
short BMP180_read_16bit_value(byte regAdress)
{
  Wire.beginTransmission(ENDERECO_BMP180);
  Wire.write(regAdress);
  Wire.endTransmission();

  Wire.requestFrom(ENDERECO_BMP180, 2);
  while(Wire.available() == 0);
  byte MSB = Wire.read();
  while(Wire.available() == 0);
  byte LSB = Wire.read();
  Wire.endTransmission();

  return (word) MSB << 8 | LSB;
}

long BMP180_read_24bit_value(byte regAdress)
{
  Wire.beginTransmission(ENDERECO_BMP180);
  Wire.write(regAdress);
  Wire.endTransmission();

  Wire.requestFrom(ENDERECO_BMP180, 3);
  while(Wire.available() == 0);
  byte MSB = Wire.read();
  while(Wire.available() == 0);
  byte LSB = Wire.read();
  while(Wire.available() == 0);
  byte XLSB = Wire.read();
  Wire.endTransmission();

  return (long) MSB << 16 | (word) LSB << 8 | XLSB;
}

void BMP180_write_8bit_value(byte regAdress, byte value)
{
  Wire.beginTransmission(ENDERECO_BMP180);
  Wire.write(regAdress);
  Wire.write(value);
  Wire.endTransmission();
}

void BMP180_readCalibrationData()
{
  AC_1 = BMP180_read_16bit_value(0xAA);
  AC_2 = BMP180_read_16bit_value(0xAC);
  AC_3 = BMP180_read_16bit_value(0xAE);
  AC_4 = BMP180_read_16bit_value(0xB0);
  AC_5 = BMP180_read_16bit_value(0xB2);
  AC_6 = BMP180_read_16bit_value(0xB4);
  B_1 = BMP180_read_16bit_value(0xB6);
  B_2 = BMP180_read_16bit_value(0xB8);
  MB = BMP180_read_16bit_value(0xBA);
  MC = BMP180_read_16bit_value(0xBC);
  MD = BMP180_read_16bit_value(0xBE);
}

short BMP180_readUncompensatedTemperatureValue()
{
  BMP180_write_8bit_value(0xF4, 0x2E);
  delay(5);
  return BMP180_read_16bit_value(0xF6);
}

long BMP180_readUncompensatedPressureValue()
{
  BMP180_write_8bit_value(0xF4, (0x34 + (oss << 6)));
  delay(delayOss[oss]);
  return BMP180_read_24bit_value(0xF6) >> (8 - oss);
}

void BMP180_calculateTrueTemperatureAndPressure()
{
  long X_1 = (UT - AC_6) * AC_5 / pow(2, 15);
  long X_2 = MC * pow(2, 11) / (X_1 + MD);
  long B_5 = X_1 + X_2;
  T = (B_5 + 8) / pow(2, 4);
  
  long B_6 = B_5 - 4000;
  X_1 = (B_2 * (B_6 * B_6 / pow(2, 12))) / pow(2, 11);
  X_2 = AC_2 * B_6 / pow(2, 11);
  long X_3 = X_1 + X_2;
  long B_3 = (((AC_1 * 4 + X_3) << oss) + 2) / 4;
  X_1 = AC_3 + B_6 / pow(2, 13);
  X_2 = (B_1 * (B_6 * B_6 / pow(2, 12))) / pow(2, 16);
  X_3 = ((X_1 + X_2) + 2) / pow(2, 2);
  unsigned long B_4 = AC_4 * (unsigned long)(X_3 + 32768) / pow(2, 15);
  unsigned long B_7 = ((unsigned long) UP - B_3) * (50000 >> oss);
  if(B_7 < 0x80000000)
  {
    P = (B_7 * 2) / B_4;
  }
  else
  {
    P = (B_7 / B_4) * 2;
  }
  X_1 = (P / pow(2, 8)) * (P / pow(2, 8));
  X_1 = (X_1 * 3038) / pow(2, 16);
  X_2 = (-7357 * P) / pow(2, 16);
  P = P + (X_1 + X_2 + 3791) / pow(2, 4);
  P = P / 100.;
  P -= 675;
}

float BMP180_calculateAltitude()
{
  return 44330 * (1 - pow((P / 1013.25),1/5.255));
}

// ----- Métodos BMP180 -----

void setup()
{
  Serial.begin(9600);
  Wire.begin();

  //Display
  displayInit();
  displayCursorOffBlinkOff(); 
  
  //BMP180
  BMP180_readCalibrationData();

  estado = true;
}

void loop()
{
  switch(estado)
  {
    case false:

      now = millis();

      if(now - ago >= 10000)
      {
        estado = true;
      }

      break;

     case true:

      displayCommunication();
      serialCommunication();

      ago = millis();
      estado = false;
      break;
  } 
}

void serialCommunication()
{
  Serial.print("T: "); 
  Serial.print(T/10.);
  Serial.println("ºC");
  
  Serial.print("P: "); 
  Serial.print(P);
  Serial.println("hPa");

  Serial.print("A: ");
  Serial.print(H);
  Serial.println("m");
}

void displayCommunication()
{
  UT = BMP180_readUncompensatedTemperatureValue();
  UP = BMP180_readUncompensatedPressureValue();
  BMP180_calculateTrueTemperatureAndPressure();
  H = BMP180_calculateAltitude();

  displayClear();
  displayPrintString("T:");
  displayPrintString(String((float)T/10.));
  displayPrintChar(0xDF); // Char: º
  displayPrintChar('C');
  displayPrintString(" A:");
  displayPrintString(String(H));
  displayPrintChar('m');
  displaySetCursor(1, 0);
  displayPrintString("P:");
  displayPrintString(String(P));
  displayPrintString("hPa");
}
