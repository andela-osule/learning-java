
public class WhileLoopsApp {

    public static void main(String[] args) {
        // Using while loops
        boolean loop = true;
        System.out.println(loop);

        loop = 4 < 5;
        System.out.println(loop);

        loop = 6 < 1;
        System.out.println(loop);

        int value = 0;

        while (value < 10) {
            System.out.println("Hello " + value);
            value = value + 1;
        }

    }

}
