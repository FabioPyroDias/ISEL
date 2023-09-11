from abc import ABC, abstractmethod

class Operador(ABC):

    @abstractmethod
    def aplicar(self,estado):
        # Recebe um estado seguinte e transforma o estado atual para estado seguinte
        pass 

    @abstractmethod
    def custo(self,estado, estado_suc):
        # Calcula o custo de uma transformação de estados
        pass 
