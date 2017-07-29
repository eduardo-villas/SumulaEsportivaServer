package br.com.sumulaesportiva;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.sumulaesportiva.entities.Calendario;
import br.com.sumulaesportiva.entities.Equipe;
import br.com.sumulaesportiva.entities.Modalidade;
import br.com.sumulaesportiva.entities.Partida;
import br.com.sumulaesportiva.entities.Pessoa;
import br.com.sumulaesportiva.entities.Sumula;
import br.com.sumulaesportiva.entities.Tempo;
import br.com.sumulaesportiva.entities.Test;
import br.com.sumulaesportiva.repositories.CalendarioRepository;
import br.com.sumulaesportiva.repositories.EquipeRespository;
import br.com.sumulaesportiva.repositories.ModalidadeRepository;
import br.com.sumulaesportiva.repositories.PartidaRepository;
import br.com.sumulaesportiva.repositories.PessoaRepository;
import br.com.sumulaesportiva.repositories.SumulaRepository;
import br.com.sumulaesportiva.repositories.TestRepository;

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
	private CalendarioRepository calendarioRepository;
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(ApplicationArguments arg) throws Exception {
		Test test = new Test();
		test.setName("Eduardo");
		testRepository.save(test);

		addSumulaDefaultData();
		Pessoa pessoa = addPessoaDefaultData();
		addEquipeDefaultData(pessoa);
		addCalendarioDefaultData(getFirstPartida());

	}

	private Pessoa addPessoaDefaultData() {
		Pessoa pessoa = new Pessoa();

		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.set(Calendar.DAY_OF_MONTH, 18);
		dataNascimento.set(Calendar.MONTH, 9);
		dataNascimento.set(Calendar.YEAR, 1994);
		pessoa.setDataNascimento(dataNascimento.getTime());
		pessoa.setEmail("email@email.com");
		pessoa.setEndereco("Rua de testes, bairro testes cidade...");
		pessoa.setNome("Eduardo");
		pessoa.setRG("87151980");
		pessoa.setSexo('M');
		pessoa.setTelefone("99958978");

		pessoa = pessoaRepository.save(pessoa);
		return pessoa;
	}

	private void addCalendarioDefaultData(Partida anyPartida) {
		if (anyPartida == null) {
			throw new RuntimeException("Erro ao buscar a primeira partida.");
		}

		Calendario calendario = new Calendario();
		calendario.setDataInicio(new Date());
		calendario.setDataFim(new Date());
		ArrayList<Partida> partidas = new ArrayList<>();
		partidas.add(anyPartida);
		calendario.setPartidas(partidas);

		calendarioRepository.save(calendario);

	}

	private Partida getFirstPartida() {
		Iterable<Partida> partidas = partidaRepository.findAll();
		Iterator<Partida> iteratorPartidas = partidas.iterator();
		Partida partida = null;
		if (iteratorPartidas.hasNext())
			partida = iteratorPartidas.next();
		return partida;
	}

	private void addEquipeDefaultData(Pessoa pessoa) {
		Equipe equipe = new Equipe();
		equipe.setNome("Brasil");
		Modalidade modalidade = new Modalidade();
		equipe.setModalidade(modalidade);
		modalidade.setDescricao("Futebol");

		Tempo tempo = new Tempo();
		tempo.setDuracaoExtra(15);
		tempo.setDuracaoPeriodos(45);
		tempo.setDuracaoTimeout(0);
		tempo.setQuantidadePeriodos(2);
		tempo.setQuantidadeTemposExtras(2);
		tempo.setQuantidadeTimeout(0);

		modalidade.setTempo(tempo);
		tempo.setModalidade(modalidade);

		modalidadeRepository.save(modalidade);

		pessoa.setEquipe(equipe);
		equipe.getIntegrantes().add(pessoa);
		equipeRepository.save(equipe);
		pessoaRepository.save(pessoa);

	}

	private void addSumulaDefaultData() {
		Sumula sumula = new Sumula();

		Partida partida = new Partida();
		partida.setData(new Date());
		partida.setLocal("Maracanã");

		sumula.setPartida(partida);

		partidaRepository.save(partida);
		sumulaRepository.save(sumula);
	}

}
