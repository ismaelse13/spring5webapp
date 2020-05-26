package guru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.Domain.Author;
import guru.Domain.Book;
import guru.repositories.AuthorRepository;
import guru.repositories.BookRepository;



@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Author mael = new Author("Maelsu", "Mabel");
		Book cookbook = new Book("Art of Cookies", "123456");
		mael.getBooks().add(cookbook);
		cookbook.getAuthors().add(mael);

		authorRepository.save(mael);
		bookRepository.save(cookbook);
		
		Author plablo = new Author("Plablo", "Leemah");
		Book biografia = new Book("Biografia Autorizada", "6070202");
		plablo.getBooks().add(biografia);
		biografia.getAuthors().add(plablo);
		
		authorRepository.save(plablo);
		bookRepository.save(biografia);
				
		System.out.println("Started in BootStrap");
		System.out.println("Number of books: "+ bookRepository.count());
	}

}
