from sae import Simulador 
from controlo_delib.controlo_delib import ControloDelib
from plan.plan_pdm.plan_pdm import PlanPDM

planeador = PlanPDM()
controlo = ControloDelib(planeador)
Simulador(3,controlo).executar()