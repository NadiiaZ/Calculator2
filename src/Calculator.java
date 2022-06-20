
import java.util.Scanner;

public class Calculator {

    public static void main (String[] args)
    {
        System.out.println("Enter:");
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        Count _count = new Count();
        _count.input(s);
        _count.outPut();
    }
}