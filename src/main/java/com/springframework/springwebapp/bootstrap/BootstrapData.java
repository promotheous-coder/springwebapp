package com.springframework.springwebapp.bootstrap;

import com.springframework.springwebapp.domain.Author;
import com.springframework.springwebapp.domain.Book;
import com.springframework.springwebapp.domain.Publisher;
import com.springframework.springwebapp.repository.AuthorRepository;
import com.springframework.springwebapp.repository.BookRepository;
import com.springframework.springwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher("Madhav", "Main Street", "Chennai", "TN", "500008");

        publisherRepository.save(publisher);

        System.out.println("Number of Publishers: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Data Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123456788");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());

    }
}
