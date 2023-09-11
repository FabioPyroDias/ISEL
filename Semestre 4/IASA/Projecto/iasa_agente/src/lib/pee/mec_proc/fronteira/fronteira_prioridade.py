from fronteira import Fronteira
from avaliador import Avaliador

class FronteiraPrioridade(Fronteira, Avaliador):

    def __init__(self, avaliador):
        self.__avaliador = avaliador

    def inserir(self, no):
        return super().inserir(no)
    
    def remover(self):
        pass