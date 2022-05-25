package br.com.lucio.banheiro.listas.collections;

import java.util.List;

public class TarefaAdicionarElemento implements Runnable {

    private List<String> lista;
    private String identificadorThread;

    public TarefaAdicionarElemento(List<String> lista, String identificadorThread) {
        this.lista = lista;
        this.identificadorThread = identificadorThread;
    }
 
    @Override
    public void run() {
        
        for (int i = 0; i < 100; i++) {
            lista.add(i + " - " + identificadorThread);
        }

    }

}
