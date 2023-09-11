from abc import ABC, abstractmethod

'''
Transformação de um Estado para o seguinte
'''
class Operador(ABC):

    #O Estado "inicial" do Operador 
    @abstractmethod
    def aplicar(self, estado):
        pass

    #Estado Sucessor = Estado Seguinte
    #O "custo" associado à transição do estado "inicial" para o seguinte.
    @abstractmethod
    def custo(self, estado, estado_suc):
        pass