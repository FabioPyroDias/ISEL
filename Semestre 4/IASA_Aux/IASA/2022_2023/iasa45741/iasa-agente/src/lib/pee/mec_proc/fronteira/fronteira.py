from abc import abstractmethod

# Lista de nós que contem os nós de fronteira
class Fronteira():
    def __init__(self):
        self._nos = []

    def vazia(self):
        return len(self._nos) == 0

    @abstractmethod
    def inserir(self, no): # Inserção do nó encarregue do própria estratégia
        pass
    
    def remover(self):
        # Remove o ultimo nó por omissão porque só temos queues LIFO e FIFO, e as outras queues implementam o próprio remover
        return self._nos.pop(0)
