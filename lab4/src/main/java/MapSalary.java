import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapSalary {
    private Map<String, Integer> salary;

    /*Constructors*/
    MapSalary(){
        this.salary = new LinkedHashMap<>();
    }


    /*Methods*/
    public MapSalary(List<Employee> e) {
        this.salary = new LinkedHashMap<>();
        for (Employee employee : e) {
            salary.put(employee.getGivenName(), 0);
        }
    }

    public Map<String, Integer> getSalary() {
        return this.salary;
    }

    public void addSalary(Employee employee, int s) {
        String GivenName = employee.getGivenName();
        if (this.salary.containsKey(GivenName))
            this.salary.put(GivenName, s);
    }

    public void addEmployee(Employee employee){
        this.salary.put(employee.getGivenName(), 0);
    }
}
