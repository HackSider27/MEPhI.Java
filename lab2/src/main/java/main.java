import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        String[] s = in.nextLine().split(" ");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //System.out.print(s);
        //String[] StringArray = s.split(" ");
        Object k;
        for (int i = 0; i < s.length; i++) {
            k = map.get(s[i]);
            if (k == null)
                k = 1;
            else
                k = (int) k + 1;
            map.put(s[i], (int) k);
        }

        for (Map.Entry<String, Integer> help : map.entrySet())
            System.out.println(help.getKey() + ": " + help.getValue());

        for (Map.Entry<String, Integer> help : map.entrySet())
            System.out.print(help.getKey() + " ");
    }
}
