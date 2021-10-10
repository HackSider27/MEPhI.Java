public class Map {
    public static class Node {
        public Object key;
        public Object value;

        Node() {
            key = null;
            value = null;
        }

        Node(Object k, Object val) {
            value = val;
            key = k;
        }
    }

    private int size;
    private Node[] list;

    Map() {
        size = 0;
    }

    Map(Node a) {
        size = 1;
        list = new Node[1];
        list[0] = a;
    }

    Map(int s, Node... nodes) {
        size = s;
        list = nodes;
    }

    public void put(Object k, Object val) {
        for (int i = 0; i < size; i++) {
            if (list[i].key == k) {
                list[i].value = val;
                return;
            }
        }
        Node[] newList = new Node[++size];

        for (int i = 0; i < size - 1; i++)
            newList[i] = list[i];

        Node new_node = new Node(k, val);
        newList[size - 1] = new_node;
        list = new Node[size];
        list = newList;
    }

    public Object get(Object k) {
        int i = 0;
        while (i < size) {
            if (list[i].key == k)
                return list[i].value;
            i++;
        }
        return null;
    }

    public Object get(Object k, Object bydefault) {
        for (int i = 0; i < size; i++) {
            if (list[i].key == k) {
                if (list[i].value != null)
                    return list[i].value;
                else return bydefault;
            }
        }
        return null;
    }

    public Object remove(Object k) {
        Object val = null;
        for (int i = 0; i < size; i++) {
            if (list[i].key == k) {
                val = list[i].value;
                break;
            }
        }
        if (val != null) {
            Node[] upd_array = new Node[size - 1];
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (list[i].key == k)
                    continue;
                upd_array[j] = list[i];
                j++;
            }
            list = new Node[size--];
            list = upd_array;
            return val;
        }
        return val;
    }

    public boolean keyContains(Object k) {
        for (int i = 0; i < size; i++) {
            if (list[i].key == k)
                return true;
        }
        return false;
    }

    public List getKeys() {
        List l = new List();
        for (int i = 0; i < size; i++) {
            l.add(list[i].key);
        }
        return l;
    }

    public List getValues() {
        List l = new List();
        for (int i = 0; i < size; i++) {
            l.add(list[i].value);
        }
        return l;
    }

    public List getEntries() {
        List l = new List();
        for (int i = 0; i < size; i++) {
            l.add(list[i]);
        }
        return l;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size > 0)
            return false;
        else return true;
    }
}
