package org.lightvanko.dvdstore.data;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy="user")
    List<TakenItem> takenItem = new ArrayList<>();

    @OneToMany(mappedBy="user")
    List<Disk> disks = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
