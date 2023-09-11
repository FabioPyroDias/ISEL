from ecr.reaccao import Reaccao
from estimulo.estimulo_obst import EstimuloObst

#Lembrar: Reacção possui Estimulo e Resposta (A Resposta possui uma Accao).
#Neste caso, é meramente uma direcção que evita a colisão com um Obstáculo.
#Exemplo: Se me mover nesta direcção, o quão certo (prioridade) é colidir com o obstáculo, se existir
class EvitarDir(Reaccao):
    def __init__(self, direccao, resposta):
        super().__init__(EstimuloObst(direccao), resposta)