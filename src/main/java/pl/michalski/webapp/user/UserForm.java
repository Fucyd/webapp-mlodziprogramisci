package pl.michalski.webapp.user;

import com.sun.istack.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {
    @NotEmpty(message = "To pole nie może być puste.")
    private String name;
    @NotEmpty(message = "To pole nie może być puste.")
    private String lastName;
    @NotEmpty(message = "To pole nie może być puste.")
    private String email;
    @NotEmpty(message = "To pole nie może być puste.")
    @Size(min = 6, max = 14, message = "Wpisz od 6 do 14 znaków")
    private String password;
    @NotEmpty(message = "To pole nie może być puste.")
    @Size(min = 6, max = 14, message = "Wpisz od 6 do 14 znaków")
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
