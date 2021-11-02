package pojo;

import java.util.Date;

public class Student {
    private String name;
    private String group;
    private Date enrolled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Date enrolled) {
        this.enrolled = enrolled;
    }
}
