from pee.melhor_prim.procura_aa import ProcuraAA

from .heur_dist import HeurDist
from .problema_plan import ProblemaPlan
from ..planeador import Planeador
from math import sqrt
import time
class PlanPEE(Planeador):

    # Construtor como no UML. Fica complicado experimentar várias procuras sem ter de vir aqui mudar a procura manualmente
    def __init__(self):
        self._solucao = None
        self._mec_pee = None
    
    # Construtor que deixa passar um metodo de procura para ser mais fácil de testar
    def __init__(self, metodo_procura, usar_heuristica = False): #
        self._solucao = None
        self._mec_pee = None 

        self._metodo_procura = metodo_procura
        self._usar_heuristica = usar_heuristica

    # Construtor como no UML. Fica complicado experimentar várias procuras sem ter de vir aqui mudar a procura manualmente
    def planear_uml(self, estado_inicial, modelo_plan, objectivos):
        
        estado_final = objectivos[0]; 
        
        heur = HeurDist(estado_final)
        
        self._mec_pee = ProcuraAA(heur)
        problema = ProblemaPlan(estado_inicial, modelo_plan, estado_final) 
        self._solucao = self._mec_pee.resolver(problema, heur)
        
    def planear(self, estado_inicial, modelo_plan, objectivos):
        # Ordenar pelos os estados mais pertos para facilitar a resolução
        # objectivos.sort(key=lambda objetivo: sqrt(( estado_inicial.posicao[0] - objetivo.posicao[0] ) ** 2 ) + (( estado_inicial.posicao[1] - objetivo.posicao[1] ) ** 2 ) )

        estado_final = objectivos[0]; 
        
        if(self._usar_heuristica):
            heur = HeurDist(estado_final)
            self._mec_pee = self._metodo_procura(heur) 
            problema = ProblemaPlan(estado_inicial, modelo_plan, estado_final) 
            self._solucao = self._mec_pee.resolver(problema, heur)
        else:
            self._mec_pee = self._metodo_procura() 
            problema = ProblemaPlan(estado_inicial, modelo_plan, estado_final) 
            self._solucao = self._mec_pee.resolver(problema)


    def obter_accao(self, estado):
        passo_solucao = None
        if self._solucao:
            passo_solucao = self._solucao.remover_passo()
            if(passo_solucao):
                return passo_solucao.operador

    def plano_valido(self,estado):
        return self._solucao is not None and len(self._solucao) > 0

    def terminar_plano(self):
        self._solucao = None;

    def mostrar(self, vista):
        vista.mostrar_solucao(self._solucao)