package dao;
import model.classroom;
import model.student;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dao {

    //通过学号查询单个学生
    public static void getStudent(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet result = null;
        List<student> list  = new ArrayList<student>();
        try {

            connection = JdbcUtils.getConnection();
            //使用?占位符代替参数
            String sql ="SELECT * FROM student WHERE student_id=?";
            //预编译SQL，先写SQL，然后不执行
            ps = connection.prepareStatement(sql);
            //手动给参数赋值
            ps.setInt(1,id);

            result = ps.executeQuery();

            while(result.next()) {
                student s = new student();
                s.setStudentId((result.getInt("student_id")));
                s.setName(result.getString("name"));
                s.setSex(result.getString("sex"));
                s.setPhone(result.getString("phone"));
                s.setClassId(result.getInt("class_id"));
                s.setEnterTime(result.getString("enter_time"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,ps,result);
        }
        for (student student : list) {
            System.out.println(student);
        }

    }


    //查询全部学生信息
    public static void getAllStudent() {
        Connection connection=null;
        Statement st=null;
        ResultSet result = null;
        List<student> list  = new ArrayList<student>();
        try {
            connection=JdbcUtils.getConnection();
            String sql="SELECT * FROM student ORDER BY student_id ASC";

            st = connection.createStatement();

            result = st.executeQuery(sql);
            while(result.next()){
                student s=new student();
                s.setStudentId((result.getInt("student_id")));
                s.setName(result.getString("name"));
                s.setSex(result.getString("sex"));
                s.setPhone(result.getString("phone"));
                s.setClassId(result.getInt("class_id"));
                s.setEnterTime(result.getString("enter_time"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,st,result);
        }
        for (student student : list) {
            System.out.println(student);
        }

    }

    // 增加学生
    public static void insertStudent (student s) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            connection=JdbcUtils.getConnection();
            // ? 占位符 后面赋值
            String sql="INSERT INTO student VALUES(?,?,?,?,?,?)";
            ps= connection.prepareStatement(sql);
            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getSex());
            ps.setString(4,s.getPhone());
            ps.setInt(5, s.getClassId());
            ps.setString(6,s.getEnterTime());
            // 增加
            ps.executeUpdate();
            System.out.println("添加成功！");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection,ps,rs);
        }
    }
    //根据学号删除学生
    public static void deleteStudent(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;

        try {
            connection=JdbcUtils.getConnection();
            String sql="DELETE FROM student WHERE student_id=?";
            ps= connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,ps,rs);
        }

    }


    //根据学号修改学生信息(名字，性别，电话，班级编号)
    public static void updateStudent(int studentId,String name,String sex,String phone,int classId) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;

        try {
            connection=JdbcUtils.getConnection();
            String sql = "UPDATE student SET name=?,sex=?,phone=?,class_id=? WHERE student_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, phone);
            ps.setInt(4, classId);
            ps.setInt(5, studentId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,ps,rs);
        }
    }
    //按班级编号查询班级信息
    public static void getClass(int cid) {
        classroom cl=new classroom();

        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet result = null;
        List<student> students = new ArrayList<student>();

        try {
            connection=JdbcUtils.getConnection();
            //String sql="SELECT s.class_id,class_name,student_id,`name`,sex,phone,enter_time FROM student s INNER JOIN  class c ON s.class_id = c.class_id ORDER BY s.class_id ASC;";
            String sql="SELECT * FROM student s,class c WHERE s.class_id = c.class_id AND s.class_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,cid);
            result = ps.executeQuery();
            while(result.next()){
                //分别存储信息
                //存储班级信息
                cl.setClassId(result.getInt("class_id"));
                cl.setClassName(result.getString("class_name"));
                //存储学生信息
                student s=new student();
                s.setClassId(result.getInt("class_id"));
                s.setStudentId(result.getInt("student_id"));
                s.setName(result.getString("name"));
                s.setSex(result.getString("sex"));
                s.setPhone(result.getString("phone"));
                s.setEnterTime(result.getString("enter_time"));

                //将同一班的学生放在一个集合中
                students.add(s);
            }
            //将学生集合与班级关联
            //cl.setStudentList(students);

            //输出班级信息
            System.out.println(cl);

            //输出学生信息
            for (student s : students){
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,ps,result);
        }
    }
    // 增加班级
    public static void insertClass (classroom cl ) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            connection=JdbcUtils.getConnection();
            // ? 占位符 后面赋值
            String sql="INSERT INTO class VALUES(?,?)";
            ps= connection.prepareStatement(sql);
            ps.setInt(1, cl.getClassId());
            ps.setString(2, cl.getClassName());

            // 增加
            ps.executeUpdate();
            System.out.println("添加成功！");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection,ps,rs);
        }
    }

    // 根据班级编号修改班级名字
    public static void updateClassroom(int classId,String className) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;

        try {
            connection=JdbcUtils.getConnection();
            String sql = "UPDATE class SET class_name=? WHERE class_id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, className);
            ps.setInt(2, classId);

            ps.executeUpdate();
            System.out.println("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,ps,rs);
        }
    }



}
