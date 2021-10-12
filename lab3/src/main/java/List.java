import java.security.cert.TrustAnchor;
import java.util.Scanner;

public class List {
    private int[] list;
    private int size;

    List() {
        size = 0;
    }

    List(int a) {
        size = 1;
        list = new int[size];
        list[0] = a;
    }

    List(int[] a) {
        size = a.length;
        list = new int[a.length];
        list = a;
    }

    /**
     * <p>Перегруженный метод добавления элемента "val" в текущий список</p>
     *
     * @param val - объект добавления в список
     */
    void add(int val) {
        size++;
        int[] new_list = new int[size];
        for (int i = 0; i < size - 1; i++)
            new_list[i] = list[i];
        new_list[size - 1] = val;
        list = new_list;
    }

    /**
     * <p>Перегруженный метод добавления элемента "val" в текущий список на позицию "ind"</p>
     *
     * @param val - объект добавления в список
     * @param ind - позиция добавляемого объекта
     */
    void add(int val, int ind) {
        if (ind >= size) {
            ind = size;
            add(val);
            return;
        }

        size++;
        int[] help_list = new int[size];
        for (int i = 0, j = 0; i < size; i++, j++) {
            if (i != ind)
                help_list[i] = list[j];
            else {
                help_list[i] = val;
                i++;
            }
        }
        help_list[size - 1] = val;
        list = help_list;
    }

    /**
     * <p>Метод удаления объекта по индексу "ind" </p>
     *
     * @param index - позиция удаляемого объекта
     * @return Возращает удаляемый объект или null в случае отстуствие данного индекса или элемента на данной позиции
     */
    int remove(int index) {

        if (index > size || index < 0)
            return -1;

        int[] upd_list = new int[size - 1];
        int j = 0;
        int res = list[index];
        for (int i = 0; i < size; i++) {
            if (i == index)
                continue;
            upd_list[j] = list[i];
            j++;
        }
        list = new int[size--];
        list = upd_list;
        return res;
    }

    int get(int index) {
        if (index > size || index < 0)
            return -1;
        else return list[index];
    }

    boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (list[i] == value)
                return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (size < 1)
            return false;
        return true;
    }

    int Size() {
        return size;
    }

    int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (list[i] == value)
                return i;
        }
        return -1;
    }

    void set(int value, int index) {
        if (index < 0)
            list[0] = value;
        list[index] = value;
    }

    /**
     * <p>Объеденения двух отсортированных списков в один новый</p>
     *
     * @param head - спиок для объеденения с текущим
     * @return Возвращает список после слияния двух исходных
     */
    public List merge(List head) {
        int allsize = size + head.size;
        List help = new List();

        int help1 = 0, help2 = 0;

        for (int i = 0; i < allsize; i++) {
            if (help2 >= head.size) {
                help.add(list[help1]);
                help1++;
                continue;
            }
            if (help1 >= size) {
                help.add(head.get(help2));
                help2++;
                continue;
            }
            if (list[help1] >= head.get(help2   )) {
                help.add(head.get(help2));
                help2++;
            } else {
                help.add(list[help1]);
                help1++;
            }
        }
        return help;
    }
}



