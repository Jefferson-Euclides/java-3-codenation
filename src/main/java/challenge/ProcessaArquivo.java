package challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessaArquivo {
	
	@SuppressWarnings("resource")
	public static List<Jogador> retornaListaRegistros(String caminhoDoArquivo) {
		Jogador jogador = new Jogador();
		
		try {
			List<Jogador> listaRegistros = new ArrayList<>();
			String arquivoCSV = new File(caminhoDoArquivo).getCanonicalPath();
			BufferedReader br = new BufferedReader(new FileReader(arquivoCSV));
			String linha;
			
			while ((linha = br.readLine()) != null) {	
				String registro[] = linha.split(",");
				
				jogador.setFull_name(registro[2]);
				jogador.setClub(registro[3]);
				jogador.setAge(registro[6]);
				jogador.setBirth_date(registro[8]);
				jogador.setNationality(registro[14]);
				jogador.setEur_wage(registro[17]);
				jogador.setEur_release_clause(registro[18]);
				
				listaRegistros.add(jogador);
			}
			return listaRegistros;
		}catch(IOException e) {
			e.getMessage();
			return null;
		}
	}
}
