from .fronteira import Fronteira

class FronteiraFIFO(Fronteira):
    def inserir(self, no):
        # Insere Nó no inicio da queue - First In
        self._nos.insert(0, no)