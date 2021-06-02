package br.jus.tream.saude.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Responsável por recuperar os arquivos dentro do projeto.
 * 
 * @author 
 *
 */
public class LeitorArquivo {
	private static LeitorArquivo instancia = null;
	private HashMap<String, String> mapaArquivosLidos = new HashMap<String, String>();

	public synchronized static LeitorArquivo getInstancia() {
		if (LeitorArquivo.instancia == null) {
			LeitorArquivo.instancia = new LeitorArquivo();
		}
		return LeitorArquivo.instancia;
	}

	private LeitorArquivo() {
	}

	/**
	 * Realiza a leitura do arquivo co
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private String ler(String path) throws IOException {
		String resultado = null;

		try (InputStream is = LeitorArquivo.class.getClassLoader().getResourceAsStream(path);
				BufferedInputStream bis = new BufferedInputStream(is);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {

			int i = bis.read();
			while (i >= 0) {
				baos.write(i);
				i = bis.read();
			}

			baos.flush();
			resultado = baos.toString("UTF-8");
			is.close();
			baos.close();
		}

		return resultado;
	}

	/**
	 * Responsável por armazenar os arquivos lidos anteriormente.
	 * @param nomeArquivo pesquisado
	 * @return arquivo pesquisado
	 * @throws IOException
	 */
	public String lerMemorizar(String nomeArquivo) throws IOException {
		String conteudo = null;

		if (!this.mapaArquivosLidos.containsKey(nomeArquivo)) {
			conteudo = this.ler(nomeArquivo);
			if (conteudo != null) {
				this.mapaArquivosLidos.put(nomeArquivo, conteudo);
			}
		} else {
			conteudo = this.mapaArquivosLidos.get(nomeArquivo);
		}
		return conteudo;
	}
}
