from math import sqrt

from pee.mod.operador import Operador
from sae.ambiente.elemento import Elemento
from sae.agente.accao import Accao
from sae.ambiente.direccao import Direccao
from .estado_agente import EstadoAgente
import math
class OperadorMover(Operador):
    def __init__(self, modelo_mundo, ang):
        self._modelo_mundo = modelo_mundo
        self._ang = ang
        self._accao = Accao(ang)
        
    def aplicar(self, estado):
        # Deve mudar o estado do o agente para um novo estado apenas se n
        elemento = self._modelo_mundo.obter_elem(estado.posicao)

        #If elemento é obstaculo ou agente nao aplicar a alteração de estado
        if elemento is Elemento.OBSTACULO:
            return None
        
        nova_posicao = self._mover_equacao(estado.posicao)
        novo_estado = EstadoAgente(nova_posicao)
        if(novo_estado not in self._modelo_mundo.estados):
            return None
        
        return novo_estado


    def custo(self, estado, estado_suc):
        # Calcula o custo de mover para uma determinada posição através da distancia entre duas posições
        # Distancia euclidiana
        return sqrt(( estado.posicao[0] - estado_suc.posicao[0] ) ** 2 )+ (( estado.posicao[1] - estado_suc.posicao[1] ) ** 2 )  

    @property
    def ang(self):
        return self._ang.value
    
    @property
    def accao(self):
        return self._accao
        
    # Retornam apenas posições onde o agente se pode mover
    def _mover_burro(self, posicao):
        novo_pos = posicao

        (pos_x, pos_y) = posicao    
        # Mover em X
        if(self._ang == Direccao.ESTE):
            novo_pos = (pos_x+1, pos_y)
        elif(self._ang == Direccao.OESTE):
            novo_pos = (pos_x-1,pos_y)

        # Mover em Y
        if(self._ang == Direccao.NORTE):
            novo_pos = (pos_x, pos_y+1)
        elif(self._ang == Direccao.SUL):
            novo_pos = (pos_x, pos_y-1)

        elemento = self._modelo_mundo.obter_elem(novo_pos)
        if elemento is not Elemento.OBSTACULO:
            return novo_pos
        else:
            return None

    def _mover_equacao(self, pos):
        x, y = pos
        
        dx = math.cos(self._ang.value)
        dy = -math.sin(self._ang.value)

        novo_pos = ( x + round(dx), y + round(dy))

        return novo_pos