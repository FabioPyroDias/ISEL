from abc import ABC, abstractmethod

'''
Um Estado é uma representação abstracta.
Uma configuração de Estados, que é única, representa a estrutura do domínio do problema.
'''
class Estado(ABC):

    #Assegura que este estado é único
    @abstractmethod
    def id_valor(self):
        pass

    #Retorna o seu identificador
    def __hash__(self):
        return self.id_valor()

    #Verifica se este estado é igual ao estado a ser comparado.
    def __eq__(self, other):
        return self.__hash__() == other.__hash__() 