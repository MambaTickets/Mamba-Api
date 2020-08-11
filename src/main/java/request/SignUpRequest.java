package request;

import java.util.Date;

public class SignUpRequest {
    private String Email;
    private String FirstName;
    private String LastName;
    private String Phone;
    private Date BirthDate;
    private String TaxId;
    private String Password;
    private String ConfirmPassword;

    public SignUpRequest() {
    }

    public SignUpRequest(
            String email,
            String firstName,
            String lastName,
            String phone,
            Date birthDate,
            String taxId,
            String password,
            String confirmPassword) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        BirthDate = birthDate;
        TaxId = taxId;
        Password = password;
        ConfirmPassword = confirmPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getTaxId() {
        return TaxId;
    }

    public void setTaxId(String taxId) {
        TaxId = taxId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
