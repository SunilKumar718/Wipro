package springboot_7;

import jakarta.validation.constraints.*;
import java.util.List;

public class Student {

    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 30)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 30)
    private String lastName;

    @NotBlank(message =  "Gender is required")
    private String gender;

    @NotBlank(message ="Date of birth is required")
    private String dob;

    @NotBlank(message ="Email is required")
    @Email(message =  "Invalid email format")
    private String email;

    @NotBlank(message =  "Section is required")
    private String section;

    @NotBlank(message =  "Country is required")
    private String country;

    @NotEmpty(message = "At least one subject must be selected")
    private List<String> subjects;


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

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
