from plan.modelo_plan import ModeloPlan
from .estado_agente import EstadoAgente
from sae.ambiente.direccao import Direccao
from .operador_mover import OperadorMover
class ModeloMundo(ModeloPlan):
    
    def __init__(self):
        self._estado = None # do tipo EstadoAgente
        self._estados = [] #do tipo EstadoAgente[]
        self._operadores = [OperadorMover(self, ang) for ang in [Direccao.ESTE, Direccao.NORTE, Direccao.OESTE, Direccao.SUL]]
        self._elementos = {} # { Estado<x,y>: Elemento }
        self._alterado = False 

    def actualizar(self, percepcao):
        # Atualiza o modelo do mundo com base numa percepção
        self._estado = EstadoAgente(percepcao.posicao)
        if percepcao.elementos != self._elementos:
            # criar array de estados a partir das posições
            self._estados = []   
            self._elementos = percepcao.elementos
            for posicao in percepcao.posicoes:
                self._estados.append(EstadoAgente(posicao))                
            self._alterado = True
        else: 
            self._alterado = False

    @property
    def estado(self):
        return self._estado
    
    @property
    def estados(self):
        return self._estados
    
    @property
    def operadores(self):
        return self._operadores

    # Obtem o elemento numa determinada posição (Estado)
    def obter_elem(self, estado):
        elemento = self._elementos.get(estado)
        if elemento:
            return elemento

    @property
    def elementos(self):
        return self._elementos

    @property
    def alterado(self):
        return self._alterado
    
    def mostrar(self, vista):
        vista.mostrar_alvos_obst(self._elementos)
        vista.marcar_posicao(self._estado.posicao)

