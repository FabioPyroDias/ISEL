from matplotlib.pyplot import cla
from pee.mod.estado import Estado

class EstadoLocalidade(Estado):
    def __init__(self, localidade):
        self._localidade = localidade

    def id_valor(self):
        return hash(self._localidade)

    @property
    def localidade(self):
        return self._localidade