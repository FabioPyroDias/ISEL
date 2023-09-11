from .sel_accao import SelAccao
from random import random, choice, shuffle

class SelAccaoEGreedy(SelAccao):

    def __init__(self, mem_aprend, accoes, epsilon):
        self._epsilon = epsilon # Probalidade de selecionar uma ação vs explorar
        self._mem_aprend = mem_aprend   
        self._accoes = accoes    

    def selecionar_accao(self, s):
        rand = random() # Probabilidade aleatória
        return self.accao_sofrega(s) if rand > self._epsilon else self.explorar() #Selecionar uma ação com base na estratégia de seleção epsolon Greedy. Sofrega se > epsilon ou explorar se menor 
    
    def accao_sofrega(self, s):
        shuffle(self._accoes) # Reorganiza aleatoriamente as accoes

        # Seleciona a ação com o valor mais alto de Q
        accao = max(self._accoes, key=lambda a : self._mem_aprend.q(s, a))
        return accao
    
    # Seleciona uma ação aleatória
    def explorar(self): 
        return choice(self._accoes)