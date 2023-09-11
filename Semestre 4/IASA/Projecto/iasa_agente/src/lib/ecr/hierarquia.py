from ecr.comport_comp import ComportComp

#É um Comportamento Composto e serve como um mecanismo de reacção
#Supressão e Substituição de Comportamentos
class Hierarquia(ComportComp):
    
    #Seguirá uma Arquitectura de Subsunção
    #As Acções devem estar ordenadas. Isto para corresponder com o modelo da Hierarquia
    def seleccionar_accao(self, accoes):
        return accoes[0]
