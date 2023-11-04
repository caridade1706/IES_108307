package ua.deti.ies.SpringBoot;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "tbl_user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone is mandatory")
    private String phone;

    public User(String email, String name, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" +"]";
    }

    

    // standard constructors / setters / getters / toString
}