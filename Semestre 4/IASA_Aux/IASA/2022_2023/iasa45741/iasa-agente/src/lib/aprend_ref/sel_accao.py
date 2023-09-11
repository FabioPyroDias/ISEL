from abc import abstractclassmethod, ABC

class SelAccao(ABC):
    @abstractclassmethod
    def selecionar_accao(self, s):
        pass