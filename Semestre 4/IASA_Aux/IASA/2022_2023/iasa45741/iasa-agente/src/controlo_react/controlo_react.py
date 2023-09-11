from sae import Simulador 
from sae import Controlo
from ecr.hierarquia import Hierarquia

class ControloReact(Controlo):
    
    def __init__(self, comportamento):
        self.__comportamento = comportamento
        self.mostrar_per_dir = True

    def processar(self, percepcao):
        # Return ação gerada por um comportamento (abstração do comportamento)
        return self.__comportamento.activar(percepcao)




