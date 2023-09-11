from .procura_informada import ProcuraInformada
from pee.mec_proc.aval.aval_aa import AvalAA
class ProcuraAA(ProcuraInformada):
    def __init__(self, heuristica):
        super().__init__(heuristica)

    def iniciar_avaliador(self):
        return AvalAA(self._heuristica)