package br.com.lucio.banheiro;

public class Banheiro {

	public void fazNumero1() {

		String nome = Thread.currentThread().getName();

		System.out.println(nome + " - Batendo na porta");
		
		synchronized (this) {

			System.out.println(nome + " - Entrando no banheiro");
			System.out.println(nome + " - Fazendo coisa rápida");

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nome + " - Lavando a mão");
			System.out.println(nome + " - Saindo do banheiro");
		}
	}

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " - Batendo na porta");
		synchronized (this) {

			System.out.println(nome + " -  Entrando no banheiro");
			System.out.println(nome + " - Fazendo coisa demorada");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(nome + " - Lavando a mão");
			System.out.println(nome + " - Saindo do banheiro");

		}
	}

}
