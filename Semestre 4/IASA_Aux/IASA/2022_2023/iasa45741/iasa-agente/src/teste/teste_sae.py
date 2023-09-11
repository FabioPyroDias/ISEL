from sae import Simulador 
from sae import Controlo

class ControloTeste(Controlo):
    def processar(self, percepcao):
        print("sim")

controlo = ControloTeste()
Simulador(1,controlo).executar()