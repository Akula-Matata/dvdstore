package org.lightvanko.dvdstore.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISKS")
public class Disk {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String capture;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @OneToMany(mappedBy="disk")
    List<TakenItem> takenItem = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCapture() {
        return capture;
    }

    public void setCapture(String capture) {
        this.capture = capture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TakenItem> getTakenItem() {
        return takenItem;
    }

    public void setTakenItem(List<TakenItem> takenItem) {
        this.takenItem = takenItem;
    }

    public Disk() {
    }

    public Disk(String capture, User user) {
        this.capture = capture;
        this.user = user;
    }
}
