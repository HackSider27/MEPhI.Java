import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Collectors;

public class SomeGoodMethods4 {
    /**
     * Sum of full list ages
     *
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String SumAges(List<Employee> e) {
        return "The sum of list`s ages is: " + e.stream().mapToInt(Employee::getAge).sum() + "\n";
    }

    /**
     * Average value of full list ages
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String AveAges(List<Employee> e) {
        return "The average of all employees` ages is: " + e.stream().mapToInt(Employee::getAge).average() + "\n";
    }

    /**
     * Average value of full list salary
     *
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String AveSalary(List<Employee> e) {
        return "The average of all employees` salaries is: "
                + e.stream().mapToInt(Employee::getSalary).average().getAsDouble() + "\n";
    }

    /**
     * Min and max of lists` ages
     *
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String MinAndMaxAges(List<Employee> e) {
        return "Min Ages are: " + e.stream().mapToInt(Employee::getAge).min().getAsInt() + "\n" +
                "Max Ages are: " + e.stream().mapToInt(Employee::getAge).max().getAsInt() + "\n";
    }

    /**
     * Min and max of lists` department
     */
    public static String MinAndMaxDept(List<Employee> e) {
        return "Min dept are: " + e.stream().mapToInt(Employee::getDept).min().getAsInt() + "\n" +
                "Max dept are: " + e.stream().mapToInt(Employee::getDept).max().getAsInt() + "\n";
    }

    public static void AllAges(List<Employee> e) {
        Consumer<Employee> printEmployee =
                empl -> System.out.print(empl.getGivenName() + " " + empl.getSurName() + ":  ");

        System.out.println("List of a employees` ages: ");
        e.stream().peek(printEmployee).map(Employee::getAge).forEach(System.out::println);
    }

    public static void Name_and_SurName(List<Employee> e) {
        List<String> Names = e.stream().map(Employee::getGivenName).collect(Collectors.toList());
        List<String> SurNames = e.stream().map(Employee::getSurName).collect(Collectors.toList());
        for (int i = 0; i < Names.size(); i++) {
            System.out.println(Names.get(i) + " " + SurNames.get(i));
        }
        System.out.println();
    }

    public static void SumSalary(List<Employee> e) {
        AtomicInteger sumSalary = new AtomicInteger();
        AtomicInteger Employees = new AtomicInteger();

        MapSalary s = new MapSalary(e);

        for (Employee employee : e) {
            s.addSalary(employee, employee.getSalary());
        }

        System.out.println("List of salary up to 120:");
        s.getSalary().values().stream()
                .peek(i -> sumSalary.addAndGet(i)) //+=
                .filter(i -> i > 120)
                .peek(i -> Employees.addAndGet(1)) //+=
                .forEach(System.out::println);


        System.out.println("\nSalary of composition of employees (by peek): " + sumSalary
                + "\nAnd number of employees: " + Employees);

        System.out.println("Salary of composition of employees (by sum): "
                + e.stream().mapToInt(Employee::getSalary).sum());
    }

    public static void firstExecutive(List<Employee> e) {
        System.out.println("The first employee as Executive:");
        System.out.println(e.stream()
                .filter(i -> i.getRole() == Role.EXECUTIVE)
                .findFirst()
                .get());
    }

    public static void firstSalaryUp100(List<Employee> e) {
        System.out.println("The first employee`s salary up to 100:");
        System.out.println(e.stream()
                .filter(i -> i.getSalary() > 100)
                .findFirst()
                .get());
    }

    public static void lab4(){
        List<Employee> employeeList = Employee.createShortList();

        Name_and_SurName(employeeList);

        System.out.println(SumAges(employeeList));
        System.out.println(AveSalary(employeeList));
        System.out.println(MinAndMaxAges(employeeList));
        System.out.println(MinAndMaxDept(employeeList));

        AllAges(employeeList);
        System.out.println();

        SumSalary(employeeList);
        System.out.println();

        firstExecutive(employeeList);
        System.out.println();

        firstSalaryUp100(employeeList);
        System.out.println();
    }
}
