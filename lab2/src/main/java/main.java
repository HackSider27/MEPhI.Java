import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a string: ");
        String[] s = in.nextLine().split(" ");
        String outstr = new String();

        HashMap<String, Integer> map = new HashMap<>();
        //System.out.print(s);
        //String[] StringArray = s.split(" ");
        Object k;
        for (int i = 0; i < s.length; i++) {
            k = map.get(s[i]);
            if (k == null) {
                k = 1;
                outstr += s[i] + " ";
            }
            else
                k = (int) k + 1;
            map.put(s[i], (int) k);
        }

        for (Map.Entry<String, Integer> help : map.entrySet())
            System.out.println(help.getKey() + ": " + help.getValue());

            System.out.print(outstr);
    }
}
