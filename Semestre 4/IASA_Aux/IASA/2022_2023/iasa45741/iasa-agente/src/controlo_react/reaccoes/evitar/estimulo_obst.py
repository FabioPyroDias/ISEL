from ecr.estimulo import Estimulo

# Mecanismo de comportamento composto
# Implementação do estímulo "concreto" que determina se agente "bateu" num obstáculo
# Um estimulo determina a prioridade/urgencia de uma resposta ser executada
class EstimuloObst(Estimulo):
    def __init__(self, direccao, intensidade=1.0):
        self._direccao = direccao
        self.intensidade = intensidade
    
    def detectar(self, percepcao):
        elemento, distancia, posicao = percepcao[self._direccao] 

        # Mecanismo que deteta que o agente "bateu" no obstáculo
        if(percepcao.contacto_obst(self._direccao)):
            return self.intensidade
        else:
            return 0