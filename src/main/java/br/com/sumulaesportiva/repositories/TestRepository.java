package br.com.sumulaesportiva.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface TestRepository extends JpaRepository<Test, Long> {
	
}
