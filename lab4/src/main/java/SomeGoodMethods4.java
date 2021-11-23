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
    public static String sumAges(List<Employee> e) {
        return "The sum of list`s ages is: " + e.stream().mapToInt(Employee::getAge).sum() + "\n";
    }

    /**
     * Average value of full list ages
     *
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String aveAges(List<Employee> e) {
        return "The average of all employees` ages is: " + e.stream().mapToInt(Employee::getAge).average() + "\n";
    }

    /**
     * Average value of full list salary
     *
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String aveSalary(List<Employee> e) {
        return "The average of all employees` salaries is: "
                + e.stream().mapToInt(Employee::getSalary).average().getAsDouble() + "\n";
    }

    /**
     * Min and max of lists` ages
     *
     * @param e - list of a type like "List<Employee>"
     * @return string of a result
     */
    public static String minAndMaxAges(List<Employee> e) {
        return "Min Ages are: " + e.stream().mapToInt(Employee::getAge).min().getAsInt() + "\n" +
                "Max Ages are: " + e.stream().mapToInt(Employee::getAge).max().getAsInt() + "\n";
    }

    /**
     * Min and max of lists` department
     */
    public static String minAndMaxDept(List<Employee> e) {
        return "Min dept are: " + e.stream().mapToInt(Employee::getDept).min().getAsInt() + "\n" +
                "Max dept are: " + e.stream().mapToInt(Employee::getDept).max().getAsInt() + "\n";
    }

    public static void allAges(List<Employee> e) {
        if(e.equals(null))

        Consumer<Employee> printEmployee =
                empl -> System.out.print(empl.getGivenName() + " " + empl.getSurName() + ":  ");

        System.out.println("List of a employees` ages: ");
        e.stream()
                .peek(printEmployee)
                .map(Employee::getAge)
                .forEach(System.out::println);
    }

    public static void name_and_SurName(List<Employee> e) {
        List<String> Names = e.stream().map(Employee::getGivenName).collect(Collectors.toList());
        List<String> SurNames = e.stream().map(Employee::getSurName).collect(Collectors.toList());
        for (int i = 0; i < Names.size(); i++) {
            System.out.println(Names.get(i) + " " + SurNames.get(i));
        }
        System.out.println();
    }

    public static void sumSalary(List<Employee> e) {
        AtomicInteger sumSalary = new AtomicInteger();
        AtomicInteger Employees = new AtomicInteger();

        MapSalary s = new MapSalary(e);

        for (Employee employee : e) {
            s.addSalary(employee, employee.getSalary());
        }

        System.out.println("List of salary up to 120:");
        e.stream()
                .peek(i -> System.out.println("Salary: " + i.getSalary() + "\n"))
                .filter(i -> i.getSalary() > 120)
                .forEach(System.out::println);


        System.out.println("n\nAnd number of employees: " +
                e.stream()
                        .filter(i -> i.getSalary() > 120)
                        .count());

        System.out.println("Salary of composition of employees (by sum): "
                + e.stream().mapToInt(Employee::getSalary).sum());
    }

    public static void firstExecutive(List<Employee> e) {
        System.out.println("The first employee as Executive:");
        System.out.println(e.stream()
                .filter(i -> i.getRole() == Role.EXECUTIVE)
                .findFirst()
                .orElse(null));
    }

    public static void firstSalaryUp100(List<Employee> e) {
        System.out.println("The first employee`s salary up to 100:");
        System.out.println(e.stream()
                .filter(i -> i.getSalary() >= 100)
                .findFirst()
                .orElse(null));
    }

    public static void lab4() {
        List<Employee> employeeList = Employee.createShortList();

        name_and_SurName(employeeList);

        System.out.println(sumAges(employeeList));
        System.out.println(aveAges(employeeList));
        System.out.println(minAndMaxDept(employeeList));
        System.out.println(minAndMaxDept(employeeList));

        allAges(employeeList);
        System.out.println();

        sumSalary(employeeList);
        System.out.println();

        firstExecutive(employeeList);
        System.out.println();

        firstSalaryUp100(employeeList);
        System.out.println();
    }
}
