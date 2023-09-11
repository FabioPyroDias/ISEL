class No():
    def __init__(self, estado, operador=None, antecessor=None):
        self._estado = estado
        if(antecessor):
            self._antecessor = antecessor
            self._profundidade = antecessor.profundidade + 1
            self._custo = operador.custo(antecessor.estado, estado) + antecessor.custo
        else:
            self._antecessor = None
            self._profundidade = 0 
            self._custo = 0
        
        
        if(operador):
            self._operador = operador
        else:
            self._operador = None

        
    def __lt__(self, no):
        # Avalia os nós com o intuito de obter se um nó tem menor custo que outro
        return self.custo < no.custo

    @property
    def antecessor(self):
        return self._antecessor

    @property
    def operador(self):
        return self._operador

    @property
    def custo(self):
        return self._custo
    
    @property
    def profundidade(self):
        return self._profundidade

    @property
    def estado(self):
        return self._estado