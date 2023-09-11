package tp1.pack3Coleccoes;

import java.util.Arrays;

import tp1.pack2Livros.Livro;

/**
 * Classe Coleccao, deve conter a descrição de uma colecção, com título, os seus
 * livros, colecções e editores
 */
public class Coleccao {
    // número máximo de obras de uma colecção
    private static int MAXOBRAS = 20;

    // prefixo usual
    public static final String GENERALPREFIX = "  ";

    // título da colecção
    private String titulo;

    // Array de livros, em que estas encontram-se sempre nos menores índices e
    // pela ordem de registo
    private Livro[] livros = new Livro[MAXOBRAS];

    // deverá conter sempre o número de livros na colecção
    private int numLivros = 0;

    // array de colecções, estas devem ocupar sempre os menores índices
    private Coleccao[] coleccoes = new Coleccao[MAXOBRAS];

    // deverá conter sempre o número de colecções dentro da colecção
    private int numColeccoes = 0;

    // Editores, tem as mesmas condicionantes que array de autores na classe
    // livro
    private String[] editores;

    /**
     * Construtor; o título tem de ter pelo menos um caracter que não seja um
     * espaço (Character.isWhitespace); o array de editores devem ser pelo menos
     * um e têm as mesmas restrições que os autores dos livros;
     */
    public Coleccao(String titulo, String[] editores) {
        // titulo
        if (titulo == null || titulo.length() == 0)
            throw new IllegalArgumentException(
                    "O titulo tem de ter pelo menos um caracter");
        this.titulo = titulo;

        // TODO
    }

    /**
     *
     */
    public String getTitulo() {
        // TODO
        return null;
    }

    /**
     * Obtem o número total de páginas da colecção, páginas dos livros e das
     * colecções
     */
    public int getNumPaginas() {
        // TODO
        return 0;
    }

    /**
     * As colecções com mais de 5000 páginas nos seus livros directos têm um
     * desconto de 20% nesses livros. As colecções em que o somatório de páginas
     * das suas subcolecções directas seja igual ou superior ao quádruplo do nº
     * de páginas da sua subcolecção directa com mais páginas deverão aplicar um
     * desconto de 10% sobre os preços das suas subcolecções
     */
    public float getPreco() {
        // TODO
        return 0;
    }

    /**
     * Adiciona um livro à colecção se puder e este não seja null e a colecção
     * não ficar com livros iguais ao nível imediato da colecção. Deve utilzar o
     * método getIndexOfLivro e getIndexOfColeccao
     */
    public boolean addLivro(Livro livro) {
        // TODO
        return false;
    }

    /**
     * Adiciona uma colecção à colecção se puder, esta não seja null e a
     * colecção não ficar com obras imediatas com títulos repetidos. Deve
     * utilizar o método getIndexOfLivro e getIndexOfColeccao
     */
    public boolean addColeccao(Coleccao col) {
        // TODO
        return false;
    }

    /**
     * Devolve o index no array de livros onde estiver o livro com o nome
     * pretendido. Devolve -1 caso não o encontre
     */
    private int getIndexOfLivro(String titulo) {
        // TODO
        return -1;
    }

    /**
     * Devolve o index no array de colecções onde estiver a colecção com o nome
     * pretendido. Devolve -1 caso não o encontre
     */
    private int getIndexOfColeccao(String titulo) {
        // TODO
        return -1;
    }

    /**
     * Remove do array o livro com o título igual ao título recebido. Devolve o
     * livro removido ou null caso não tenha encontrado o livro. Deve-se
     * utilizar o método getIndexOfLivro. Recorda-se que os livros devem ocupar
     * sempre os menores índices, ou seja, não pode haver nulls entre os livros
     */
    public Livro remLivro(String titulo) {
        // TODO
        return null;
    }

    /**
     * Remove do array de colecções a colecção com o título igual ao título
     * recebido. Devolve a colecção removida ou null caso não tenha encontrado.
     * Deve-se utilizar o método getIndexOfColeccao. Recorda-se que as colecções
     * devem ocupar sempre os menores índices, ou seja, não pode haver nulls
     * entre elas
     */
    public Coleccao remColeccao(String titulo) {
        // TODO
        return null;
    }

    /**
     * Devolve o nº de obras de uma pessoa. Cada colecção deve contabilizar-se
     * como uma obra para os editores.
     */
    public int getNumObrasFromPerson(String autorEditor) {
        // TODO
        return 0;
    }

    /**
     * Devolver um novo array (sem nulls) com os livros de que a pessoa recebida
     * é autor. Não deve conter repetições, para excluir as repetições devem
     * utilizar o método mergeWithoutRepetitions
     */
    public Livro[] getLivrosComoAutor(String autorNome) {
        // TODO
        return null;
    }

    /**
     * Deve devolver uma string compatível com os outputs desejados
     */
    public String toString() {
        // TODO
        return null;
    }

    /**
     * Deve devolver um array, sem nulls, com todos os autores e editores
     * existentes na colecção. O resultado não deve conter repetições. Deve
     * utilizar o método mergeWithoutRepetitions
     */
    public String[] getAutoresEditores() {
        // TODO
        return null;
    }

    /**
     * Método que recebendo dois arrays sem repetições devolve um novo array com
     * todos os elementos dos arrays recebidos mas sem repetições
     */
    private static String[] mergeWithoutRepetitions(String[] a1, String[] a2) {
        // TODO
        return null;
    }

    /**
     * Método idêntico ao método anterior mas agora com arrays de livros
     */
    private static Livro[] mergeWithoutRepetitions(Livro[] a1, Livro[] a2) {
        // TODO
        return null;
    }

    /**
     * Devolve true caso a colecção recebida tenha o mesmo título e a mesma
     * lista de editores. Para verificar verificar se os editores são os mesmos
     * devem utilizar o método mergeWithoutRepetitions
     */
    public boolean equals(Coleccao c) {
        // TODO
        return false;
    }

    /**
     * Mostra uma colecção segundo os outputs desejados
     */
    public void print(String prefix) {
        // TODO
    }

    /**
     * main
     */
    public static void main(String[] args) {
        Livro l1 = new Livro("Viagem aos Himalaias", 340, 12.3f,
                new String[]{"João Mendonça", "Mário Andrade"});
        Livro l2 = new Livro("Viagem aos Pirinéus", 270, 11.5f,
                new String[]{"João Mendonça", "Júlio Pomar"});

        Coleccao c1 = new Coleccao("Primavera",
                new String[]{"João Mendonça", "Manuel Alfazema"});

        boolean res;

        res = c1.addLivro(l1);
        res = c1.addLivro(l2);
        System.out.println("c1 -> " + c1);
        c1.print("");
        System.out.println();

        // adicionar um livro com nome de outro já existente
        res = c1.addLivro(l2);
        System.out.println(
                "adição novamente de Viagem aos Pirinéus a c1 -> " + res);
        System.out.println("c1 -> " + c1);
        System.out.println();

        // Outra colecção
        Livro l21 = new Livro("Viagem aos Himalaias 2", 340, 12.3f,
                new String[]{"João Mendonça", "Mário Andrade"});
        Livro l22 = new Livro("Viagem aos Pirinéus 2", 270, 11.5f,
                new String[]{"João Mendonça", "Júlio Pomar"});

        Coleccao cx2 = new Coleccao("Outono",
                new String[]{"João Mendonça", "Manuel Antunes"});
        cx2.addLivro(l21);
        cx2.addLivro(l22);
        System.out.println("cx2 -> " + cx2);
        cx2.print("");
        System.out.println();

        // adicioná-la a c1
        c1.addColeccao(cx2);
        System.out.println("c1 após adição da colecção cx2 -> " + c1);
        c1.print("");
        System.out.println();

        // get editores autores
        String[] ae = c1.getAutoresEditores();
        System.out.println("Autores editores of c1 -> " + Arrays.toString(ae));
        System.out.println();

        // getNumObrasFromPerson
        String nome = "João Mendonça";
        int n = c1.getNumObrasFromPerson(nome);
        System.out.println("Nº de obras de " + nome + " -> " + n);
        System.out.println();

        // getLivrosComoAutor
        nome = "João Mendonça";
        Livro[] obras = c1.getLivrosComoAutor(nome);
        System.out
                .println("Livros de " + nome + " -> " + Arrays.toString(obras));
        System.out.println();

        // rem livro
        String nomeLivro = "Viagem aos Himalaias";
        Livro l = c1.remLivro(nomeLivro);
        System.out.println("Remoção de " + nomeLivro + " -> " + l);
        c1.print("");
        System.out.println();
    }
}