package menufact;

import ingredients.*;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;

import java.util.ArrayList;

public class TestMenuFact01 {
    public static void main(String[] args) {

        try {
            Inventaire inventaire = Inventaire.getInstance();
            Legume pommeDeTerre = new Legume("Pomme de terre", "C'est des bonnes pommes de terre", EtatIngredient.SOLIDE);
            Laitier sauce = new Laitier("Sauce brune", "Sauce pour frite sauce", EtatIngredient.LIQUIDE);
            System.out.println("---Preparation des ingredients pour frites");
            ArrayList<IngredientInventaire> listePourFritesSauce = new ArrayList();
            IngredientInventaire nbFrites = new IngredientInventaire(pommeDeTerre, 1);
            IngredientInventaire nbSauce = new IngredientInventaire(sauce, 280);

            listePourFritesSauce.add(nbFrites);
            listePourFritesSauce.add(nbSauce);
            inventaire.ajouter(nbFrites);
            inventaire.ajouter(nbSauce);
            ArrayList<IngredientInventaire> listePourFrites = new ArrayList();
            listePourFrites.add(nbFrites);

            System.out.println("---Preparation des ingredients pour salade");
            ArrayList<IngredientInventaire> listePourSalade = new ArrayList();

            Legume laitue = new Legume("Laitue", "laitue iceberg", EtatIngredient.SOLIDE);
            Laitier fromage = new Laitier("Fromage", "feta", EtatIngredient.SOLIDE);

            IngredientInventaire nbLaitue = new IngredientInventaire(laitue,300);
            IngredientInventaire nbFromage = new IngredientInventaire(fromage, 800);
            listePourSalade.add(nbLaitue);

            ArrayList<IngredientInventaire> listePourSaladeCesar = new ArrayList();
            listePourSaladeCesar.add(nbLaitue);
            listePourSaladeCesar.add(nbFromage);



            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            PlatAuMenu p1 = new PlatAuMenu(0, "Frites sauce", 11.50,listePourFritesSauce);
            System.out.println(p1);

            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            PlatAuMenu p2 = new PlatAuMenu(1, "Frites", 10.25, listePourFrites);
            System.out.println(p2);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatSante ps1 = new PlatSante(2, "Salade", 5.25, 100, 10, 1,listePourSalade);
            System.out.println(ps1);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatSante ps2 = new PlatSante(3, "Salade Cesar", 8.25, 100, 10, 1,listePourSaladeCesar);
            System.out.println(ps2);

            System.out.println("===menufact.Menu ajout avec 4 plats");
            Menu menu = Menu.getInstance();
            menu.ajoute(p1);
            menu.ajoute(p2);
            menu.ajoute(ps1);
            menu.ajoute(ps2);
            System.out.println(menu);

            System.out.println("===menufact.Menu position 1, plat ?? la position 0");
            menu.position(0);
            System.out.println(menu.platCourant());

            System.out.println("===menufact.Menu position 1, plat ?? la position suivante 1");
            menu.positionSuivante();
            System.out.println(menu.platCourant());

            System.out.println("== Plat choisi");
            PlatChoisi pch1 = new PlatChoisi(p1, 5);
            System.out.println(pch1);

            System.out.println("== New menufact.facture.Facture");
            Facture facture = new Facture("Ma facture");
            System.out.println(facture);

            System.out.println("== Ajout d'un plat choisie ?? la facture");
            facture.ajoutePlat(pch1);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println("== Ajout d'un plat choisie ?? la facture");
            PlatChoisi pch2 = new PlatChoisi(p2, 10);
            facture.ajoutePlat(pch2);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println(facture.total());
            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.fermer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.payer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());
        }catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

    }
}
