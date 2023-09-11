from abc import ABC, abstractmethod
from no import No

class MecanismoProcura(ABC):

    def __init__(self, fronteira):
        self._fronteira = fronteira

    #Iniciar a Fronteira de Exploração.
    #É a nossa memória
    def _iniciar_memoria(self):
        pass

    @abstractmethod
    def _memorizar(self, no):
        pass

    def procurar(self, problema):
        self._iniciar_memoria()
        no = No(problema.estado_inicial())
        self._fronteira.inserir(no)

        #while self._fronteira.vazia() == False:
            #se for objectivo
            #no_sucessor = self._fronteira.remover()
            #if no_sucessor.objectivo()
            #return Solucao(no_sucessor)
            #else:
            #self._expandir(problema, no_sucessor)

    #Método concluído
    #Criação de um novo Nó, que possui o estado anterior, o operador associado e o estado anterior
    def _expandir(self, problema, no):
        for operador in problema.operadores:
            estado_suc = operador.aplicar(no.estado)
            if estado_suc is not None:
                yield No(estado_suc, operador, no) 
                