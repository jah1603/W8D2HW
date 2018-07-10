package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    private int id;
    private String title;
    private List<File> files;
    private Owner owner;

    public Folder() {
    }

    public Folder(String title, Owner owner) {
        this.title = title;
        this.owner = owner;
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

    @Column(name = "title")
    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }


    @OneToMany(mappedBy = "folder", fetch = FetchType.LAZY)
    public List<File> getFiles(){
        return this.files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    public Owner getOwner(){
        return this.owner;
    }

    public void setOwner(Owner owner){
        this.owner = owner;
    }
}
