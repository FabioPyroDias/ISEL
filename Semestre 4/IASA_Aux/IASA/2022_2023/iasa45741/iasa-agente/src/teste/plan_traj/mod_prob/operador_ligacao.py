from pee.mod.operador import Operador 
from .estado_localidade import EstadoLocalidade

class OperadorLigacao(Operador):
    def __init__(self, origem, destino, custo):
        self.origem = EstadoLocalidade(origem)
        self.destino = EstadoLocalidade(destino)
        self._custo = custo

    def custo(self, estado, estado_suc):
       return self._custo
    
  
    def aplicar(self, estado):
        if (estado == self.origem):
            return self.destino
        
        return None