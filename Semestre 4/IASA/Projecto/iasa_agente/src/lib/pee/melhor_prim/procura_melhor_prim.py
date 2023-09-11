from larg.  procura_grafo import ProcuraGrafo
from abc import ABC
 
class ProcuraMelhorPrim(ProcuraGrafo, ABC):

    def __init__(self, avaliador):
        self.__avaliador = avaliador

    def _manter(self, no):
        return super()._manter(no)