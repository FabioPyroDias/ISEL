from ecr.estimulo import Estimulo

#Muito rapidamente, este Estímulo é o que define se o agente reactivo colidiu com um Obstáculo.
#Este Estímulo também vai obter uma prioridade / intensidade da Resposta apropriada.
#Exemplo: Detectei um Obstáculo. Estou a colidir com o mesmo?
#Se sim, devo-me desviar para uma direcção diferente. Se não, não mudo o comportamento que já tinha.
class EstimuloObst(Estimulo):
    
    __direccao = 0
    __intensidade = 0

    def __init__(self, direccao, intensidade=1):
        self.__direccao = direccao
        self.__intensidade = intensidade
    
    def detectar(self, percepcao):
        #É aqui que detecta se colidiu.
        return self.__intensidade if percepcao.contacto_obst(self.__direccao) else 0