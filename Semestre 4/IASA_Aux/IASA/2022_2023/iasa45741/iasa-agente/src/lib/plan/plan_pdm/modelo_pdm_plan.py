from ..modelo_plan import ModeloPlan
from lib.pdm.pdm import PDM
from lib.pdm.modelo_pdm import ModeloPDM
class ModeloPDMPlan(ModeloPDM):
    def __init__(self, modelo_plan, objectivos):
        self._rmax = 1000 # Valor máximo da recompensa
        self._objectivos = objectivos # List<Estados>
        self._modelo_plan = modelo_plan
    
    @property
    def estado(self):
        return self._modelo_plan.estado

    @property
    def estados(self):
        return self._modelo_plan.estados
    
    @property
    def operadores(self):
        return self._modelo_plan.operadores

    # Espaço de estados do ambiente
    def S(self):
        return self.estados
    
    # Espaço de ações (operadores) que o agente pode efetuar no estado s
    def A(self, s):
        return self.operadores
        
    def T(self, s,a):
        # Função de transição de estados
        # s -> estado atual
        # a -> ação (operador) escolhida
        # s_linha -> próximo estado com base na ação escolhida
        s_linha = a.aplicar(s)
        if(s_linha is None):
            return []

        return [(1, s_linha)]
    
    # Função que determina o custo/recompensa de um de tomar uma transição dado a ação A, e os estados s e s_n
    # Retorna uma recompensa se o estado for um dos estados objetivo, ou custo se não for
    def R(self, s, a, sn):
        s_linha = sn # Para ficar mais parecido às formulas
        recompensa = -a.custo(s,s_linha)

        if s_linha in self._objectivos:
            recompensa = self._rmax
        
        return recompensa