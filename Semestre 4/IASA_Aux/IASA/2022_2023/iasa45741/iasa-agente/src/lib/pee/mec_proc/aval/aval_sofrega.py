from .aval_heur import AvalHeur

#f(n) = h(n) -> Função de avaliação = a função de heuristica
class AvalSofrega(AvalHeur):
    def prioridade(self, no):
        return self._heuristica.h(no.estado)