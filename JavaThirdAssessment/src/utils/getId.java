package utils;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class getId {

    //获得已有学号
    public void getStudentId(){
        Connection connection=null;
        Statement st=null;
        ResultSet result = null;

        try {
            connection=JdbcUtils.getConnection();
            String sql="SELECT student_id FROM student ORDER BY student_id ASC";

            st = connection.createStatement();

            result = st.executeQuery(sql);

            System.out.println("-----------已存在的学号有----------");
            while(result.next()){
                System.out.println(result.getInt("student_id"));
            }
            System.out.println("----------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,st,result);
        }
    }


    //获得已有班级编号
    public void getClassId(){
        Connection connection=null;
        Statement st=null;
        ResultSet result = null;

        try {
            connection=JdbcUtils.getConnection();
            String sql="SELECT * FROM class ORDER BY class_id ASC";

            st = connection.createStatement();

            result = st.executeQuery(sql);

            System.out.println("-----------已存在的班级有----------");
            while(result.next()){
                System.out.println(result.getInt("class_id")+result.getString("class_name"));
            }
            System.out.println("----------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(connection,st,result);
        }
    }
}
