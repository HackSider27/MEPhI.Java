import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        List list = new List(1);
        list.add(7);
        assertEquals(7, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testAdd1() {
        List list = new List(1);
        list.add(1);
        list.add(2);
        list.add(3, 1);
        assertEquals(3, list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testMerge() {
        int[] q = {1, 3, 7, 8};
        int[] w = {2, 4, 5, 6, 9};
        int[] e = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List a = new List(q);
        List b = new List(w);
        List c = new List(e);
        //a.add(1);
        //b.add(3);
        //c.add(1);
        //c.add(3);

        List result = new List();
        result = a.merge(b);
        for (int i = 0; i < c.Size() - 1; i++)
            assertEquals(c.get(i), result.get(i));
    }

}