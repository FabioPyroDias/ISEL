from ecr.comportamento import Comportamento
from abc import abstractmethod

'''
Dado que um Comportamento Composto é definido por um ou mais Comportamentos,
esta classe é a que vai ser instanciada.

Adicionalmente, este é Comportamento Composto é constítuido por vários Comportamentos.
A decisão da Acção deste Comportamento Composto é a partir da "Mecânica de Selecção de Acção".
Existem três destas mecânicas:
- Hierarquia, Supressão e Substituição de Comportamentos.
- Prioridade, A Resposta provém da prioridade mais elevada, que pode variar ao longo do tempo
- Fusão, Composição (Soma Vectorial)
'''
class ComportComp(Comportamento):

    #Estes comportamentos são "sub-comportamentos".
    #É a partir deste conjunto que será decidida a Acção a tomar.
    __comportamentos = 0

    #Passar os comportamentos que constituem este Comportamento Composto
    def __init__(self, comportamentos):
        self.__comportamentos = comportamentos
    
    #Este método vai activar todos os comportamentos de forma a recolher as suas Acções, caso tenha.
    #Passa esta lista de comportamentos para o método seleccionar_accao() que será implementado
    #posteriormente pela Hierarquia e Prioridade. (Mecânismo de Selecção de Acção)
    #O retorno do seleccionar_accao() é a acção retornada por este método também
    def activar(self, percepcao):

        accoesLista = []

        for comportamento in self.__comportamentos:
            accoesLista.append(comportamento.activar(percepcao))

        return self.seleccionar_accao(accoesLista) #return accao
    
    '''
    Este método será implementado pelas classes que derivem desta, ou seja, a Hierarquia e Prioridade.
    Isto porque o seu mecanismo de selecção de acção é diferente.
    A Hieraquia usará uma Arquitectura de Subsunção enquanto a Prioridade testa a "importância"
    de cada acção e devolve o mais importante/urgente. 
    '''
    @abstractmethod
    def seleccionar_accao(accoes):
        pass