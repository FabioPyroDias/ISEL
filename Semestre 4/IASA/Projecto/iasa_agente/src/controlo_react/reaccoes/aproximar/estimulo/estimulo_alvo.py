from ecr.estimulo import Estimulo
from lib.sae import Elemento

#Este Estímulo simplesmente determina onde se encontra um alvo,
#definindo a prioridade para uma Resposta.
#Lembrar que cada Reacção possui um Estímulo (este), e uma Resposta (que possui uma Acção)
#É aqui que vai ser obtido a prioridade deste Estímulo.
#Por outras palavras, estou a determinar a prioridade da Resposta com base neste Estímulo.
#Exemplo: Detectei o Alvo. Qual é a prioridade para me aproximar do mesmo?
class EstimuloAlvo(Estimulo):

    __direccao = 0
    __gama = 0

    def __init__(self, direccao, gama=0.9):
        self.__direccao = direccao
        self.__gama = gama

    def detectar(self, percepccao):
        elemento, distancia, posicao = percepccao[self.__direccao]

        #É aqui que é calculada a prioridade deste estímulo.
        #Este valor vai ser considerado no método Activar, da classe Reaccao
        return self.__gama ** distancia if elemento == Elemento.ALVO else 0