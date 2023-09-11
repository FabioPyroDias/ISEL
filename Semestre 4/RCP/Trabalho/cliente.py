from socket import *

class Client:

    #Define o IP e o Porto do Servidor
    __serverAdress = "127.0.0.1"
    __serverPort = 80

    #Variável de Controlo da Aplicação
    __aCorrer = True

    #Opções válidas para o programa
    __opcoes = ['t', '0', '1', '2', '3']

    #Verificar se o Input dado pelo Utilizador pertence às opções válidas
    def validateInput(self, input):

        for opcao in self.__opcoes:
            if(input == opcao):
                return True
        
        return False

    def main(self):
        while(self.__aCorrer):
    
            menu =  "Insira a opção desejada:\n" \
                    "(0) Código 200 OK\n" \
                    "(1) Código 302 Found\n" \
                    "(2) Código 400 Bad Request\n" \
                    "(3) Código 404 Not Found\n" \
                    "(T) Terminar execução"
    
            print(menu)

            #Obter o Input do Utilizador
            userInput = input("Selecção: ").lower()
            print()

            #Opção Inválida
            if(not self.validateInput(userInput)):
                print("Opção Inválida")
                print()
            else:
                #Terminar o Programa
                if(userInput == "t"):
                    return

                #Create Socket
                clientSocket = socket(AF_INET, SOCK_STREAM)

                #Connect to Socket
                clientSocket.connect((self.__serverAdress, self.__serverPort))

                sentence = ""

                #200 OK
                if userInput == "0":
                    sentence = "GET /dashboard/ HTTP/1.1\r\n" \
                    "Host: localhost:8080\r\n\r\n"
                #302 Found
                elif userInput == "1":
                    sentence = "GET / HTTP/1.1\r\n" \
                    "Host: localhost:8080\r\n\r\n"
                #400 Bad Request
                elif userInput == "2":
                    sentence = "GET /dashboard/ HTTP/1.1\r\n HOST:127.0.0.1\r\n" \
                    "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) " \
                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 " \
                    "Safari/537.36 Edg/111.0.1661.41\r\n" \
                    "Accept: text/html,application/xhtml+xml,application/xml;" \
                    "q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n" \
                    "Accept-Language: pt-PT,pt;q=0.9,pt-BR;q=0.8,en;q=0.7,en-US;q=0.6,en-GB;q=0.5,da;q=0.4\r\n" \
                    "Accept-Encoding: gzip, deflate, br\r\n" \
                    "Connection: keep-alive\r\n\r\n"
                #404 Not Found
                elif userInput == "3":
                    sentence = "GET /a/dashboard HTTP/1.1\r\n" \
                    "Host: localhost:8080\r\n\r\n"

                #Envio da mensagem codificada
                clientSocket.send(sentence.encode())

                #Mensagem Recebida, enviada pelo Servidor
                modifiedSentence = clientSocket.recv(1024)

                #Imprimir mensagem do Servidor, descodificada
                print ('From Server:', modifiedSentence.decode())

                #Fecho do Socket
                clientSocket.close()
                print()

#Correr o código
cliente = Client()
cliente.main()