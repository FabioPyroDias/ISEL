from abc import abstractmethod
from .operador import Operador
class Estado():
   
    @abstractmethod
    def id_valor(self):
        # Maneira de identificar um estado unicamente
        pass
    
    def __hash__(self):
        # Permite a comparação entre duas hashes com tipos primitivos
        return self.id_valor()

    def __eq__(self, other):
        # Compara o um estado com outro. Retorna Boolean
        return self.__hash__() == other.__hash__()
        

        
