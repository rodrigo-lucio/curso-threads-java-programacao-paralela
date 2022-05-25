package br.com.lucio.banheiro.listas.primitivas;

public class TarefaAdicionarElemento implements Runnable {

    private Lista lista;
    private String identificadorThread;

    public TarefaAdicionarElemento(Lista lista, String identificadorThread) {
        this.lista = lista;
        this.identificadorThread = identificadorThread;
    }
 
    @Override
    public void run() {
        
        for (int i = 0; i < 100; i++) {
            lista.adicionaElementos(i + " - " + identificadorThread);
        }

    }

}
