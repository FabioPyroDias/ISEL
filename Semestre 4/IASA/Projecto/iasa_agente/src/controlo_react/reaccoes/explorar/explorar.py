from ecr.comportamento import Comportamento
from sae import Direccao
from ..resposta.resposta_mover import RespostaMover
from random import choice

#Este é o comportamento de movimento aleatório
class Explorar(Comportamento):

    #Escolhe uma direcção aleatória passa para a RespostaMover
    def activar(self, percepcao):

        direccoes = list(Direccao)
        direccao = choice(direccoes)
        
        respostaMover = RespostaMover(direccao)
        return respostaMover.activar(percepcao)