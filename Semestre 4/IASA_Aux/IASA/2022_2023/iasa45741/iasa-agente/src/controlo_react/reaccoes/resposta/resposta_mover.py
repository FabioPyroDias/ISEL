from ecr.resposta import Resposta
from sae import Accao

# Mecanismo de comportamento
# Implenta uma resposta "concreta" a um estímulo de de uma agente
class RespostaMover(Resposta):
    def __init__(self, direccao): # A ação desta resposta é a direção em que o agente têm de se mover
        self._direccao = direccao
        super().__init__(Accao(direccao))