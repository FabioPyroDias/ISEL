from sae import Simulador 
from sae import Controlo
from controlo_delib.controlo_delib import ControloDelib
from lib.plan.plan_pee.plan_pee import PlanPEE

from pee.melhor_prim.procura_sofrega import ProcuraSofrega 
from pee.melhor_prim.procura_aa import ProcuraAA
from pee.melhor_prim.procura_custo_unif import ProcuraCustoUnif


planeador = PlanPEE(ProcuraCustoUnif, usar_heuristica=False)
# planeador = PlanPEE(ProcuraAA, usar_heuristica=True)
# planeador = PlanPEE(ProcuraSofrega, usar_heuristica=True)

controlo = ControloDelib(planeador)
Simulador(1,controlo).executar()