package personnages;
import armes.*;

/**
 * Created by DufVi1731300 on 2018-01-29.
 */
public class Paladin extends Guerrier {
    protected Tranchant arme = null;

    public Paladin() {
        pointsDeForce = 5;
        pointsDeDefense = 5;
        pointsDeVie = 80;
        nom = "paladin";
    }

    public void setArme(Tranchant arme) {
        this.arme = arme;
    }

    public void attaque(Personnage persoAttaque) {
        int degats = (this.pointsDeForce * 2 - persoAttaque.getPointsDeDefense());
        degats = arme.trancher(degats);
        super.attaque(persoAttaque, degats);
    }
}
