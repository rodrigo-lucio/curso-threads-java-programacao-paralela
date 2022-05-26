package br.com.lucio.deadlock;

public class TarefaAcessaBanco implements Runnable {

	private GerenciadorDeTransacao tx;
	private PoolDeConexao pool;

	public TarefaAcessaBanco(GerenciadorDeTransacao tx, PoolDeConexao pool) {
		this.tx = tx;
		this.pool = pool;
	}

	@Override
	public void run() {

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
