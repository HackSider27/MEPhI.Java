import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        List list=new List(1);
        list.add(7);
        assertEquals(7,list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testAdd1() {
        List list=new List(1);
        list.add(1);
        list.add(2);
        list.add(3,1);
        assertEquals(3,list.get(1));
    }

    @org.junit.jupiter.api.Test
    void testMerge(){
        int[] a = {1,3,7,8,10};
        int[] b = {2,4,5,6,9};
        int[] c = {1,2,3,4,5,6,7,8,9,10};
        List list=new List(a);
        int[] result=list.merge(b);
        for(int i=0; i< b.length; i++)
            assertSame(b[i], result[i]);
    }

}