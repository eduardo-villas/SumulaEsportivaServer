package br.com.sumulaesportiva;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.sumulaesportiva.entities.Partida;
import br.com.sumulaesportiva.entities.Sumula;
import br.com.sumulaesportiva.entities.Test;
import br.com.sumulaesportiva.repositories.SumulaRepository;
import br.com.sumulaesportiva.repositories.TestRepository;
import br.com.sumulaesportiva.repositories.PartidaRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private TestRepository testRepository;
	@Autowired
	private SumulaRepository sumulaRepository;
	@Autowired
	private PartidaRepository partidaRepository;
	
	@Override
	public void run(ApplicationArguments arg) throws Exception {
		Test test = new Test();
		test.setName("Eduardo");
		testRepository.save(test);
		
		Sumula sumula = new Sumula();
		
		Partida partida = new Partida();
		partida.setData(new Date());
		partida.setHora(10);
		
		sumula.setPartida(partida);
		
		partidaRepository.save(partida);
		sumulaRepository.save(sumula);
		
	}

}
