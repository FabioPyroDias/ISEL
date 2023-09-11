from math import sqrt

from pee.mod.operador import Operador
from sae.ambiente.elemento import Elemento

class OperadorMover(Operador):
    def __init__(self, modelo_mundo, ang):
        self._modelo_mundo = modelo_mundo
        self._ang = ang
        self._accao = None # Dúvida, do tipo Ação, o que é a ação do operador mover (?)

    def aplicar(self, estado):
        # Deve mudar o estado do o agente para um novo estado apenas se n
        elemento = self._modelo_mundo.obter_elemento(estado)

        #If elemento é obstaculo ou agente nao aplicar. Obter estas constantes de algum lado
        if elemento not in [Elemento.OBSTACULO, Elemento.AGENTE]:
            return None

        return estado

    
    def custo(self, estado, estado_suc):
        # Calcula o custo de mover para uma determinada posição através da distancia entre duas posições
        # Distancia euclidiana
        return sqrt( ( estado.posicao.x-estado_suc.posicao.x ) ** 2 + ( estado.posicao.y-estado_suc.posicao.y ) ** 2   )

    def ang(self):
        return self._ang
    

    def accao(self):
        return self._accao