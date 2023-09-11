from procura_profundidade import ProcuraProfundidade
from mec_proc import No

class ProcuraProfLim(ProcuraProfundidade):
    
    prof_max = 0
    
    def __init__(self, prof_max=100):
        super.__init__()
        self.__prof_max = prof_max
    
    @property
    def prof_max(self):
        return self.__prof_max
    
    @prof_max.setter
    def prof_max(self, valor):
        self.__prof_max = valor

    def _expandir(self, problema, no):
        if no.profundidade < self.prof_max:
            yield super._expandir(problema, no)

    def _memorizar(self, no):
        if self._ciclo(no):
            super()._memorizar(no)

    def _ciclo(self, no):
        pass