package br.com.lucio.deadlock;

public class PrincipalBanco {

	public static void main(String[] args) {
        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();
        
        new Thread(new TarefaAcessaBanco(tx, pool)).start();
        new Thread(new TarefaAcessaBancoProcedimento(tx, pool)).start();
	}

}
