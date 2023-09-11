from ecr.prioridade import Prioridade
from sae import Direccao
from .aproximar_dir import AproximarDir


# Mecanismo de comportamento  
# Implementação de um comportamento composto do tipo Proridade
# Este comportamento composto executa um "sub-comportamento" com base na proridade da direção.
# As ações são todas executadas em "simultaneo" e a que tiver maior prioridade é a ação de "saída"
class AproximarAlvo(Prioridade):
    def __init__(self):
        super().__init__([ AproximarDir(direccao) for direccao in Direccao ]) # carrega as 4 direções e cria os quatro comportamentos distintos