from pee.mod.estado import Estado


class EstadoAgente(Estado):
    def __init__(self, posicao):
        self._posicao = posicao

    def id_valor(self):
        return hash(self._posicao)

    @property
    def posicao(self):
        return self._posicao