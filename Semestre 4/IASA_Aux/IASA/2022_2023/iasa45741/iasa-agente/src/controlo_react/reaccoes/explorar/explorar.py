from ..resposta.resposta_mover import RespostaMover
from ecr.comportamento import Comportamento
from sae import Direccao
from random import choice

# Mecanismo de comportamento
# Implementação do estímulo "concreto" Explorar
# Um estimulo dá origem a uma resposta, que quando "acionada" retorna uma ação
class Explorar(Comportamento):
    def activar(self,percepcao):
        direccao = choice(list(Direccao))
        resposta = RespostaMover(direccao)
        return resposta.activar(percepcao)

