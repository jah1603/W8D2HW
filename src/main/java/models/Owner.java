package models;

import models.File;
import models.Folder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    private int id;
    private String name;
    private String username;
    private List<Folder> folders;

    public Owner() {
    }

    public Owner(String name, String username) {
        this.name = name;
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    public List<Folder> getFiles(){
        return this.folders;
    }

    public void setCrew(List<Folder> folders) {
        this.folders = folders;
    }
}

