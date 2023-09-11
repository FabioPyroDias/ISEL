from ecr.hierarquia import Hierarquia
from aproximar.aproximar_alvo import AproximarAlvo
from evitar.evitar_obst import EvitarObst
from explorar.explorar import Explorar

#Com o Mecanismo de Seleccao Hierarquia, podemos definir que Comportamento suprime os outros.
#Neste caso, foi definido AproximarAlvo > EvitarObst > Explorar.
#Não esquecer que os comportamentos têm de estar ordenados.
class Recolher(Hierarquia):
    def __init__(self):
        super().__init__([AproximarAlvo(), EvitarObst(), Explorar()])