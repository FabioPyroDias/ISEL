class No:

    def __init__(self, estado, operador=None, antecessor=None):
        self.__estado = estado
        self.__operador = operador
        self.__antecessor = antecessor
        self.__profundidade = 0
        self.__custo = 0

    @property
    def profundidade(self):
        return self.__profundidade

    @property
    def custo(self):
        return self.__custo
    
    @property
    def estado(self):
        return self.__estado
    
    @property
    def operador(self):
        return self.__operador
    
    @property
    def custo(self):
        return self.__antecessor

    def __lt__(self, no):
        return self.__custo < no.custo