package com.spring.mvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.mvc.repository.Book;
import com.spring.mvc.repository.BookRepository;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
	
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    private BookRepository bookRepository;
	
	@Override
    public void run(String... args) {
        log.info("StartApplication...");
        runJDBC();
    }
	
	void runJDBC() {

        log.info("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE books(" +
                "id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");

        List<Book> books = Arrays.asList(
                new Book("Project1", new BigDecimal("46.32")),
                new Book("Project 2", new BigDecimal("1.99")),
                new Book("Project 3", new BigDecimal("37.3")),
                new Book("Project 4", new BigDecimal("41.19"))
        );

        log.info("[SAVE]");
        books.forEach(book -> {
            log.info("Saving...{}", book.getName());
            bookRepository.save(book);
        });

        // count
        log.info("[COUNT] Total books: {}", bookRepository.count());

        // find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());

        // find by id
        log.info("[FIND_BY_ID] :2L");
        Book book = bookRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
        log.info("{}", book);

        // find by name (like) and price
        log.info("[FIND_BY_NAME_AND_PRICE] : like '%Java%' and price <= 10");
        log.info("{}", bookRepository.findByNameAndPrice("Java", new BigDecimal(10)));

        // get name (string) by id
        log.info("[GET_NAME_BY_ID] :1L = {}", bookRepository.getNameById(1L));

        // update
        log.info("[UPDATE] :2L :99.99");
        book.setPrice(new BigDecimal("99.99"));
        log.info("rows affected: {}", bookRepository.update(book));

        // delete
        log.info("[DELETE] :3L");
        log.info("rows affected: {}", bookRepository.deleteById(3L));

        // find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());

    }
}
