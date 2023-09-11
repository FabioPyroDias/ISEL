from abc import abstractclassmethod, ABC

class MemoriaAprend(ABC):

    @abstractclassmethod
    def q(self, estado, accao):
        pass

    @abstractclassmethod
    def actualizar(self, s, a,q):
        pass

    @abstractclassmethod
    def obter_estados(self):
        pass