package br.com.lucio.listas.primitivas;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
        Lista lista = new Lista();
        
        //Se o método adicionarElemento não fosse sycronized, há grandes chances de elementos ficarem nulos
        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, "Thread " + i)).start();
        }
        
        new Thread(new TarefaImprimir(lista)).start();
        
    }
    
}
