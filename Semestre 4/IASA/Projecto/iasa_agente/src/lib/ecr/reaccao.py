from ecr.comportamento import Comportamento

'''
Tal como no caso do outro agente, este agente tem de processar a informação vinda de fora
(Percepção) e ter um comportamento apropriado (Acção).
No outro agente, esta classe foi denominada Controlo. Dado que pretendemos ter um agente 
reactivo, faz sentido chamar Reaccao a este mecanismo de decisão.
'''
class Reaccao(Comportamento):

    #É necessário a reacção ter uma representação interna do estímulo.
    __estimulo = 0

    #Como mencionado acima, também é necessário a reacção possuir uma representação interna da acção.
    __resposta = 0

    #É aqui que a classe recebe o estimulo.
    #Cada reacção tem é composta por um Estimulo e por uma Resposta.
    #O Estímulo vem da Percepção exterior e a Resposta dá origem a uma Acção 
    #A razão de ser uma agregação é exactamente para reduzir o acoplamento.
    def __init__(self, estimulo, resposta):
        self.__estimulo = estimulo
        self.__resposta = resposta

    #Caso a intensidade do estímulo, que por sua vez provém da percepção, 
    #seja maior que 0, ou seja, se possuir uma maior prioridade do que 
    #a acção que já está a tomar actualmente, seja ela qual for, esta entra em acção.
    #Resumidamente, dependendo da intensidade recebida, tem de devolver um acção com uma intensidade do mesmo nível.
    def activar(self, percepcao):
        intensidade = self.__estimulo.detectar(percepcao)

        if intensidade > 0:
            return self.__resposta.activar(percepcao, intensidade)