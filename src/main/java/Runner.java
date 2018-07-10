import db.DBHelper;

import java.util.List;

import models.File;
import models.Folder;
import models.Owner;

public class Runner {

    public static void main(String[] args) {

        Owner james = new Owner("James Henderson", "jah1603");
        DBHelper.save(james);

        Folder UniversityWork = new Folder("University work", james);
        DBHelper.save(UniversityWork);

        Folder ResearchProject = new Folder("NHS research project", james);
        DBHelper.save(ResearchProject);

        File file1 = new File("Dissertation final submission", ".doc", 256, UniversityWork);
        DBHelper.save(file1);

        File file2 = new File("Supervisor meeting notes", ".doc", 120, UniversityWork);
        DBHelper.save(file2);

        File file3 = new File("Statistical modelling plan", ".doc", 512, ResearchProject);
        DBHelper.save(file3);



        List<File> files = DBHelper.getAll(File.class);

        File dissertation = DBHelper.find(File.class, file1.getId());

        file2.setName("Final supervisor meeting notes");
        DBHelper.update(file2);

        UniversityWork.setName("University dissertation work");
        DBHelper.update(UniversityWork);

        DBHelper.delete(file3);

        List<File> newList = DBHelper.getAll(File.class);

        Folder foundFolder = DBHelper.find(Folder.class, UniversityWork.getId());

    }
}
