from pee.mod.problema.problema import Problema

from .estado_localidade import EstadoLocalidade
from .operador_ligacao import OperadorLigacao
class ProblemaPlanTraj(Problema):
    def __init__(self, ligacoes, loc_inicial, loc_final):
        self._estado_loc_final = EstadoLocalidade(loc_final)
        operadores_ligacao = []

        # Ligações -> Gerar os operadores através do array de ligações
        for ligacao in ligacoes:
            operadores_ligacao.append(OperadorLigacao(ligacao.origem, ligacao.destino, ligacao.custo))
            
        super().__init__(EstadoLocalidade(loc_inicial), operadores_ligacao)


    def objectivo(self, estado):
        return estado == self._estado_loc_final

