package pl.michalski.webapp.student;

public class StudentForm {
    private String name;
    private String lastName;
    private Integer age;
    private Double gradesAverage;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getGradesAverage() {
        return gradesAverage;
    }

    public void setGradesAverage(Double gradesAverage) {
        this.gradesAverage = gradesAverage;
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
}
