from ecr.comportamento import Comportamento

class Reaccao(Comportamento):
    def __init__(self, estimulo, resposta):
        self._estimulo = estimulo
        self._resposta = resposta

    # O agente reage a percepcao recebe/sente do ambiente através do estimulo
    # esta reacção vai dar numa acao ativada pela resposta
    def activar(self,percepcao):
        intensidade = self._estimulo.detectar(percepcao) 
        if intensidade > 0:
                return self._resposta.activar(percepcao,intensidade) 


