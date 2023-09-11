from resposta.resposta_mover import RespostaMover
from sae import Direccao
from random import choice

class RespostaEvitar(RespostaMover):
    
    def __init__(self, dir_inicial=Direccao.ESTE):
        super().__init__(dir_inicial)

    #Aqui damos uso à variável protected da classe Resposta, accao
    #Lembrar: Resposta tem uma acção associada
    #Se existir um obstaculo na direcção actual, arranjar uma nova (a partir da __direccao_livre) e actualizar a Accao.
    #Caso não exista, activar a Resposta
    def activar(self, percepcao, intensidade):
        obst = percepcao.contacto_obst(self._accao.direccao)

        #Se existir contacto com o obstáculo, tenho de mudar a sua direcção
        if(obst):
            obst = self.__alterar_direccao(percepcao)
        else:
            return super().activar(percepcao, intensidade)
    
    #Obtem uma direcção livre, aleatória.
    def __direccao_livre(percepcao):
        return choice([direccao for direccao in Direccao if not percepcao.contacto_obst(direccao)])
    
    #Altera a direcção actual, caso seja possível
    def __alterar_direccao(self, percepcao):
        direccao = self.__direccao_livre(percepcao)
        if direccao:
            self._accao.direccao = direccao
        return direccao



