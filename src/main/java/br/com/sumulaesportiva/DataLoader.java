package br.com.sumulaesportiva;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.sumulaesportiva.entities.Equipe;
import br.com.sumulaesportiva.entities.Modalidade;
import br.com.sumulaesportiva.entities.Partida;
import br.com.sumulaesportiva.entities.Sumula;
import br.com.sumulaesportiva.entities.Tempo;
import br.com.sumulaesportiva.entities.Test;
import br.com.sumulaesportiva.repositories.SumulaRepository;
import br.com.sumulaesportiva.repositories.TempoRepository;
import br.com.sumulaesportiva.repositories.TestRepository;
import br.com.sumulaesportiva.repositories.EquipeRespository;
import br.com.sumulaesportiva.repositories.ModalidadeRepository;
import br.com.sumulaesportiva.repositories.PartidaRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private TestRepository testRepository;
	@Autowired
	private SumulaRepository sumulaRepository;
	@Autowired
	private PartidaRepository partidaRepository;
	@Autowired 
	private EquipeRespository equipeRepository;
	@Autowired
	private ModalidadeRepository modalidadeRepository; 
	@Autowired
	private TempoRepository tempoRepository;
	
	@Override
	public void run(ApplicationArguments arg) throws Exception {
		Test test = new Test();
		test.setName("Eduardo");
		testRepository.save(test);
		
		addSumulaDefaultData();
		addEquipeDefaultData();
		
	}

	private void addEquipeDefaultData() {
		Equipe equipe = new Equipe();
		equipe.setNome("Brasil");
		Modalidade modalidade = new Modalidade();
		equipe.setModalidade(modalidade);
		modalidade.setDescricao("Futebol");
		
		Tempo tempo = new Tempo();
		tempo.setDescricao("Tempo");
		tempo.setDuracaoExtra(15);
		tempo.setDuracaoPeriodos(45);
		tempo.setDuracaoTimeout(0);
		tempo.setQuantidadePeriodos(2);
		tempo.setQuantidadeTemposExtras(2);
		tempo.setQuantidadeTimeout(0);
		
		modalidade.setTempo(tempo);
		
		tempoRepository.save(tempo);
		modalidadeRepository.save(modalidade);
		equipeRepository.save(equipe);		
		
	}

	private void addSumulaDefaultData() {
		Sumula sumula = new Sumula();
		
		Partida partida = new Partida();
		partida.setData(new Date());
		partida.setHora(LocalTime.now());
		partida.setLocal("Maracanã");
		
		sumula.setPartida(partida);
		
		partidaRepository.save(partida);
		sumulaRepository.save(sumula);
	}

}
