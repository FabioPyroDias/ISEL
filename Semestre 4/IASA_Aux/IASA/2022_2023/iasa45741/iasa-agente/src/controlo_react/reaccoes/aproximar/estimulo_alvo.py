from ecr.estimulo import Estimulo
from sae import Elemento

# Mecanismo de comportamento  
# Implementação do estímulo que origina a resposta que determina onde está o alvo
# Este estimulo determina a prioridade de uma resposta
class EstimuloAlvo(Estimulo):
    def __init__(self, direccao, gamma=0.9):
        self._direccao = direccao
        self._gamma = gamma
    
    def detectar(self, percepcao):
        elemento, distancia, posicao = percepcao[self._direccao] 

        # Mecanismo que define a prioridade da ação. QUanto maior, mais prioritário
        if(elemento == Elemento.ALVO):
            return self._gamma ** distancia
        else:
            return 0