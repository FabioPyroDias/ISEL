from abc import ABC, abstractmethod

# Avaliador depende do tipo de procura. F(n) - a função que avalia o estado nas procuras de melhor primeiro e derivadas e custo uniforme
# Mover para pasta melhor_prim/fronteira quando for para implementar pee2
class Avaliador(ABC):

    @abstractmethod
    def prioridade(self, no):
        pass
    