package pl.janusz.buchalka.dsa.pt04;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class Employee {

    private String firstName;
    private String lastName;
    private int id;

    public Employee() {

        this(null, null, 0);
    }

    public Employee(String firstName, String lastName, int id) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getId() != employee.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        return getLastName() != null ? getLastName().equals(employee.getLastName()) : employee.getLastName() == null;
    }

    @Override
    public int hashCode() {

        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + getId();
        return result;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
