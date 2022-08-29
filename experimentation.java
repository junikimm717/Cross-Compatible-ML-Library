import java.util.ArrayList;

public class experimentation {
    public static ArrayList<Integer> test() {
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(42);
        x.add(69);

        return x;
    }
    public static void main(String[] args) {
        System.out.println(test());
    }
}
