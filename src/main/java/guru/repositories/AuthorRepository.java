package guru.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.Domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	

}
