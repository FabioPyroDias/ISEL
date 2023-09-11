from abc import ABC, abstractmethod

# Abstração de varias reações
# Vai implementar o mecasmimo que perceciona uma percepcao
class Comportamento(ABC):

    @abstractmethod
    def activar(self,percepcao):
        pass #Metodo abstrato: Este método retorna uma Ação