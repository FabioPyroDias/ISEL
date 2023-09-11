from .procura_melhor_prim import ProcuraMelhorPrim

class ProcuraInformada(ProcuraMelhorPrim):
    def __init__(self, heuristica):
        self._heuristica = heuristica # Incorporar a heuristica dentro da classe para se conseguir usar no iniciar_avaliador ( que precisa da heuristica)
        super().__init__()
        
    def resolver(self, problema, heuristica):
        return super().resolver(problema)
