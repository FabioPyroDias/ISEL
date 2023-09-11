from abc import abstractmethod
from ..mec_proc.mec_procura import MecanismoProcura
from ..mec_proc.fronteira.fronteira_lifo import FronteiraLIFO

class ProcuraProf(MecanismoProcura):
    def _iniciar_fronteira(self):
        return FronteiraLIFO() # Utiliza a ordenação LIFO na procura em profundidade

    def _memorizar(self, no):
        self._fronteira.inserir(no)