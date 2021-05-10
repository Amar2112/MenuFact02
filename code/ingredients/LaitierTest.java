package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaitierTest {

    @Test
    void getEtat() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());
    }

    @Test
    void setEtat() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setEtat(EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals("Lait", e.getNom());
    }

    @Test
    void setNom() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setNom("Crème");
        assertEquals("Crème", e.getNom());
    }

    @Test
    void getDescription() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals("Moo", e.getDescription());
    }

    @Test
    void setDescription() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        assertEquals(TypeIngredient.LAITIER, e.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        Laitier e = new Laitier("Lait","Moo",EtatIngredient.LIQUIDE);
        e.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE,e.getTypeIngredient());
    }

    @Test
    void compare() {
    }
}