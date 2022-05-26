package br.com.lucio.listas.primitivas;

public class TarefaImprimir implements Runnable {

    private Lista lista;

    public TarefaImprimir(Lista lista) {
        this.lista = lista;

    }

    @Override
    public void run() {
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        
        synchronized (lista) {
            
            //só espera (wait) se a lista não estiver cheia
            //Pois a Thread que preenche pode notificar antes, nao ocorrendo a impressão dos elementos
        	//Nesse caso forçamos a demora no bloco acima com o sleep
        	//Caso comentar o sleep, ai vai cair neste IF
        	if(lista.naoEstaCheia()) {
                
                try {
                    
                    System.out.println("Agurdando notificação que a lista foi totalmente prenchida:");
                    
                    //O wait tem que ser sincronizado, se nao dá exception
                    lista.wait(); 
                    //Com o Dessa maneira, não há o risco que o thread fique esperando sem ser notificado!
                    
                    System.out.println("Fui notificada que todos os elementos foram adicionados na lista, agora vou imprimi-los:");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                  
            }
            
            for (int i = 0; i < lista.tamanho(); i++) { 
                System.out.println(i + " - " + lista.pegaElemento(i));
            }
            
        }
        
    }

}
