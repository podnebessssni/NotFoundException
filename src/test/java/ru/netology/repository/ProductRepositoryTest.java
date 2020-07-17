package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exeption.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    Product item1 = new Book(1,"Anna Karenina", 120, "Tolstoy");
    Product item2 = new Smartphone(2,"iphone8SE", 400, "Apple");
    Product item3 = new Book(3,"Tom Sawyer", 80, "Mark Twain");
    Product item4 = new Smartphone(4,"MI10", 350, "Xiaomi");
    Product item5 = new Book(5,"1984", 120, "George Orwell");

    @BeforeEach
    void setUp()
    {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);

    }

    @Test
    void shouldDeleteById(){

    repository.removeById(3);
    Product[] expected = {new Book(1,"Anna Karenina", 120, "Tolstoy"),
                          new Smartphone(2,"iphone8SE", 400, "Apple"),
                          new Smartphone(4,"MI10", 350, "Xiaomi"),
                          new Book(5,"1984", 120, "George Orwell")};
    assertArrayEquals(expected, repository.findAll());

    }

    @Test
    void shouldNotDeleteByNoExistId(){

    assertThrows(NotFoundException.class, () -> repository.removeById(0));

    }


}