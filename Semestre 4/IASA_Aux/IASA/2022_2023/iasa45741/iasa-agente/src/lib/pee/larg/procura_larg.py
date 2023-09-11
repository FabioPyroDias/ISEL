from ..prof.procura_grafo import ProcuraGrafo
from ..mec_proc.fronteira.fronteira_fifo import FronteiraFIFO

class ProcuraLarg(ProcuraGrafo):
    def _iniciar_fronteira(self):
        return FronteiraFIFO()
