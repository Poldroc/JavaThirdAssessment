package model;

import java.util.List;

public class classroom {
    private int classId;
    private String className;

    //保证两表关系
    private List<student> studentList;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "classroom{" +
                "班级编号=" + classId +
                ", 班级名字='" + className + '\'' +
                '}';
    }



    public List<student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<student> studentList) {
        this.studentList = studentList;
    }

}
