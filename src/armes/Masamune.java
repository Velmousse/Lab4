package armes;

/**
 * Created by DufVi1731300 on 2018-02-08.
 */
public class Masamune implements Contondant, Tranchant, Magique{
    public int trancher(int degats) {
        return (degats + 6);
    }

    public int frapper(int degats) {
        return (degats + 5);
    }

    public int lancerUnSort(int degats) {
        return (degats + 6);
    }
}
