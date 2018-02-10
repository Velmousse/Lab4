package personnages;
import armes.*;

/**
 * Created by DufVi1731300 on 2018-01-29.
 */
public class Barbare extends Guerrier {
   protected Contondant arme = null;

    public Barbare() {
        pointsDeForce = 10;
        pointsDeDefense = 3;
        pointsDeVie = 100;
        nom = "barbare";
    }

    public void setArme(Contondant arme) {
        this.arme = arme;
    }

    public void attaque(Personnage persoAttaque) {
        int degats = (this.pointsDeForce * 2 - persoAttaque.getPointsDeDefense());
        degats = arme.frapper(degats);
        super.attaque(persoAttaque, degats);
    }
}
