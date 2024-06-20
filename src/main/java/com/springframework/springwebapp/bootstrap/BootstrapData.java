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
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Data Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123456788");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher madhav = new Publisher("Madhav", "Main Street", "Chennai", "TN", "500008");
        Publisher packt = new Publisher("Packt", "Street1", "Banglore", "KN", "600001");

        publisherRepository.save(madhav);
        publisherRepository.save(packt);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
