from ..mec_proc.mec_procura import MecanismoProcura

class ProcuraGrafo(MecanismoProcura):
    
    def _memorizar(self, no):
        # Memoriza nós que ainda não foram explorados
        if self._manter(no):
            self._fronteira.inserir(no)
            self._explorados[no.estado] = no
            
    def _manter(self, no): 
        return no.estado not in self._explorados

    def resolver(self, problema):
        self._explorados = {}
        return super().resolver(problema)
