package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.service.NotFoundException;

import java.io.UncheckedIOException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book first = new Book(1, "Тестирование ПО", 1000, "Святослав Куликов", 500, 2001);
    private Book second = new Book(2, "Tестирование dot com", 1000, "Роман Савин", 490, 2002);
    private Book third = new Book(3, "Тестирование черного ящика", 1000, "Борис Бейзер", 480, 2003);
    private Book fourth = new Book(4, "Ключевые процессы тестирования", 1000, "Рекс Блэк", 470, 2004);
    private Book fifth = new Book(5, "Автоматизированное тестирование программного обеспечения", 1000, "Элфрид Дастин, Джефф Рэшка, Джон Пол", 460, 2005);
    private TShirt sixth = new TShirt(6, "Adidas", 500, "Yellow ", "S");
    private TShirt seventh = new TShirt(7, "Kappa", 600, "Green", "M");
    private TShirt eighth = new TShirt(8, "Befree", 700, "Blue ", "L");
    private TShirt ninth = new TShirt(9, "Under Armour", 800, "Red", "X");
    private TShirt tenth = new TShirt(10, "Puma", 900, "Blue", "XL");


    @BeforeEach
    public void setup() {
        repository.save(first);
        repository.save(second);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(tenth);

    }

    @Test // Тест удаления по ID существующего элемента
    public void testRemoveByIdExist() {
        repository.removeById(6);
        assertEquals(repository.findAll().length, 4);
    }

    @Test // Тест удаления по ID не существующего элемента
    public void testRemoveByIdNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(713));
    }
}