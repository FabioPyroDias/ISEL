from ecr.resposta import Resposta
from sae.agente.accao import Accao

#Esta classe servirá para o agente se mover numa determinada direcção
class RespostaMover(Resposta):

    #Passar a direcção, após instanciar uma Acção com esta como argumento, para a classe pai.
    def __init__(self, direccao):
        super().__init__(Accao(direccao))