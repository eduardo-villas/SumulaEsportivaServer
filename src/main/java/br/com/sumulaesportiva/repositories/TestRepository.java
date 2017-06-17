package br.com.sumulaesportiva.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.sumulaesportiva.entities.Test;

@Transactional
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {
	
}
