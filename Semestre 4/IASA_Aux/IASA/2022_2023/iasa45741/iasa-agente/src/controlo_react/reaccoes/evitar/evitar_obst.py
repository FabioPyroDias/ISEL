from ecr.hierarquia import Hierarquia
from sae import Direccao

from .resposta_evitar import RespostaEvitar
from .evitar_dir import EvitarDir

# Mecanismo de comportamento composto
# Implementação de um comportamento composto do tipo Hierarquia
# Este comportamento composto executa um "sub-comportamento" com base na hierarquia
# As ações são todas executadas em "simultaneo" e ficar na primieira é a ação de "saída"
class EvitarObst(Hierarquia):
    def __init__(self):
        self._resposta = RespostaEvitar()
        super().__init__([ EvitarDir(direccao, self._resposta) for direccao in Direccao ])
        # Criar comportamentos com o estímulo e resposta. A direção que tiver "bloqueada" é a direção que se têm de evitar
