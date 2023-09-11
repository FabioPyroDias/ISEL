from .fronteira import Fronteira

class FronteiraPrioridade(Fronteira):
    def __init__(self, avaliador):
        self._nos = []
        self._avaliador = avaliador

    def inserir(self, no):

        # Avaliar custo do nó a inserir, e inserir na ordem de menor custo para o maior 
        index = len(self._nos)
        for index_no,no_fronteira in enumerate(self._nos):
            if(self._avaliador.prioridade(no) < self._avaliador.prioridade(no_fronteira)):
                index = index_no
                break;
        self._nos.insert(index, no)

    def remover(self):
        # Remove o próximo nó  (prioridade) - Sendo que a fronteira está ordenada de menor custo para o maior, remove sempre o nó com menor custo
        # Exemplo (apenas custo): [3,14,23] -> [14,23]
        return self._nos.pop(0)


if __name__ == '__main__':    
    # Código de teste para fronteira de prioridade
    def inserir(no):
        arr = [2,4,6]
        index = len(arr)
        for index_no,no_fronteira in enumerate(arr):
            if(no < no_fronteira):
                index = index_no
                break;
        arr.insert(index, no)
        return arr

    assert(inserir(1) == [1,2,4,6])
    assert(inserir(2) == [2,2,4,6])
    assert(inserir(7) == [2,4,6,7])
            