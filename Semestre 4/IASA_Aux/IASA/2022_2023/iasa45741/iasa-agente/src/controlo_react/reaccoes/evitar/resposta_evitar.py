from ..resposta.resposta_mover import RespostaMover
from sae import Direccao
from random import choice

# Mecanismo de reação/comportamento
# Faz o agente mudar a direção quando a direção está bloqueada
# Esta resposta dá resultado numa ação (uma "ordem") que depois é executada pelo agente
class RespostaEvitar(RespostaMover):
    def __init__(self, dir_inicial=Direccao.ESTE):
        super().__init__(dir_inicial)
        self._direccoes = list(Direccao)

    def activar(self, percepcao, intensidade):
        contacto_obst = percepcao.contacto_obst(self._accao.direccao)
        # Se existir um obstáculo na direção "atual"
        if(contacto_obst):
                direccao_livre = self._direccao_livre(percepcao) # calcular uma direção lubre
                if(direccao_livre):
                    self._accao.direccao = direccao_livre # Efetivamente alterar a direção na ação que vai ser executada
                    contacto_obst = False # Fazer ativar a ação
        if not contacto_obst:
            return super().activar(percepcao, intensidade) # Ativar a ação com a direção "nova" que à partida será uma livre
            
    def _direccao_livre(self, percepcao):
        dir_livres = [direccao for direccao in Direccao if not percepcao.contacto_obst(direccao)]
        return choice(dir_livres)
        
        