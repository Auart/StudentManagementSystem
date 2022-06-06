package service.impl;

import dao.StudentDao;
import dao.pojo.Student;
import service.StudentService;
import dao.BaseDao;
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
    public List<Student> getStudent(int id) {
        return BaseDao.resultData(studentDao.getStudent(id));
    }

    @Override
    public List<Student> getAllStudent() {
        return BaseDao.resultData(studentDao.getAllStudent());
    }
}