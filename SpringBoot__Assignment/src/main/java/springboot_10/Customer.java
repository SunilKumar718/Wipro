package springboot_10;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {

    @NotBlank(message = "{customer.name.required}")
    @Size(min = 2, max = 30, message = "{customer.name.size}")
    private String name;

    @NotBlank(message = "{customer.email.required}")
    @Email(message = "{customer.email.valid}")
    private String email;

    @NotBlank(message = "{customer.gender.required}")
    private String gender;

    @NotNull(message = "{customer.age.required}")
    @Min(value = 18, message = "{customer.age.min}")
    @Max(value = 100, message = "{customer.age.max}")
    private Integer age;

    @NotNull(message = "{customer.dob.required}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "{customer.phone.required}")
    @Pattern(regexp = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\d{10},\\d{4})$", message = "{customer.phone.valid}")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
