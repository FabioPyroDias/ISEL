from ecr.comport_comp import ComportComp

#É um Comportamento Composto e serve como um mecanismo de reacção
#A Acção provém da prioridade mais elevada, que pode variar ao longo do tempo.
class Prioridade(ComportComp):

    #Dependendo da Acção mais importante, pela sua prioridade que pode variar ao longo da execução,
    #devolve a mais importante
    def seleccionar_accao(self, accoes):
        return max(accoes, key=lambda accao : accao.prioridade)