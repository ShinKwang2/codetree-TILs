import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(fibbo(n));
    }

    static int fibbo(int n) {
        if (n <= 2) return 1;
        else {
            return fibbo(n - 1) + fibbo(n - 2);
        }
    }
}