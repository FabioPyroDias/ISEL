from .procura_prof_lim import ProcuraProfLim
from abc import abstractmethod


class ProcuraProfIter(ProcuraProfLim):
    def resolver(self, problema, prof_max=1000, inc_prof=1): 
        # Vai resolver um problema a cada profundidade até atingir a prof máxima
        # TODO: Talvez seja melhor fazer este incremento enquanto n encontrar uma solução
        for profundidade in range(inc_prof, prof_max + 1, inc_prof):
            solucao = super().resolver(problema, profundidade)
            return solucao
    