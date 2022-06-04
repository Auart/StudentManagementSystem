package dao;

import dao.pojo.Student;
import java.sql.ResultSet;
public class StudentDao extends BaseDao {
    public int addStudent(Student student) {
        return executeAddSQL("insert into student (id,name,sex,age,native_place,department,major,phone) values (0,?,?,?,?,?,?,?);", student);
    }

    public int deleteStudent(int id) {
        return executeUpdateSQL("delete from student where id=?;", id);
    }

    public int updateStudent(Student student) {
        return executeUpdateSQL("replace into student values(?,?,?,?,?,?,?,?);", student);
    }

    public ResultSet getStudent(int id) {
        return executeQuerySQL("select * from student where id=?;", id);
    }

    public ResultSet getAllStudent() {
        return executeQuerySQL("select * from student;");
    }
}
