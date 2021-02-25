package pl.michalski.webapp.school;

import javax.validation.constraints.NotNull;

public class SchoolForm {
    @NotNull(message = "pole nie może być puste")
    private String name;
    @NotNull(message = "pole nie może być puste")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
