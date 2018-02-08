package armes;

/**
 * Created by DufVi1731300 on 2018-02-08.
 */
public class EpeeMagique implements Tranchant, Magique {
    public int trancher(int degats) {
        return (degats + 6);
    }

    public int lancerUnSort(int degats) {
        return (degats + 3);
    }
}
