package test;

import dao.dao;
import model.classroom;
import model.student;
import utils.getId;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        getId g=new getId();


        //获得已有的班级编号和学号
        g.getStudentId();
        g.getClassId();

        while(true) {
            System.out.println("----------请选择你的操作--------------");
            System.out.println("1、查询所有学生信息");
            System.out.println("2、根据学号查找学生信息");
            System.out.println("3、增加学生信息");
            System.out.println("4、删除学生信息");
            System.out.println("5、修改学生成绩");
            System.out.println("6、根据班级编号查询班级信息");
            System.out.println("7、增加班级信息");
            System.out.println("8、修改班级信息");
            System.out.println("9、查询已有的学号和班级编号");
            System.out.println("10、 退出");
            Scanner sc=new Scanner(System.in);
            int a = sc.nextInt();
            sc.nextLine();
            //查询所有学生信息
            if(a == 1) {
                dao.getAllStudent();
            }
            //根据学号查找学生信息
            else if (a == 2) {

                System.out.println("请输入你要查询的学号");
                g.getStudentId();
                int n = sc.nextInt();
                sc.nextLine();

                dao.getStudent(n);
            }
            //增加学生信息
            else if (a == 3) {
                student s = new student();
                g.getStudentId();
                g.getClassId();
                System.out.println("测试数据\n 2222006 lilei 1001 女 12345678901 2022-9-1");
                System.out.println("请输入要添加的学号");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("请输入学生姓名");
                String name = sc.nextLine();
                System.out.println("请输入学生班级编号");
                int cid = sc.nextInt();
                sc.nextLine();
                System.out.println("请输入学生性别（男/女）");
                String sex = sc.nextLine();
                System.out.println("请输入学生电话号码");
                String phone = sc.nextLine();
                System.out.println("请输入学生进入班级的时间 YYYY-MM-DD ");
                String enterTime = sc.nextLine();

                s.setStudentId(id);
                s.setClassId(cid);
                s.setName(name);
                s.setSex(sex);
                s.setPhone(phone);
                s.setEnterTime(enterTime);

                dao.insertStudent(s);
            }
            //删除学生信息
            else if (a == 4) {
                //获取已有学号
                g.getStudentId();
                System.out.println("请输入删除学生的id");
                int id = sc.nextInt();
                sc.nextLine();

                dao.deleteStudent(id);

            }
            //删除学生信息
            else if (a == 5){
                g.getStudentId();
                System.out.println("请输入你要修改的学生学号");
                int studentId = sc.nextInt();


                System.out.println("你要把姓名修改为");
                String name = sc.nextLine();
                sc.nextLine();

                System.out.println("你要把性别修改为（男/女）");
                String sex = sc.nextLine();


                System.out.println("你要把电话号码修改为");
                String phone = sc.nextLine();


                System.out.println("你要把班级编号修改为");
                g.getClassId();
                int ClassId = sc.nextInt();

                dao.updateStudent(studentId,name,sex,phone,ClassId);
                System.out.println("修改成功");
            }
            //根据班级编号查询班级信息
            else if (a == 6) {
                g.getClassId();
                System.out.println("请输入你要查询的班级编号");
                int n = sc.nextInt();
                sc.nextLine();

                dao.getClass(n);
            }
            //增加班级信息
            else if (a == 7) {
                classroom cl=new classroom();
                g.getClassId();
                System.out.println("请输入你要增加的课班编号");
                int cId = sc.nextInt();
                sc.nextLine();

                System.out.println("请输入你要增加的班级的名称");
                String className = sc.nextLine();

                cl.setClassId(cId);
                cl.setClassName(className);

                dao.insertClass(cl);

            }
            //修改班级信息
            else if (a == 8) {
                System.out.println("请输入你要修改的班级编号");
                g.getClassId();
                int id  = sc.nextInt();
                sc.nextLine();
                System.out.println("你要把班级名称修改为");
                String cName=sc.nextLine();

                dao.updateClassroom(id,cName);

            }
            //查询已有的学号和班级编号
            else if (a == 9) {
                g.getStudentId();
                g.getClassId();
            }

            else if (a == 10) {
                break;
            }
            else {
                System.out.println("请输入正确的选项！");
            }


        }


    }
}