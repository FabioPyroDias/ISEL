from ecr.reaccao import Reaccao
from .estimulo_obst import EstimuloObst
from .resposta_evitar import RespostaEvitar

# Mecanismo de comportamento
# Implementação do estímulo "concreto" Explorar
# Um estimulo dá origem a uma resposta, que quando "acionada" retorna uma ação
class EvitarDir(Reaccao):
    def __init__(self, direccao, resposta):
        super().__init__(EstimuloObst(direccao), RespostaEvitar())


