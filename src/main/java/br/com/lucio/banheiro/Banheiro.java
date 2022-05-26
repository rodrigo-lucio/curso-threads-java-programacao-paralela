package br.com.lucio.banheiro;

public class Banheiro {

    private boolean estaSujo = true;

    /*
     * Também poderiamos usar o lock, bloqueando e desbloqueando
     * private Lock lock = new ReentrantLock();
     * lock.lock();
     * lock..unlock();
     */

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();
        System.out.println(nome + " - Batendo na porta");
        synchronized (this) {

            System.out.println(nome + " - Entrando no banheiro");

            while (this.estaSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " - Agora o banheiro esta limpo");
            System.out.println(nome + " - Fazendo coisa rápida");

            dormeUmPouco(5000);
            
            this.estaSujo = true;

            System.out.println(nome + " - Lavando a mão");
            System.out.println(nome + " - Saindo do banheiro");
        }
    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();
        synchronized (this) {

            System.out.println(nome + " - Batendo na porta");
            System.out.println(nome + " -  Entrando no banheiro");

            while (this.estaSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " - Agora o banheiro esta limpo");
            System.out.println(nome + " - Fazendo coisa demorada");

            dormeUmPouco(10000);

            this.estaSujo = true;
            
            System.out.println(nome + " - Lavando a mão");
            System.out.println(nome + " - Saindo do banheiro");
        }
    }

    public void dormeUmPouco(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperaLaFora(String nome) {

        System.out.println(nome + ", eca, banheiro está sujo");
        try {
            this.wait(); //Manda a thread esperar
            System.out.println(nome + ", depois do wait - Fui notificado que o banheiro está limpo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void limpar() {
        
        String nome = Thread.currentThread().getName();
        synchronized (this) {

            System.out.println(nome + " - Batendo na porta");
            System.out.println(nome + " -  Entrando no banheiro");

            if(!this.estaSujo) {
                System.out.println(nome + " não esta sujo, vou sair");
                return;
            }

            System.out.println(nome + " - Limpando banheiro");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.notifyAll(); //Notifica todas as Threads que o banheiro foi limpo
            
            System.out.println(nome + " - Saindo do banheiro");
        }
        
        this.estaSujo = false;
    }
}
