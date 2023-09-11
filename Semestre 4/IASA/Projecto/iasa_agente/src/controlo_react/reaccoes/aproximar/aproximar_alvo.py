from ecr.prioridade import Prioridade
from aproximar_dir import AproximarDir
from lib.sae.ambiente.direccao import Direccao

#Comportamento Composto
#Pelo que percebi, este Comportamento vai receber um conjunto de AproximarDirecções.
#Estes são Reacções que implementam Comportamento.
#Cada AproximarDirecção possui uma Direcção associada. E é a partir destas que vai ser gerada a Acção a ser tomada.
#Aquele que possuir maior prioridade, é a acção a ser escolhida (Dai derivar de Prioridade)
class AproximarAlvo(Prioridade):
    
    #A lógica é bastante simples: Dado que o Constructor do Comportamento Composto recebe uma
    #lista de Comportamentos e os AproximarDirecção implementa Comportamentos, basta passar este
    #conjunto para o Comportamento Composto via o seu Constructor.
    
    #São passados os 4 comportamentos (AproximarDir) com cada direcção.
    #É em cima, no método seleccionar_accao que, dependendo da prioridade de cada comportamento
    #sera executado e devolvido como Acção. (Resposta gera Acção)
    def __init__(self):
        super().__init__([AproximarDir(direccao) for direccao in Direccao])