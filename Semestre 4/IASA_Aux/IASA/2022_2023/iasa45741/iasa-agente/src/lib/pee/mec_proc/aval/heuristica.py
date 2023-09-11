from abc import ABC, abstractmethod

class Heuristica(ABC):

    # Função que estima o custo até ao objetivo (estado)
    @abstractmethod
    def h(estado):
        pass