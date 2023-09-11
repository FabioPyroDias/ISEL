
from plan_traj.planeador_trajecto import PlaneadorTrajecto
from plan_traj.mod_prob.ligacao import Ligacao
from teste.plan_traj.mod_prob.estado_localidade import EstadoLocalidade

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
loc_final = "Loc-3"



print("Procura em Profundidade\n\n")
solucao = PlaneadorTrajecto.planear(ligacoes, loc_inicial, loc_final)
PlaneadorTrajecto.mostrar_trajecto(solucao)

print("Procura em largura\n\n")
solucao = PlaneadorTrajecto.planear_largura(ligacoes, loc_inicial, loc_final)
PlaneadorTrajecto.mostrar_trajecto(solucao)
