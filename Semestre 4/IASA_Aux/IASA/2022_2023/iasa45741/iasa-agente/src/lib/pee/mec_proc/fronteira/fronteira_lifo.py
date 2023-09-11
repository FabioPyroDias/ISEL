from .fronteira import Fronteira

class FronteiraLIFO(Fronteira):
    def inserir(self, no):
        # Insere Nó no final da queue - Last In
        self._nos.append(no)