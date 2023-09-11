from .procura_informada import ProcuraInformada
from pee.mec_proc.aval.aval_sofrega import AvalSofrega
class ProcuraSofrega(ProcuraInformada):
    def iniciar_avaliador(self):
        return AvalSofrega(self._heuristica)
        