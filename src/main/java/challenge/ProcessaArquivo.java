package challenge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessaArquivo {
	
	public List<Jogador> retornaListaRegistros(String caminhoDoArquivo) {

		List<Jogador> result = new ArrayList<>();
		Jogador jogador = new Jogador();

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(caminhoDoArquivo).getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String registro[] = line.split(",");
				
				jogador.setFull_name(registro[2]);
				jogador.setClub(registro[3]);
				jogador.setAge(registro[6]);
				jogador.setBirth_date(registro[8]);
				jogador.setNationality(registro[14]);
				jogador.setEur_wage(registro[17]);
				jogador.setEur_release_clause(registro[18]);
				
				result.add(jogador);
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return result;

	  }
}
