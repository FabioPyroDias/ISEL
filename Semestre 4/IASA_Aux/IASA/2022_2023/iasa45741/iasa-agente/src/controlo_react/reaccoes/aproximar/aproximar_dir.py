from resposta.resposta_mover import RespostaMover
from ecr.reaccao import Reaccao
from estimulo_alvo import EstimuloAlvo

# Mecanismo de comportamento  
# Implementação do estímulo "concreto" Aproximar direcional
# Este comportanento é um comportamento/reação "simples" que recebe apenas um estimulo e resposta
# Este estimulo
class AproximarDir(Reaccao):
    def __init__(self, direccao):
        super().__init__(EstimuloAlvo(direccao), RespostaMover(direccao))


