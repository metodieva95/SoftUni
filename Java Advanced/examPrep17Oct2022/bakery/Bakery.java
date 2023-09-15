package examPrep17Oct2022.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery (String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add (Employee employee) {
        if (employees.size() < capacity) {
        employees.add(employee);
        }
    }

    public boolean remove(String name) {
       Employee employeeToRemove = getEmployee(name);

       if (employeeToRemove != null) {
           employees.remove(employeeToRemove);
           return true;
       }
       return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max((f, s) -> f.getAge() - s.getAge()).orElse(null);
    }

    public Employee getEmployee(String name) {

     return employees.stream()
             .filter(e -> e.getName().equals(name))
             .findAny()
             .orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Employees working at Bakery ")
                .append(getName())
                .append(":");

        for (Employee employee : employees) {
            sb.append(System.lineSeparator());
            sb.append(employee.toString());
        }

        return sb.toString();
    }

}
