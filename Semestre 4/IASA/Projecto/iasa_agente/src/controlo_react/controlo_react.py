from lib.sae.agente.controlo import Controlo

#Esta classe é o controlador do nosso agente reactivo.
#É este que retornará a acção desejada/mais apropriada à situação.

#O Gestor das Reacções.
#Dado que previamente o nosso agente possuia um "Controlo", este possui um Controlo mas
#reactivo.
class ControloReact(Controlo):

    __comportamento = 0

    #Recebe um comportamento.
    #Dado que é uma extensão de Controlo, devo chamar o seu constructor.
    def __init__(self, comportamento):
        super().__init__()
        self.__comportamento = comportamento
    
    #Com base na sua percepção, retorna uma acção.
    def processar(self, percepcao):
        return self.__comportamento.activar(percepcao)
