from abc import ABC, abstractmethod

class Planeador(ABC):
    @abstractmethod
    def planear(self, modelo_plan, objectivos):
        pass

    @abstractmethod
    def obter_accao(self, estado):
        pass

    @abstractmethod
    def plano_valido(self, estado):
        pass
    
    @abstractmethod
    def terminar_plano(self):
        pass