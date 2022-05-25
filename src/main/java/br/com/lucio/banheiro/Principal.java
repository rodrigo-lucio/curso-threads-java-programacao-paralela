package br.com.lucio.banheiro;

public class Principal {

	public static void main(String[] args) {
		Banheiro banheiro = new Banheiro();
		
		Thread convidado2 = new Thread(new TarefaNumero2(banheiro), "Pedro");
		Thread convidado1 = new Thread(new TarefaNumero1(banheiro), "João");
		Thread faxineira = new Thread(new TarefaLimpeza(banheiro), "Faxineira");
//		Thread convidado3 = new Thread(new TarefaNumero2(banheiro), "Rodrigo");
//		Thread convidado4 = new Thread(new TarefaNumero1(banheiro), "Julio");
		
		convidado1.start();
		convidado2.start();
		faxineira.start();
//		convidado3.start();
//		convidado4.start();
	}	
}
