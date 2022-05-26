package br.com.lucio.deadlock;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(GerenciadorDeTransacao tx, PoolDeConexao pool) {
		this.tx = tx;
		this.pool = pool;
	}

	@Override
	public void run() {

		/*
		synchronized (tx) {
			
			System.out.println("Começando a gerenciar a transação");
			tx.begin();
			
			synchronized (pool) {
				System.out.println("Peguei a chave do pool:");
				pool.getConnection();
			}
			
		}*/
		//O bloco acima está bloqueando a execução da classe TarefaAcessaBanco.java, ocasionando um deadlock.
		//Os syncronized devem ser sempre na mesma ordem para que isso não ocorra, ficando assim:
		
		synchronized (pool) {

			System.out.println("Peguei a chave do pool: " + this.getClass().getSimpleName());
			pool.getConnection();
			
			synchronized (tx) {
				System.out.println("Começando a gerenciar a transação: " + this.getClass().getSimpleName());
				tx.begin();
				
			}
			
		}
		System.out.println("Encerrando: " + this.getClass().getSimpleName());
		
	}

}
