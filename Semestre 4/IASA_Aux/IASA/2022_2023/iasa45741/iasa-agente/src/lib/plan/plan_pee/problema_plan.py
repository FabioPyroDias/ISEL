from pee.mod.problema.problema import Problema

import time

class ProblemaPlan(Problema):
    def __init__(self, estado_inicial, modelo_plan, estado_final):
        super().__init__(estado_inicial, modelo_plan.operadores)
        self.modelo_plan = modelo_plan
        self._estado_final = estado_final
    
    def objectivo(self,estado):
        return estado == self._estado_final