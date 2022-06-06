package service;
import dao.pojo.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    public Boolean addStudent(Student student);
    public boolean deleteStudent(int id);

    public boolean updateStudent(Student student);
    public List<Student> getStudent(int id) ;

    public List<Student> getAllStudent() ;
}

