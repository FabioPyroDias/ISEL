from pee.larg.procura_larg import ProcuraLarg
from pee.prof.procura_prof_iter import ProcuraProfIter
from pee.prof.procura_prof_lim import ProcuraProfLim
#from pee.prof.procura_prof_lim import ProcuraProfLim
from .mod_prob.problema_plan_traj import ProblemaPlanTraj
from pee.melhor_prim.procura_sofrega import ProcuraSofrega 
class PlaneadorTrajecto():
    def planear(ligacoes, loc_inicial, loc_final): # TODO: Arranjar maneira de passar o método por func
        problema = ProblemaPlanTraj(ligacoes, loc_inicial, loc_final)

        metodo_procura = ProcuraProfLim()
        return metodo_procura.resolver(problema,10 )

    def planear_largura(ligacoes, loc_inicial, loc_final):
        problema = ProblemaPlanTraj(ligacoes, loc_inicial, loc_final)

        metodo_procura = ProcuraLarg()
        return metodo_procura.resolver(problema )

    def planear_com_procura(procura, ligacoes, loc_inicial, loc_final, heuristica = None):
        problema = ProblemaPlanTraj(ligacoes, loc_inicial, loc_final)

        if(heuristica):
            metodo_procura = procura(heuristica)
            return metodo_procura.resolver(problema, heuristica)
        else:
            metodo_procura = procura()
            return metodo_procura.resolver(problema)

    def mostrar_trajecto(solucao):
        # Mostrar os nós da solução
        if(solucao):
            for no in solucao:
                print(no.estado.localidade)
                
            print("Custo: ", solucao.custo)