package br.com.lucio.banheiro;

public class TarefaLimpeza implements Runnable {

    private Banheiro banheiro;

    public TarefaLimpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        while (true) {
            this.banheiro.limpar();
            this.banheiro.dormeUmPouco(20000);
        }
    }

}
