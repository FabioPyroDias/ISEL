from abc import ABC, abstractmethod

'''
Dentro do Problema existe um Estado objectivo.
Caso chegarmos ao Objectivo da forma mais optimizada, aumenta a Utilidade.
Utilidade é o que procuramos sempre maximizar.
'''
class Problema(ABC):

    def __init__(self, estado_inicial, operadores):
        self.__estado_inicial = estado_inicial
        self.__operadores = operadores

    @property
    def estado_inicial(self):
        return self.__estado_inicial

    @property
    def operadores(self):
        return self.__operadores

    @abstractmethod
    def objectivo(self, estado):
        pass