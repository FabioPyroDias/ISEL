from .memoria_aprend import MemoriaAprend

class MemoriaEsparsa(MemoriaAprend):
    def __init__(self, valor_omissao = 0.0):
        self._valor_omissao = valor_omissao # Double
        self._memoria = {} # { (Estado, Accao): Double }
        self._estados = set() # [ Estado ]

    # Obtem o valor Q do estado/accao
    def q(self, s, a):
        return self._memoria.get((s,a), self._valor_omissao)
    
    # Atualiza o valor Q no estado/accao
    def actualizar(self, s, a, q):
        self._estados.add(s)
        self._memoria[(s, a)] = q

    @property
    def memoria(self):
        return self._memoria

    def obter_estados(self):
        return self._estados

