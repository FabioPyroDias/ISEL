from .comportamento import Comportamento
from abc import abstractclassmethod

# Abstração de varias reações
# Vai implementar o mecasmimo que perceciona uma percepcao

# Um comportamento/reacção é composto por um estimulo e resposta
# Um comportamento compostom são varias reações e depois a ação é selecionada através de um "operador" que determina qual a melhor resposta a ser executada
# Esses operador pode seleção hierarquica, por priodidade ou fusão (vários comportamentos "somados" dão uma ação)
class ComportComp(Comportamento):
    def __init__(self, comportamentos):
        self._comportamentos = comportamentos # Arrays de comportament/reações

    def activar(self,percepcao):
        accoes = []
        
        # Um comportamento/reação produz uma ação ao "responder ao estímulo" causado pela perceção. Varios produzem varias respostas/ações
        for comportamento in self._comportamentos:
            accao = comportamento.activar(percepcao)
            
            if accao:
                accoes.append(accao)
        if accoes:
            return self.selecionar_accao(accoes) # Selecionar uma ação com um método de seleção

    @abstractclassmethod
    def selecionar_accao(self, accoes):
            pass
