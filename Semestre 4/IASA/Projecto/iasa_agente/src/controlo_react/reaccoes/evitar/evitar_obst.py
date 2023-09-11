from ecr.hierarquia import Hierarquia
from resposta.resposta_evitar import RespostaEvitar
from evitar_dir import EvitarDir
from lib.sae.ambiente.direccao import Direccao
#Este Comportamento Composto vai ser do tipo Hierarquia.
#Semelhante ao EstimuloAlvo do Aproximar
class EvitarObst(Hierarquia):

    __resposta = 0

    #Criar Comportamentos(Estimulo, Resposta).
    #A Direcção que identificar um Obstáculo é a direcção a Evitar.
    def __init__(self):
        self.__resposta = RespostaEvitar()
        super().__init__([EvitarDir(direccao, self.__resposta) for direccao in Direccao])