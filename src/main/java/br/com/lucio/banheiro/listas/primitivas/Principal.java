package br.com.lucio.banheiro.listas.primitivas;

public class Principal {

    public static void main(String[] args) throws InterruptedException {
        
        Lista lista = new Lista();
        
        //Se o metdodo adicionarElemento não fosse sycronized, há chances grandes de elementos ficarem nulos
        for (int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, "Thread " + i)).start();
        }
        
        Thread.sleep(200);
        
        for (int i = 0; i < lista.tamanho(); i++) {
            System.out.println(i + " - " + lista.pegaElemento(i));
        }
        
    }
    
}
