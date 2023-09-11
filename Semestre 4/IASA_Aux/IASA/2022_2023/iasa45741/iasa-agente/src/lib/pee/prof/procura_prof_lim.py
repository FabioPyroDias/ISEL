from pee.mec_proc.no import No
from pee.mod.solucao import Solucao
from .procura_prof import ProcuraProf
from abc import abstractmethod


class ProcuraProfLim(ProcuraProf):
    # TODO: Este método partilha código com o Mec_Procura. Ver se é possivel meter as linhas adicionais no mec_procura e evitar a duplicação aqui. O mec_procura passa a ter o conceito de profundidade
    def resolver(self, problema, prof_max=1000):
        self._prof_max = prof_max
       
        no_inicial = No(problema.estado_inicial) # Cria o nó inicial da fronteira
        self._fronteira.inserir(no_inicial)  #Insere para depois ser valiado

        
        while not self._fronteira.vazia(): 
            no = self._fronteira.remover()

            if no.profundidade > prof_max:  # Não avalia nós que estejam fora da profundidade máxima de procura
                return None 

            if problema.objectivo(no.estado):
                return Solucao(no)

            else:
                    for no_sucessor in self._expandir(problema, no):
                        self._fronteira.inserir(no_sucessor)

    # Expande os nós que estejam dentro da profundudade
    def _expandir(self, problema, no):
        for operador in problema.operadores:
            estado_suc = operador.aplicar(no.estado)
            # TODO: Validar se o algoritmo entra em recursividade 

            if(estado_suc is not None and no.profundidade < self._prof_max):
                yield No(estado_suc, operador, no)
