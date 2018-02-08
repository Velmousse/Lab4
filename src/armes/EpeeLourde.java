package armes;

/**
 * Created by DufVi1731300 on 2018-02-08.
 */
public class EpeeLourde implements Tranchant, Contondant {
    public int trancher(int degats) {
        return (degats + 6);
    }

    public int frapper(int degats) {
        return (degats + 3);
    }
}
