/**
 * Created by DufVi1731300 on 2018-01-29.
 */
import armes.*;
import com.sun.prism.shader.Texture_RadialGradient_PAD_AlphaTest_Loader;
import personnages.*;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Personnage j1 = null, j2 = null, jc = j1;
        String position = "premier";

        for (int i = 0; i < 2; i++) {
            jc = choixPersonnage(position);
            System.out.println("\nQuelle arme voulez-nous lui assigner?");
            if (jc instanceof Barbare) ((Barbare) jc).setArme(choixArmeContondant());
            else if (jc instanceof Paladin) ((Paladin) jc).setArme(choixArmeTranchant());
            else ((Magicien) jc).setArme(choixArmeMagique());
            System.out.println();

            if (i == 0) j1 = jc;
            else if (i == 1) j2 = jc;
            position = "deuxième";
        }
        combat(j1, j2);

        sc.close();
    }

    public static void combat(Personnage premier, Personnage deuxieme) {
        while (true) {
            if (!matchNul(premier, deuxieme)) {
                premier.attaque(deuxieme);
                if (deuxieme.getPointsDeVie() <= 0) {
                    System.out.print("Le " + premier.getNom() + " gagne la partie!");
                    return;
                }
                System.out.println();
                deuxieme.attaque(premier);
                System.out.print("\n");
                if (premier.getPointsDeVie() <= 0) {
                    System.out.print("Le " + deuxieme.getNom() + " gagne la partie!");
                    return;
                }
            }
            else {
                System.out.print("Match nul!");
                return;
            }
        }
    }

    public static Personnage choixPersonnage(String position) {
        System.out.print("Veuillez choisir le " + position + " personnage\n" +
                " 1- Barbare\n" +
                " 2- Paladin\n" +
                " 3- Magicien noir\n" +
                " 4- Magicien rouge\n" +
                "> ");
        switch (sc.nextInt()) {
            case 1: return new Barbare();
            case 2: return new Paladin();
            case 3: return new MagicienNoir();
            case 4: default: return new MagicienRouge();
        }
    }

    public static Contondant choixArmeContondant() {
        System.out.print("1- Masse\n" +
                "2- Épée lourde\n" +
                "3- Sceptre\n" +
                "4- Masamune\n" +
                "> ");
        switch(sc.nextInt()) {
            case 1: return new Masse();
            case 2: return new EpeeLourde();
            case 3: return new Sceptre();
            case 4: default: return new Masamune();
        }
    }

    public static Tranchant choixArmeTranchant() {
        System.out.print("1- Épée\n" +
                "2- Épée magique\n" +
                "3- Épée lourde\n" +
                "4- Masamune\n" +
                "> ");
        switch (sc.nextInt()) {
            case 1: return new Epee();
            case 2: return new EpeeMagique();
            case 3: return new EpeeLourde();
            case 4: default: return new Masamune();
        }
    }

    public static Magique choixArmeMagique() {
        System.out.print("1- Baguette\n" +
                "2- Épée magique\n" +
                "3- Sceptre\n" +
                "4- Masamune\n" +
                "> ");
        switch (sc.nextInt()) {
            case 1: return new Baguette();
            case 2: return new EpeeMagique();
            case 3: return new Sceptre();
            case 4: default: return new Masamune();
        }
    }

    public static boolean matchNul(Personnage premier, Personnage deuxieme) {
        if (premier instanceof Magicien && deuxieme instanceof Magicien) {
            if (((Magicien) premier).getPointsDeMagie() <= 0 && ((Magicien) deuxieme).getPointsDeMagie() <= 0)
                return true;
        }
        return false;
    }
}
