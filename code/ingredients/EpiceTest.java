package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpiceTest {

    @Test
    void getEtat() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setEtat() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setNom() {
    }

    @Test
    void getDescription() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setDescription() {
        
    }

    @Test
    void getTypeIngredient() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.EPICE, e.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
    }

    @Test
    void compare() {
    }
}