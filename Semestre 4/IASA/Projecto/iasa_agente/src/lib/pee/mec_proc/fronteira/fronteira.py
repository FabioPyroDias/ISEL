from abc import abstractmethod

class Fronteira:
    
    def __init__(self):
        self.__vazia = False
        self.__nos = []
        pass
    
    @property
    def vazia(self):
        return self.__vazia

    def iniciar(self):
        pass

    @abstractmethod
    def inserir(self, no):
        pass

    def remover(self):
        pass