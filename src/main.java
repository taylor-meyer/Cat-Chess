
public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.

        int[] pos = new int[2];
        pos[0] = 1;
        pos[1] = 1;
        King k = new King(true, pos);

        System.out.println("iswhite: " + k.isWhite());
        System.out.println("pos: [" + k.getPosition()[0] + ", " + k.getPosition()[1] + "]");

    }
}
