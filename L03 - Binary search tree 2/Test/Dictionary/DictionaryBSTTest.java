package Dictionary;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DictionaryBSTTest {


    @Test
    @Order(1)
    void get() {
        // Arrange
        DictionaryBST<Integer, String> dictionary = new DictionaryBST<Integer, String>();
        dictionary.put(83, "Demogorgons");
        dictionary.put(25, "Datamatiker!");
        dictionary.put(99, "Bryan Adams");
        dictionary.put(93, "Brosten");
        dictionary.put(100, "");
        dictionary.put(12, "Domme");
        dictionary.put(82, "Matadormix");

        // Act
        String actual = dictionary.get(25);
        String expected = "Datamatiker!";

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    void test_isEmpty_true() {
        DictionaryBST<Integer, String> dictionary = new DictionaryBST<Integer, String>();
        dictionary.put(83, "Demogorgons");

        // Act
        boolean expected = true;
        boolean actual = dictionary.isEmpty();

        //Assert
        assertEquals(expected, actual);

    }

    @Test
    @Order(3)
    void test_isEmpty_false() {
        DictionaryBST<Integer, String> dictionary = new DictionaryBST<Integer, String>();
        dictionary.put(83, "Demogorgons");
        String actual = dictionary.get(25);

        // Act
        boolean expected = false;
        boolean actual2 = dictionary.isEmpty();

        //Assert
        assertEquals(expected, actual2);

    }

    @Test
    @Order(4)
    void put() {
        DictionaryBST<Integer, String> dictionary = new DictionaryBST<Integer, String>();
        dictionary.put(83, "Demogorgons");
        dictionary.put(25, "Datamatiker!");
        dictionary.put(99, "Bryan Adams");

        // Act
        String expected = "Bryan Adams";
        String actual = dictionary.put(99, "Prince");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(5)
    void test_remove() {
        DictionaryBST<Integer, String> dictionary = new DictionaryBST<Integer, String>();
        dictionary.put(83, "Demogorgons");
        dictionary.put(25, "Datamatiker!");
        dictionary.put(99, "Bryan Adams");
        dictionary.put(93, "Brosten");
        dictionary.put(100, "");
        dictionary.put(12, "Domme");
        dictionary.put(82, "Matadormix");

        // Act
        String expected = "Demogorgons";
        String actual = dictionary.remove(85);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(6)
    void test_size() {
        DictionaryBST<Integer, String> dictionary = new DictionaryBST<Integer, String>();

        // Act & Assert
        assertEquals(0, dictionary.size());
        dictionary.put(83, "Demogorgons");
        assertEquals(1, dictionary.size());
        dictionary.put(25, "Datamatiker!");
        assertEquals(2, dictionary.size());
        dictionary.put(99, "Bryan Adams");
        assertEquals(3, dictionary.size());
        dictionary.put(93, "Brosten");
        assertEquals(4, dictionary.size());
        dictionary.put(100, "");
        assertEquals(5, dictionary.size());
        dictionary.remove(85);
        assertEquals(4, dictionary.size());
    }
}