package rs.ac.bg.fon.nprog.mvnbiblioteka2026;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KnjigaTest {

    Knjiga k;

    @BeforeEach
    void setUp() throws Exception {
        k = new Knjiga();
    }

    @AfterEach
    void tearDown() throws Exception {
        k = null;
    }

    @Test
    void testKnjiga() {
        assertNotNull(k);
    }

    @Test
    void testSetNaslov() {
        k.setNaslov("Na Drini cuprija");
        assertEquals("Na Drini cuprija", k.getNaslov());
    }

    @Test
    void testSetNaslovNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setNaslov(null));
    }

    @Test
    void testSetNaslovPrazanString() {
        Exception e = assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setNaslov(""));
        assertEquals("Naslov ne sme biti prazan", e.getMessage());
    }

    @Test
    void testSetIsbn() {
        k.setIsbn(123456789L);
        assertEquals(123456789L, k.getIsbn());
    }

    @Test
    void testSetIsbnNulaIliManje() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setIsbn(0));
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setIsbn(-100));
    }

    @Test
    void testSetIzdavac() {
        k.setIzdavac("Laguna");
        assertEquals("Laguna", k.getIzdavac());
    }

    @Test
    void testSetIzdavacNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setIzdavac(null));
    }

    @Test
    void testSetIzdavacPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setIzdavac(""));
    }

    @Test
    void testSetIzdanje() {
        k.setIzdanje(1);
        assertEquals(1, k.getIzdanje());
    }

    @Test
    void testSetIzdanjeNulaIliManje() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setIzdanje(0));
    }

    @Test
    void testSetAutori() {
        List<Autor> autori = new ArrayList<>();
        autori.add(new Autor("Ivo", "Andric"));
        
        k.setAutori(autori);
        
        assertEquals(autori, k.getAutori());
        assertEquals(1, k.getAutori().size());
        assertEquals("Ivo", k.getAutori().get(0).getIme());
    }

    @Test
    void testToString() {
        k.setNaslov("Prokleta avlija");
        k.setIsbn(987654321L);
        k.setIzdanje(44);
        k.setIzdavac("Laguna");
        List<Autor> autori = new ArrayList<>();
        autori.add(new Autor("Ivo", "Andric"));
        
        k.setAutori(autori);
        
        String s = k.toString();
        
        assertTrue(s.contains("Prokleta avlija"));
        assertTrue(s.contains("987654321"));
        assertTrue(s.contains("Ivo"));
        assertTrue(s.contains("Andric"));
        assertTrue(s.contains("44"));
        assertTrue(s.contains("Laguna"));
    }

    @Test
    void testHashCode() {
        k.setIsbn(112233L);
        Knjiga k2 = new Knjiga();
        k2.setIsbn(112233L);
        
        assertEquals(k.hashCode(), k2.hashCode());
    }

    @ParameterizedTest
    @DisplayName("Testovi za equals metodu (preko ISBN-a)")
    @CsvSource({
        "123, 123, true",
        "123, 456, false"
    })
    void testEqualsObject(long isbn1, long isbn2, boolean jednako) {
        k.setIsbn(isbn1);
        
        Knjiga k2 = new Knjiga();
        k2.setIsbn(isbn2);
        
        assertEquals(jednako, k.equals(k2));
    }

    @Test
    void testEqualsNull() {
        assertFalse(k.equals(null));
    }

    @Test
    void testEqualsDrugaKlasa() {
        assertFalse(k.equals(new Autor()));
    }
}