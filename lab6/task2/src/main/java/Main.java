import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;

class Item implements Serializable{
    private final int id;
    private final String description;
    private final double cost;

    Item(int newId, String newDescription, double newCost) {
        id = newId;
        description = newDescription;
        cost = newCost;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return id + "\t" + description + "\t" + cost;
    }
}

class ShoppingCart implements Serializable {
    private final int cartID;
    public ArrayList<Item> items;
    private int itemCount;
    transient private double cartTotal;

    ShoppingCart() {
        cartID = 0;
        items = new ArrayList<>();
        itemCount = 0;
        cartTotal = 0;
    }

    /**
     * Download into file
     *
     * @param way - way to file from uploading info
     */
    public void serialize(String way) {
        try {
            FileOutputStream fos =
                    new FileOutputStream(way);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setCartTotal(int cartTotal) {
        this.cartTotal = cartTotal;
    }

    public ShoppingCart random() {
        Random r = new Random();

        Item[] list = new Item[]{
                new Item(1, "bread", 50),
                new Item(2, "chips", 90),
                new Item(3, "cheese", 350),
                new Item(4, "sausage", 200),
                new Item(5, "cottage cheese", 150),
                new Item(6, "sour cream", 120),
                new Item(7, "gum", 30),
                new Item(8, "water", 20),
                new Item(9, "cake", 450),
                new Item(10, "tea", 170),
        };

        ShoppingCart rnd = new ShoppingCart();
        for (int i = 0; i < 15; i++) {
            rnd.put(list[Math.abs(r.nextInt() % list.length)]);
        }
        return rnd;
    }

    public void put(Item item) {
        items.add(item);
        itemCount++;
        cartTotal += item.getCost();
    }

    public void print() {
        System.out.println("cartID: " + cartID + "\nTotal: " + cartTotal + "\nCount of items: " + itemCount);
        System.out.println("id\tdescription\tcost\t");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items.get(i).toString());
        }
    }
}

public class Main {
    /**
     * Download from file
     *
     * @param way - way to file, where downloading info
     * @return result by ShoppingCart type
     */
    public static ShoppingCart deserialize(String way) {
        ShoppingCart sc2 = null;
        try {
            FileInputStream fis = new FileInputStream(way);
            ObjectInputStream ois = new ObjectInputStream(fis);

            int ct = 0;
            sc2 = (ShoppingCart) ois.readObject();
            for (int i = 0; i < sc2.getItemCount(); i++) {
                ct += sc2.items.get(i).getCost();
            }
            sc2.setCartTotal(ct);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
        return sc2;
    }

    public static void main(String[] args) {

        String way = "C:\\Users\\User\\Desktop\\MEPhI.Java\\lab6\\task2\\src\\main\\resources\\shoppingCart.db";
        ShoppingCart sc1 = new ShoppingCart().random();

        sc1.serialize(way);
        ShoppingCart sc2 = deserialize(way);

        System.out.println(sc1);
        sc1.print();
        System.out.println();

        System.out.println(sc2);
        sc2.print();
    }
}
