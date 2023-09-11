import json
from pickle import NONE
class PDM:
    def __init__(self, modelo, gamma, delta_max):
        self._gamma = gamma # Valor que desconta na recompensa ao logo do tempo. Desvaloriza as recomepnsas que acontecem mais tarde. Entre 0 e 1
        self._delta_max = delta_max 
        self._modelo = modelo;

    # Função de utilidade
    # Calcula a utilidade do espaço de estados e retorna  um mapa com utilidade máxima
    # Parametros opcionais para conseguir testar manualmente sem correr o agente
    def utilidade(self, S = None, A = None):

        if A is None:
            A = self._modelo.A

        if S is None:
            S = self._modelo.S # Espaço de estados

        U = {s : 0 for s in S()}  # Espaço de estados. Cria uma lista que depois vai mapear com a utilidade de uma ação
        
        while True:
            U_anterior = U.copy()
            delta = 0
            # Para cada estado calcular a utilidade de cada açção e obter a ação com máxima utilidade              
            for estado in S():
                U[estado] = max(self.util_accao(estado, accao, U_anterior) for accao in A(estado)) # Para cada ação calcular qual a mais util
                delta = max(delta, abs(U[estado] - U_anterior[estado])) # Calcular novo delta
            
            if delta < self._delta_max:
                # Encontrou uma solução ideal
                print("Delta: " + str(delta))
                break

        return U

    # Calcula a utilidade de tomar uma determinada decisão
    # s -> Estado
    # a -> acao
    def util_accao(self, s, a, U, T  = None, R = None):

        if( T is None):
            T = self._modelo.T

        if(R is None):
            R = self._modelo.R
        
        soma = 0

        # Calcula a utilidade de várias ações para transitar para o estado seguinte
        for probabilidade, s_linha in T(s, a):
           
            if(s_linha in U):
                soma = soma +  probabilidade * (R(s, a, s_linha) + self._gamma * U[s_linha]) # Erro: U rebenta quando não tem s_linha no seu mapa

        return soma

    # Regras de decisão que determinam a ação (operador) a ser executada. Maximizam para o estado mais útil
    def politica(self, U, S = None, A = None):
        
        if A is None:
            A = self._modelo.A

        if S is None:
            S = self._modelo.S # Espaço de estados

        politica = {}
        for s in S():
            operador = max(A(s), key=lambda a: self.util_accao(s, a, U))  # Retorna o operador/ação com maior utilidade
            politica[s] = operador
        return politica

    def resolver(self, S = None , A = None , T  = None, R = None):
        utilidade = self.utilidade(S,T)
        politica = self.politica(utilidade,S,A)
        return ( utilidade, politica )
