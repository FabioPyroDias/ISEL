from lib.sae import Accao

class Resposta:

    #A Acção definida para esta Resposta em concreto
    _accao = 0

    #Ao instanciarmos a resposta, associamos essa reacção
    def __init__(self, accao):
        self._accao = accao
    
    #Activar a Resposta não é nada mais do que devolver a sua Acção associada.
    #Isto porque não é esta classe que vai decidir se é de facto esta Acção
    #a que vai ser executada.
    def activar(self, percepcao, intensidade=0):

        return self._accao