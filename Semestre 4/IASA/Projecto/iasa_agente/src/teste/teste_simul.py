from lib.sae.agente.controlo import Controlo
from lib.sae.simulador import Simulador

class ControloTeste(Controlo):
    def processar(self, percepcao):
        print("processar")

controlo = ControloTeste()
Simulador(1, controlo).executar()