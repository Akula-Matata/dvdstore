package org.lightvanko.dvdstore.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TAKEN_ITEMS")
public class TakenItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name="DISK_ID")
    private Disk disk;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public TakenItem() {
    }

    public TakenItem(User user, Disk disk) {
        this.user = user;
        this.disk = disk;
    }
}
