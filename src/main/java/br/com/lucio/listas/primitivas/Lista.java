package br.com.lucio.listas.primitivas;

public class Lista {

    private String[] elementos = new String[1000];
    private int indice = 0;

    public synchronized void adicionaElementos(String elemento) {
        this.elementos[indice] = elemento;
        this.indice++;

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (indice == elementos.length) {
            System.out.println("Lista foi totalmente preenchida, vamos notificar a tarefa imprimir:");
            // Notifica que todos os elementos foram adicionados, agora a Tarefa Imprimir será executada depois do wait
            this.notify();
        }
    }

    public int tamanho() {
        return this.elementos.length;
    }

    public String pegaElemento(int posicao) {
        return this.elementos[posicao];
    }
    
    public boolean naoEstaCheia() {
        return !estaCheia();
    }
    
    public boolean estaCheia() {
        return this.indice == this.tamanho();
    }
 
}
