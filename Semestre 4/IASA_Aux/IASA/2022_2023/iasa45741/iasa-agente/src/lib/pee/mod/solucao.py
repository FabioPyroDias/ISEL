class Solucao():
    def __init__(self, no_final):

        self._no_final = no_final
        self.custo = no_final.custo
        self._percurso = [] # Lista de Nós que fazem parte da solução. Para se conseguir andar para trás na árvore até atingir a raiz
        
        # Andar para trás até encontrar o nó sem antecessor. Incrementar ao percurso todos os nós até ao final
        no_atual = self._no_final

        while no_atual:
            # Adicionar ao percurso deste o nó final até ao inicio
            self._percurso.insert(0, no_atual) # Insere sempre no inicio do percurso
            no_atual = no_atual.antecessor

        self.dimensao = len(self._percurso)
        
            
    def remover_passo(self):
        # Remover um passo (ou seja, uma transformação) do percurso. Remove o próximo / (pop) do percurso sendo que a solução esta ordenada da origem para a resolução
        return self._percurso.pop(0)

    def __len__(self):
        return len(self._percurso)

    def __iter__(self):
        # Vai retornar o iterador do percurso, que é uma sequência
        return iter(self._percurso)
    

    def __getitem__(self,key):
        #Retorna o item na chave na key key do self._percurso"
        return self._percurso[key]

