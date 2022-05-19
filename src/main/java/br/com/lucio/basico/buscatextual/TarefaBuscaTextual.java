package br.com.lucio.basico.buscatextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	@Override
	public void run() {

		try {

			Scanner scanner = new Scanner(new File(nomeArquivo));
			int numeroLinha = 1;
			while (scanner.hasNext()) {
				String linha = scanner.nextLine();

//				if(linha.toLowerCase().contains(nome.toLowerCase())) {
				if (linha.matches(nome)) {
					System.out.println(nomeArquivo + " linha " + numeroLinha + " - Nome encontrado: " + linha);
				}
				numeroLinha++;
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
