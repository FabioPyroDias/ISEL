from abc import ABC, abstractmethod

class AgenteSimul(ABC):
    @abstractmethod
    def iniciar(self):
        """Iniciar execução"""
    
    @abstractmethod
    def executarPasso(self):
        """
        Executar passo de processamento
        """        