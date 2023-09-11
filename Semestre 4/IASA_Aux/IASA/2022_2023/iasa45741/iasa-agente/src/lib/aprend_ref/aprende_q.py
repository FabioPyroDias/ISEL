from .aprende_ref import AprendeRef

class AprendQ(AprendeRef):
    def __init__(self, mem_aprende, sel_accao, alfa, gamma):
        super().__init__(mem_aprende, sel_accao)
        self._alfa = alfa  # Fator de aprendizagem: valoriza mais as novas ações
        self._gamma = gamma # Fator de decaimento: desvaloriza a recompensa em função do tempo

    
    # Guarda em memoria um par de (estado acao) com uma recompensa
    # Estratégia de estimação por acumulação
    # s, sn -> Estado, Estado Seguinte
    # a -> Acção
    # r -> Recompensa
    def aprender(self, s, a,r, sn):
        prox_estado = sn

        # Variáveis para a formula
        q_atual = self._mem_aprend.q(s, a)
        prox_accao = self._sel_accao.accao_sofrega(prox_estado)
        prox_q = self._mem_aprend.q(prox_estado, prox_accao)
        
        # Calcula novo Q a partir da formula da estratégia de estimação por acumulação
        novo_q = q_atual + self._alfa * ( r + (self._gamma * prox_q ) - q_atual ) 
        
        # Atualizar o valor na memória
        self._mem_aprend.actualizar(s,a,novo_q)
