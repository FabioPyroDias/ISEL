from ecr.hierarquia import Hierarquia
from .aproximar.aproximar_alvo import AproximarAlvo
from .evitar.evitar_obst import EvitarObst
from .explorar.explorar import Explorar

class Recolher(Hierarquia):
    def __init__(self):
        super().__init__([AproximarAlvo(), EvitarObst(), Explorar()])
        #super().__init__([Explorar()])