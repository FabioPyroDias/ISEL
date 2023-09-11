from abc import ABC, abstractmethod

'''
A Percepção é convertida para um Estímulo.
Esta também é uma interface.
'''
class Estimulo(ABC):

    #A intensidade do estímulo, depende da percepção.
    #Se um objecto estiver mais perto, deve possuir uma maior intensidade
    @abstractmethod
    def detectar(self, percepcao):
        pass