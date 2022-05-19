package br.com.lucio.basico.buscatextual;

public class BuscaTextual {

	public static void main(String[] args) {

		String nome = "(Dan|Chad)(\\s|\\w)*";
		
		Thread threadAssinaturas = new Thread(new TarefaBuscaTextual("assinaturas1.txt", nome));
		Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("assinaturas2.txt", nome));
		Thread threadAssinaturas3 = new Thread(new TarefaBuscaTextual("autores.txt", nome));
		
		threadAssinaturas.start();
		threadAssinaturas2.start();
		threadAssinaturas3.start();
	
	}

}
