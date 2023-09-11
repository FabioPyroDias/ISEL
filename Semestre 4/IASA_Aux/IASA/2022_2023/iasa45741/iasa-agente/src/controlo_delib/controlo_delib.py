from controlo_delib.modelo_mundo import ModeloMundo
from sae import Simulador 
from sae import Controlo
from sae import Elemento
from ecr.hierarquia import Hierarquia
from math import sqrt
class ControloDelib(Controlo):
    
    def __init__(self, planeador):
        self._planeador = planeador
        self._objectivos = [ ] # Array que vai guardar todos os estados finais
        self._modelo_mundo = ModeloMundo()

    def processar(self, percepcao):
        # Algoritmo de agentes deliberativos - assimular
        self._assimilar(percepcao) # fazer com que o modelo do mundo = percepção
        if(self._reconsiderar()): # Perceber se o é preciso procurar uma nova solução
            self._deliberar() # Encontrar um novo objetivo
            self._planear() # Planear o percurso para o objetivo

        accao = self._executar() # Executar as várias ações do plano
        self.mostrar() # Atualizar vista do controlo deliberativo
        return accao


    # Atualizar mapa "mental" do mundo do agente
    def _assimilar(self, percepcao):
        # O modelo do mundo é que o que agente percepciona
        self._modelo_mundo.actualizar(percepcao)

    # Validar se é preciso planear para novos objetivos
    # Retorna boolean true se mundo alterado ou plano inválido (?)
    def _reconsiderar(self):
        return not self._objectivos or not self._planeador.plano_valido(self._objectivos[0]) or self._modelo_mundo.alterado

    # Obtem novos objectivos
    def _deliberar(self):
        # Improv: Ordenar os objetivos a partir do objetivo atual
        obj = [estado for estado in self._modelo_mundo.estados if self._modelo_mundo.obter_elem(estado.posicao) == Elemento.ALVO]
        self._objectivos = obj

    # Planeia com os noovos objectivos, ou se já n tiver objetivos, termina o plano
    def _planear(self):
        if(self._objectivos):
            self._planeador.planear(self._modelo_mundo.estado, self._modelo_mundo , self._objectivos) 
        else:
            self._planeador.terminar_plano()

    def _executar(self):
        # Obtem um operador do plano
        operador = self._planeador.obter_accao(self._modelo_mundo.estado)
        if operador is not None:
            return operador.accao

    def mostrar(self):
        self.vista.limpar() # Vista herdada pelo Controlo
        self._modelo_mundo.mostrar(self.vista)
        self._planeador.mostrar(self.vista)
        self.vista.mostrar_estados(self._objectivos)
