from .comport_comp import ComportComp
from abc import abstractclassmethod

# Método de seleção de ação por proridade.
# Seleciona uma ação com base no comportamento com mais prioridade
class Prioridade(ComportComp):
    def selecionar_accao(self, accoes):
        return max(accoes, key=lambda accao: accao.prioridade) # Escolher a ação com o maior valor de prioridade
            
