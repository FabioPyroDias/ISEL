from abc import abstractclassmethod, ABC

class AprendeRef(ABC):
    def __init__(self, mem_aprend, sel_accao):
        self._mem_aprend = mem_aprend # Do tipo MemoriaAprende
        self._sel_accao = sel_accao # Do tipo SelAccao
    
    @abstractclassmethod
    def aprender(self, s, a,r, sn):
        pass
