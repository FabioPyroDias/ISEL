class Resposta():
    def __init__(self, accao):
        self._accao = accao
    
    # A resposta vai dar origem a uma ação, após por ter passado por todo o mecanismo de uma agente reativo
    def activar(self,percepcao, intensidade=0): 
        #self._accao.prioridade = intensidade #TODO
        return self._accao