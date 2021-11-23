public class OutOfMemoryErrorEx {
    public void OutOfMemoryErrorEx(){
        StringBuilder str = new StringBuilder();
        while (true)
            str.append("oops");
    }
}
