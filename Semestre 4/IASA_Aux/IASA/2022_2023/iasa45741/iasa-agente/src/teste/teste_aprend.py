from sae import Simulador 
from controlo_aprend.controlo_aprend_ref import ControloAprendeRef


controlo = ControloAprendeRef()
Simulador(2,controlo).executar()