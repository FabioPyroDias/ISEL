from ..mec_proc.mecanismo_procura import MecanismoProcura

#Lembrança: Esta classe não é abstracta
#I
class ProcuraGrafo(MecanismoProcura):

    def _iniciar_memoria(self, fronteira):
        fronteira.iniciar()
        self._explorados = []

    def _memorizar(self, no):
        return super()._memorizar(no)
    
    def _manter(self, no):
        pass