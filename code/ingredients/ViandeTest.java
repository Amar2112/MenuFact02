package ingredients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViandeTest {

    @Test
    void getEtat() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals(EtatIngredient.SOLIDE, e.getEtat());
    }

    @Test
    void setEtat() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals("Steak", e.getNom());
    }

    @Test
    void setNom() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setNom("Épaule de porc");
        assertEquals("Épaule de porc", e.getNom());
    }

    @Test
    void getDescription() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals("Mooouch", e.getDescription());
    }

    @Test
    void setDescription() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.VIANDE, e.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        Viande e = new Viande("Steak","Mooouch",EtatIngredient.SOLIDE);
        e.setTypeIngredient(TypeIngredient.EPICE);
        assertEquals(TypeIngredient.EPICE,e.getTypeIngredient());
    }

    @Test
    void compare() {
    }
}