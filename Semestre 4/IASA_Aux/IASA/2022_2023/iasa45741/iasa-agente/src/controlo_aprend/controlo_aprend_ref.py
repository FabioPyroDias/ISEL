import imp
from sae import Controlo
from .mec_aprend import MecAprend
from sae.ambiente.direccao import Direccao
from .mec_aprend import MecAprend
from sae import Accao
from pee.mod.agente.estado_agente import EstadoAgente
from time import sleep
import os

class ControloAprendeRef(Controlo):
    
    def __init__(self):
        self._rmax = 100
        self._rmin = 1
        self._s = None # Estado
        self._a = None # Accao

        accoes = [Accao(dir) for dir in Direccao]

        self._mec_aprend = MecAprend(accoes)

    # "Cerebro" do agente. Agarra a percepção e calcula uma acção
    def processar(self, percepcao):

        prox_estado = EstadoAgente(percepcao.posicao) # Iniciar S
       
        if(self._s is not None):
            reforco = self._gerar_reforco(percepcao) # Gerar o reforço
            self._mec_aprend.aprender(self._s, self._a, reforco, prox_estado) # Aprender com base no algoritmo E greedy
            
        prox_accao = self._mec_aprend.selecionar_accao(prox_estado) # Politica de seleção E greedy
        self._a = prox_accao

        self._s = prox_estado
        
        self._mostrar()
        return prox_accao
    
    # Calcular um reforco. Custo do movimento (negativo), recompensa maxima se recolher alvo e  recompensa maxima negativa se colidir
    def _gerar_reforco(self, percepcao):
        reforco = -self._rmin # Custo do movimento
        
        if(percepcao.recolha):
            reforco += self._rmax # Recompensa
        elif(percepcao.colisao):
            reforco -= self._rmax # Castigo por colidir

        return reforco

    def _mostrar(self):
        estados = self._mec_aprend.estados
       
        politica = { s: self._mec_aprend.accao_sofrega(s)
                    for s in estados }

        valor_estado = {s: self._mec_aprend.q(s, politica[s])
                        for s in estados}
        self.vista.limpar()
        self.vista.mostrar_valor(valor_estado)
        self.vista.mostrar_politica(politica)
