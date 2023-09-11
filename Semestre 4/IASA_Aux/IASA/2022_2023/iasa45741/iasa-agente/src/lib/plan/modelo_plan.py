from abc import ABC, abstractmethod

class ModeloPlan(ABC):
    @abstractmethod
    def estado(self):
        pass

    @abstractmethod
    def estados(self):
        pass
    
    @abstractmethod
    def operadores(self):
        pass