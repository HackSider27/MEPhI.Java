/*import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Tree t = new Tree();

        while(true){
            int m = console.nextInt();

            switch (m){
                case 0: {
                    Node node = new Node(console.nextInt(), console.nextInt());
                    t.addChild(node);
                    break;
                }
                case 1: {
                    if(t.removeChild(console.nextInt()))//int index
                        System.out.println("Great");
                    else System.out.println("Not great");
                    break;
                }
                case 2: {
                    int ind = console.nextInt();
                   if(t.find(ind) != null) {
                       System.out.println("Great");
                       System.out.println(t.find(ind).index);
                   }
                    else System.out.println("Not great");
                    break;
                }
                case 3: {
                    System.out.println(t.size());
                    if(t.isEmpty())
                        System.out.println("Empty");
                    else System.out.println("Not empty");
                    break;
                }
                case 4: {
                    List list = new List();
                    t.toList(t.getRoot(), list);
                    System.out.println(list);
                    break;
                }
            }

        }
    }
}
*/