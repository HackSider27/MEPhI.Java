import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class List{
    private Object[] list;
    private int size;

    List(){
        size=0;
    }

    List(Object a) {
        size=1;
        list = new Object[size];
        list[0] = a;
    }

    List(Object[] a) {
        size=a.length;
        list = new Object[a.length];
        list = a;
    }

    void add(Object val) {
        size++;
        Object[] new_list = new Object[size];
        for (int i = 0; i < size-1; i++)
            new_list[i] = list[i];
        new_list[size-1] = val;
        list = new_list;
    }

    void add(Object val, int ind){
        if(ind >= size) {
            ind = size;
            add(val);
            return;
        }

        size++;
        Object[] help_list = new Object[size];
        for (int i = 0, j=0; i < size; i++, j++) {
            if(i != ind)
                help_list[i] = list[j];
            else{
                help_list[i]=val;
                i++;
            }
        }
        help_list[size-1] = val;
        list = help_list;
    }

    Object remove(int index){

        if(index > size || index <0)
            return null;

        Object[] upd_list = new Object[size-1];
        int j = 0;
        Object res = list[index];
        for (int i = 0; i < size; i++){
            if(i == index)
                continue;
            upd_list[j] = list[i];
            j++;
        }
        list = new Object[size--];
        list = upd_list;
        return res;
    }

    Object get(int index){
        if (index > size || index < 0)
            return null;
        else return list[index];
    }

    boolean contains(Object value){
        for(int i = 0; i<size; i++){
            if (list[i] == value)
                return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(size < 1)
            return false;
        return true;
    }

    int Size(){
        return size;
    }

    int indexOf(Object value){
        for(int i = 0; i < size; i++){
            if(list[i] == value)
                return i;
        }
       return -1;
    }

    void set(Object value, int index){
        if(index < 0)
            list[0] = value;
        list[index]=value;
    }
}



