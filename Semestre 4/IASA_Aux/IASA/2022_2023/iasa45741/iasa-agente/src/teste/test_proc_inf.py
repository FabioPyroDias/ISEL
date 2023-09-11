
from plan_traj.planeador_trajecto import PlaneadorTrajecto
from plan_traj.mod_prob.ligacao import Ligacao
from teste.plan_traj.mod_prob.estado_localidade import EstadoLocalidade

from pee.mec_proc.aval.heuristica import Heuristica

from pee.melhor_prim.procura_sofrega import ProcuraSofrega 
from pee.melhor_prim.procura_aa import ProcuraAA
from pee.melhor_prim.procura_custo_unif import ProcuraCustoUnif

import random
# Mini heuristica para o plan traj
class HeurLoc(Heuristica):
    def __init__(self, estado_final):
        self._estado_final = estado_final

    def h(self, estado):
        rand = random.randint(1, 10)
        return rand


ligacoes = [
    Ligacao("Loc-0", "Loc-1", 5), # Ou vai para [1, 2]
	Ligacao("Loc-0", "Loc-2", 25),

	Ligacao("Loc-1", "Loc-3", 12),
	Ligacao("Loc-1", "Loc-6", 5), # Ou vai [3, 6]

	Ligacao("Loc-2", "Loc-4", 30),# Ou vai [4]

	Ligacao("Loc-3", "Loc-2", 10),  # Ou vai [2, 5]
	Ligacao("Loc-3", "Loc-5", 5),

	Ligacao("Loc-4", "Loc-3", 2),  # Ou vai [3]

	Ligacao("Loc-5", "Loc-6", 8), # Ou vai [6, 4]
	Ligacao("Loc-5", "Loc-4", 10),

	Ligacao("Loc-6", "Loc-3", 15) # Ou vai [3]
]

loc_inicial = "Loc-0"
loc_final = "Loc-4"

heur = HeurLoc(loc_final)

print("\n\nProcura Sofrega")
solucao = PlaneadorTrajecto.planear_com_procura(ProcuraSofrega, ligacoes, loc_inicial, loc_final, heur)
PlaneadorTrajecto.mostrar_trajecto(solucao)

print("\n\nProcura A*")
solucao = PlaneadorTrajecto.planear_com_procura(ProcuraAA, ligacoes, loc_inicial, loc_final, heur)
PlaneadorTrajecto.mostrar_trajecto(solucao)

print("\n\nProcura Custo Uniforme")
solucao = PlaneadorTrajecto.planear_com_procura(ProcuraCustoUnif, ligacoes, loc_inicial, loc_final)
PlaneadorTrajecto.mostrar_trajecto(solucao)
