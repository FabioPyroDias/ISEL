from pee.mec_proc.aval.heuristica import Heuristica
from math import sqrt
class HeurDist(Heuristica):
    def __init__(self, estado_final):
        self._estado_final = estado_final
    
    # Função que estima o custo até ao objetivo (estado). O custo é a distancia euclid do estado incial ao final.
    def h(self, estado):
        return sqrt( ( self._estado_final.posicao[0]-estado.posicao[0] ) ** 2 + ( self._estado_final.posicao[1]-estado.posicao[1] ) ** 2   )
