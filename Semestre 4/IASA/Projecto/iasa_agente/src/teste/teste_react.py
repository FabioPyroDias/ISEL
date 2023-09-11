from lib.sae.simulador import Simulador
from controlo_react.controlo_react import ControloReact
#from reaccoes.explorar.explorar import Explorar
from controlo_react.reaccoes.recolher import Recolher

#comportamento = Explorar()
comportamento = Recolher()

controlo = ControloReact(comportamento)
Simulador(1, controlo).executar()

##Nota:
#Tenho de perceber o que se passa com os meus módulos e Imports.
#Muitos deles não são reconhecidos, por razões que desconheço.
#Em última instância, perguntar ao engenheiro