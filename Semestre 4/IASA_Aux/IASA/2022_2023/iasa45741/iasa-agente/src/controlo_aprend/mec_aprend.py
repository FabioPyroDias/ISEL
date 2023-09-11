from aprend_ref.memoria_esparsa import MemoriaEsparsa
from aprend_ref.sel_accao_egreedy import SelAccaoEGreedy
from aprend_ref.aprende_q import AprendQ

class MecAprend():
    
    def __init__(self, accoes, alfa = 0.5, gamma = 0.9, epsilon = 0.1):
        self._accoes = accoes
        self._alfa = alfa # Fator de aprendizagem
        self._gamma = gamma # Fator de decaimento
        self._epsilon = epsilon # Probabilidade de explorar uma acçao vs aproveitar o que já aprendeu

        self.accoes = accoes # [ Accao ]

        self._mem_aprend = MemoriaEsparsa()
        self._sel_acao = SelAccaoEGreedy(self._mem_aprend, self._accoes, self._epsilon)
        self._aprend_ref = AprendQ(self._mem_aprend, self._sel_acao, self._alfa, self._gamma)

    @property
    def estados(self):
        return self._mem_aprend.obter_estados()

    # Associa a um par estado-accao um custo ou recompensa à transicao para o estado seguinte 
    def aprender(self, s,a, r, sn):
        self._aprend_ref.aprender(s, a, r, sn)

    # Algoritmo E greedy
    def selecionar_accao(self, s): # s -> Estado
        return self._sel_acao.selecionar_accao(s)

    # Algoritmo E greedy
    def accao_sofrega(self, s): # s -> Estado
        return self._sel_acao.accao_sofrega(s)

    # Obtem o fator Q para o determinado estado/accao
    def q(self, s, a):
        return self._mem_aprend.q(s,a)
