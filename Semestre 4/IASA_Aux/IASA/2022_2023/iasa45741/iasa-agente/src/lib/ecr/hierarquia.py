from .comport_comp import ComportComp
from abc import abstractclassmethod

# Método de seleção de ação heirarquico.
# Seleciona uma ação com base numa ordem hierárquica (seleção por subsuncao)
class Hierarquia(ComportComp):
    def selecionar_accao(self, accoes): # Acções ordenadas de forma hierárquica 
        return accoes[0]
