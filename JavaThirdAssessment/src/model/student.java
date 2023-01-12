package model;

import java.util.Date;

public class student {
    private int studentId;
    private String name;
    private String sex;
    private String phone;
    private int classId;

    private String enterTime;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    @Override
    public String toString() {
        return "student{" +
                "学号=" + studentId +
                ", 姓名='" + name + '\'' +
                ", 性别='" + sex + '\'' +
                ", 电话号码='" + phone + '\'' +
                ", 班级编号=" + classId +
                ", 进入班级的时间='" + enterTime + '\'' +
                '}';
    }
}
