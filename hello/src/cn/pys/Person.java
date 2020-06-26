package cn.pys;

import java.util.Objects;

public class Person {

    private Integer age;

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        //Objects.hash(age, name);
        int hashCode = Integer.hashCode(age);
        hashCode = hashCode * 31 + (name == null ? 0 : name.hashCode());
        return hashCode;
    }
}
