from abc import ABC, abstractmethod
from sae.agente import transdutor

# ABC torna isto numa classe abstrata
# Vai implementar o mecanismo que efetivamente traduz uma estimulo em resposta, através do trasdutor 
class Estimulo(ABC):

    @abstractmethod
    def detectar(self, percepcao):
        pass
