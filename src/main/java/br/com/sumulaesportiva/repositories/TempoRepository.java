// Eduardo
package br.com.sumulaesportiva.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sumulaesportiva.entities.Tempo;

@RepositoryRestResource(collectionResourceRel = "tempo", path = "tempo")
public interface TempoRepository extends PagingAndSortingRepository<Tempo, Long> {

}
