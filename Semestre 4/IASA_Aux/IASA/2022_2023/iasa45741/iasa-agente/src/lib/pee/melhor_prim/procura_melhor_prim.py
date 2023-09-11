from ..prof.procura_grafo import ProcuraGrafo
from abc import abstractmethod
from ..mec_proc.fronteira.fronteira_prioridade import FronteiraPrioridade

class ProcuraMelhorPrim(ProcuraGrafo):
    def _iniciar_fronteira(self):
            return FronteiraPrioridade(self.iniciar_avaliador())
        
    def _manter(self,no):
        # Manter no array de explorados na altura de pesquisar
        return super()._manter(no)

    
    @abstractmethod
    def iniciar_avaliador(self):
        pass