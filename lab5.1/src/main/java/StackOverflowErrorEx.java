public class StackOverflowErrorEx {
    public int StackOverflowErrorEx(int number) {
            return number * StackOverflowErrorEx(number - 1);
    }
}
