import java.util.function.*;

public interface BiPredicate<Employee, S>  {
    boolean test(Employee employee, S s);
}

