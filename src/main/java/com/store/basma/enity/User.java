package com.store.basma.enity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {


    private static final long serialVersionUID = -6949828312801015558L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String userId;
    @Column(nullable = false,name = "first_name")
    private String firstName;
    @Column(nullable = false,name = "last_name")
    private String lastName;
    @Column(nullable = false,name = "email")
    private String email;
    @Column(nullable = false,name = "encrypted_password")
    private String encryptedPassword;
    @Column(nullable = false,name = "username")
    private String username;
    @Column(nullable = false,name = "enable")
    private Boolean enable;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String firstName, String lastName, String email, String encryptedPassword, String username, Boolean enable) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.username = username;
        this.enable = enable;

    }
}