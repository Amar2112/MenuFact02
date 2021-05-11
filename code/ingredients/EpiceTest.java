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
        e.setEtat(EtatIngredient.LIQUIDE);
        assertEquals(EtatIngredient.LIQUIDE, e.getEtat());

    }

    @Test
    void getNom() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals("Poudre d'ail", e.getNom());
    }

    @Test
    void setNom() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        e.setNom("Ail rôti");
        assertEquals("Ail rôti", e.getNom());
    }

    @Test
    void getDescription() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals("C'est bon", e.getDescription());
    }

    @Test
    void setDescription() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        e.setDescription("Franchement délicieux");
        assertEquals("Franchement délicieux", e.getDescription());
    }

    @Test
    void getTypeIngredient() {
        Epice e = new Epice("Poudre d'ail","C'est bon",EtatIngredient.SOLIDE);
        assertEquals(TypeIngredient.EPICE, e.getTypeIngredient());
    }

    @Test
    void compare() {
        Epice poudreAil1 = new Epice("Poudre d'ail","Poudre blanc",EtatIngredient.SOLIDE);
        Epice poudreAil2 = new Epice("Poudre d'ail","Poudre blanc",EtatIngredient.SOLIDE);
        Epice sel = new Epice("Sel","Poudre blanc",EtatIngredient.SOLIDE);
        Epice poudreAilJaune = new Epice("Poudre d'ail","Poudre jaune",EtatIngredient.SOLIDE);
        Epice poudreAilLiquide =new Epice("Poudre d'ail","Poudre blanc",EtatIngredient.LIQUIDE);

        assertFalse(poudreAil1.compare(sel));
        assertFalse(poudreAilJaune.compare(poudreAil1));
        assertFalse(poudreAilLiquide.compare(poudreAil1));
        assertTrue(poudreAil1.compare(poudreAil2));


    }
}