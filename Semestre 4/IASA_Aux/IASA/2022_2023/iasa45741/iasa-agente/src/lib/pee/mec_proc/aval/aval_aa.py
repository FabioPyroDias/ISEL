from .aval_heur import AvalHeur

#f(n) = g(n) + h(n) -> Soma do custo do nó e heuristica
class AvalAA(AvalHeur):
    def prioridade(self, no):
        return no.custo + self._heuristica.h(no.estado)