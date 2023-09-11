from abc import ABC, abstractmethod

class Avaliador(ABC):

    @abstractmethod
    def prioridade(self, no):
        pass