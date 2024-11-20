package demo.controller.nhlobject;

import java.util.List;

public class TeamsObject {

   private Integer id;
   private List<FullNamesObject> fullNames;

    public List<FullNamesObject> getFullNames() {
        return fullNames;
    }

    public void setFullNames(List<FullNamesObject> fullNames) {
        this.fullNames = fullNames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
