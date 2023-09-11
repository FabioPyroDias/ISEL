from .procura_melhor_prim import ProcuraMelhorPrim
from ..mec_proc.aval.aval_custo_unif import AvalCustoUnif

class ProcuraCustoUnif(ProcuraMelhorPrim):
    def __init__(self):
        super().__init__()
        
    def iniciar_avaliador(self):
        return AvalCustoUnif() # Inicia um avaliador do tipo custo uniforme
