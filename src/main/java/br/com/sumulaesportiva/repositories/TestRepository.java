package br.com.sumulaesportiva.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;

@Transactional
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {
	
}
