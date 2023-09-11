from ecr.reaccao import Reaccao
from estimulo.estimulo_alvo import EstimuloAlvo
from resposta.resposta_mover import RespostaMover

#Deriva da Reacção, o que o também implementa um Comportamento.
#Lembrar: cada Reacção possui um Estímulo e uma Resposta.
#A Acção encontra-se na Resposta.
#o que esta classe faz é simplesmente gerar uma Reacção, com o Estímulo e Resposta apropriados.
#A ideia é obter a prioridade proveniente desta Reacção.
#Exemplo: Se me mover em frente e a ideia é aproximar-me do alvo, o quão conveniente (importante/prioridade)
#é se continuar nesta direcção.
class AproximarDir(Reaccao):

    def __init__(self, direccao):
        super().__init__(EstimuloAlvo(direccao), RespostaMover(direccao))