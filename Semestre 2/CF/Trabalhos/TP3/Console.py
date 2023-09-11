import serial

com = 'COM11' # Tem de coincidir com o do Arduino
baudrate = 9600 # Tem de coincidir com o do Arduino

# Função de inicialização
def comInit(com, baudrate):
    try:
        Serie = serial.Serial(com, baudrate)
        print('Sucesso na ligacao ao Arduino.')
        print ('Ligado ao ' + Serie.portstr)
        return Serie
    except Exception as e:
        print ('Insucesso na ligacao ao Arduino.')
        print (e)
        return None

def stringReceive(Serie):
    try:
        return Serie.readline().strip()
    except Exception as e:
        print ('Erro na comunicacao (stringReceive).')
        print (e)
        Serie.close()

#Programa principal
s = comInit(com, baudrate)
while(True):
    print(stringReceive(s))
    print("")
