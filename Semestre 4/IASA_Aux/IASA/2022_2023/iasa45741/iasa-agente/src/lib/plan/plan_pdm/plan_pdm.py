from ..planeador import Planeador
from lib.pdm.pdm import PDM
from .modelo_pdm_plan import ModeloPDMPlan
class PlanPDM(Planeador):
    def __init__(self):
        self._gamma = 0.8
        self._delta_max = 0.2
        self._utilidade = {}
        self._politica = {} # Politica de decisão das ações
    
    # Planea a resolução de um problema com base num plano
    def planear(self,estado,modelo_plan,objectivos):
        self._modelo_plan = ModeloPDMPlan(modelo_plan,objectivos)
        self._pdm = PDM(self._modelo_plan,self._gamma, self._delta_max)
        self._utilidade, self._politica = self._pdm.resolver()

    # A politica sabe qual o operador a executar para cada estado. Esta politica foi calculada com base em PDM e têm apenas as ações mais uteis para cada estado (posicao)
    def obter_accao(self, estado):
        if self._politica:
            return self._politica.get(estado)    
    
    def plano_valido(self,estado):
        if(self._politica and self._politica[estado].aplicar(estado)):
            return True
        return False

    def terminar_plano(self):
        self._politica = {}

    def mostrar(self, vista):
        vista.mostrar_valor(self._utilidade)
        vista.mostrar_politica(self._politica)