/**
 * Driver class to test RollerCoaster and Trolley Objects.
 * @author Arihant Birani
 * @version 1.0
 */
public class Driver {
    /**
     * Main method to create objects.
     * @param args Allows for the creation of objects
     */
    public static void main(String[] args) {
        RollerCoaster r = new RollerCoaster("aba", 10, 100);
        RollerCoaster s = new RollerCoaster("abaa", 9, 95);

        Trolley t = new Trolley("aa", new String[]{"aba"}, 5);
        Trolley u = new Trolley("aab", new String[]{"abab"}, 7);
    }
}