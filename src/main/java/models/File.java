package models;

import javax.persistence.*;

@Entity
@Table(name="files")
public class File {

    private int id;
    private String name;
    private String extension;
    private int sizeInKilobytes;
    private Folder folder;


    public File() {
    }

    public File(String name, String extension, int sizeInKilobytes, Folder folder) {
        this.name = name;
        this.extension = extension;
        this.sizeInKilobytes = sizeInKilobytes;
        this.folder = folder;
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

    @Column(name = "extension")
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Column(name = "size_in_KB")
    public int getSizeInKilobytes() {
        return sizeInKilobytes;
    }

    public void setSizeInKilobytes(int sizeInKilobytes) {
        this.sizeInKilobytes = sizeInKilobytes;
    }


    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    public Folder getFolder(){
        return this.folder;
    }

    public void setFolder(Folder folder){
        this.folder = folder;
    }
    }
