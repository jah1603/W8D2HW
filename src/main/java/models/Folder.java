package models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ships")
public class Folder {

    private int id;
    private String title;
    private List<File> files;

    public Folder() {
    }

    public Folder(String title) {
        this.title = title;
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

    public void setCrew(List<File> files) {
        this.files = files;
    }
}
