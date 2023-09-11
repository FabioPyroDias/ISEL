from .avaliador import Avaliador

# Avaliador de custo uniforme. f(n) = g(n), função de avaliação igual ao custo
class AvalCustoUnif(Avaliador):
    def prioridade(self, no):
        return no.custo