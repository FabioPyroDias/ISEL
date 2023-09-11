from abc import ABC, abstractmethod

'''
A razão deste Comportamento ser uma interface provém de duas razões (pelo que percebo):
- A primeira da existência de Comportamentos Compostos que são constituídos por um ou 
mais Comportamentos.
- A segunda razão, que detalha mais a primeira razão, é a necessidade de repetir o método 
"activar". Desta forma, eliminamos a redundância, ou seja, estamos a Factorizar o nosso código.

Adicionalmente, uma Reacção é um Comportamento.
Logo, uma Percepção vai gerar uma Acção.
É como imaginarmos a primeira figura dos Slides "P03-iasa-react-1" sem a visão do que
acontece dentro da caixa. Apenas sabemos que recebe Percepção e sai Acção.  
'''

class Comportamento(ABC):
    
    #Dependendo do estímulo proveniente da sua percepção,
    #devolve uma acção apropriada.
    #A razão de ser abstracto está explicada no comentário acima.
    @abstractmethod
    def activar(self, percepcao):
        pass