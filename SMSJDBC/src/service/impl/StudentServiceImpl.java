package service.impl;
import dao.StudentDao;
import dao.pojo.Student;
import service.StudentService;
import dao.BaseDao;
import java.sql.SQLException;
import java.util.List;
public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDao();

    @Override
    public Boolean addStudent(Student student) {
        return studentDao.addStudent(student) > 0;
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.deleteStudent(id) > 0;
    }


    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student) > 0;
    }


    @Override
    public List<Student> getStudent(int id) throws SQLException {
        try {
            return BaseDao.resultData(studentDao.getStudent(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAllStudent() {
        try {
            return BaseDao.resultData(studentDao.getAllStudent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}