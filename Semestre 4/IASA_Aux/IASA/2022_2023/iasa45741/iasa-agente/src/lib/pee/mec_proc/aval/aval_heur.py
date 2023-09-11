from .avaliador import Avaliador
class AvalHeur(Avaliador):
    def __init__(self, heuristica):
        self._heuristica = heuristica # heuristica do tipo heuristica
