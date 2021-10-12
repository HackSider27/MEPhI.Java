import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @org.junit.jupiter.api.Test
    void testMerge(){
        Object[] a = {1, 3, 6, 7, 9};
        Object[] b = {2, 4, 5, 8, 10};
        Object[] c = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
        List list=new List(a);
        Object[] result=list.merge(b);
        for(int i=0; i< c.length; i++)
            assertSame(c[i], result[i]);
    }
}