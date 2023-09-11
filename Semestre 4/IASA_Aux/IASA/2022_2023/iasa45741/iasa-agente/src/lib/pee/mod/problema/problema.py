from abc import abstractmethod

class Problema():
    def __init__(self, estado_inicial, operadores):
        self._estado_inicial = estado_inicial #Estado inicial do problema. Lido através de um getter
        self._operadores = operadores # Operadores que transformam um estado no outro. Lido atravẽs de um getter
        
    @property
    def estado_inicial(self):
        return self._estado_inicial

    @property
    def operadores(self):
        return self._operadores

    @abstractmethod
    def objectivo(self, estado):
        # Recebe um estado e vê se é o estado final
        pass




# Como executar um problema:
# 1 - Definir um conjunto de operadores (Estado 1  ➤ Estado 2 com custo)
# 2 - Definir om estado inicial
# 3 - Definir um objetivo 
# 4 - Criar um problema passando operadores e estado inicial
# 5 - Executar o mecanismo de procura utilizado o problema criado