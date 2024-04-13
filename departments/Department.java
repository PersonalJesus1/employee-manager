package Lessons.Employee_manager;
import java.io.Serializable;

public enum Department implements Serializable {

    MARKETING("Marketing") {},
    HR("Human Resources") {},
    DEVELOPMENT("Development") {};
    private String title;

    Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
