from sae import Simulador 
from sae import Controlo
from ecr.hierarquia import Hierarquia
from controlo_react.controlo_react import ControloReact
from controlo_react.reaccoes.explorar.explorar import Explorar
from controlo_react.reaccoes.recolher import Recolher

#comportamento = Hierarquia([Explorar()])
comportamento = Recolher()
controlo = ControloReact(comportamento)
Simulador(1,controlo).executar()