from abc import abstractmethod
from .no import No
from ..mod.solucao import Solucao

class MecanismoProcura():
    def __init__(self):
        self._fronteira = self._iniciar_fronteira()

    def resolver(self, problema, prof_max=1000):
        self.problema = problema
        no_inicial = No(problema.estado_inicial)
        self._fronteira.inserir(no_inicial)

        
        while not self._fronteira.vazia():
            no = self._fronteira.remover()
            
            if problema.objectivo(no.estado):
                return Solucao(no)
            else:
                for no_sucessor in self._expandir(problema, no):
                    self._memorizar(no_sucessor)
                    
        return None	
    
    @abstractmethod
    def _iniciar_fronteira(self):
        pass

    # Itera sobre os operadores de forma "descobrir" os nós seguintes
    def _expandir(self,problema, no):
        for operador in problema.operadores:
            estado_suc = operador.aplicar(no.estado)
            if(estado_suc is not None):
                yield No(estado_suc, operador, no)


    @abstractmethod
    def _memorizar(no):
        pass