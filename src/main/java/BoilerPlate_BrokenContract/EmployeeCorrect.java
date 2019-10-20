package BoilerPlate_BrokenContract;

import java.util.Objects;

public class EmployeeCorrect {
    private String name;
    private Integer age;

    public EmployeeCorrect(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeCorrect)) return false;
        EmployeeCorrect that = (EmployeeCorrect) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "EmployeeCorrect{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}