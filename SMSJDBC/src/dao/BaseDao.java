package dao;

import dao.pojo.Student;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * JDBC工具类
 */
public abstract class BaseDao {
    private static String url;
    private static String user;
    private static String password;

    /*
     * 文件读取，只会执行一次，使用静态代码块
     */
    static {
        //读取文件，获取值
        try {
            //1.创建Properties集合类
            Properties pro = new Properties();
            //获取src路径下的文件--->ClassLoader类加载器
            ClassLoader classLoader = BaseDao.class.getClassLoader();
            URL resource = classLoader.getResource("resource/jdbc.properties");
            assert resource != null;
            String path = resource.getPath();
            //2.加载文件
            pro.load(new FileReader(path));
            //3获取数据
            url = pro.getProperty("url");
            user = pro.getProperty("username");
            password = pro.getProperty("password");
            String driver = pro.getProperty("driverClassName");
            //4.注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //执行SQL


    public static int executeAddSQL(String sql, Student student) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameterOfAdd(pstmt, student);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int executeUpdateSQL(String sql, Student student) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            setParameterOfUpdate(pstmt, student);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int executeUpdateSQL(String sql, String param) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setString(1, param);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int executeUpdateSQL(String sql, Object param) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setObject(1, param);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int executeUpdateSQL(String sql, int param) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setInt(1, param);
            return pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQl执行失败");
        }
        return 0;
    }

    public static void setParameterOfAdd(PreparedStatement pstmt, Student student) {
        Field[] fields = student.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                pstmt.setObject(i, fields[i].get(student));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void setParameterOfUpdate(PreparedStatement pstmt, Student student) {
        Field[] fields = Student.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                pstmt.setObject(i + 1, fields[i].get(student));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet executeQuerySQL(String sql) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet executeQuerySQL(String sql, Object param) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            pstmt.setObject(1, param);
            return pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //将JDBC结果集对象封装为List集合
    public static List<Student> resultData(ResultSet rs) throws Exception {
        List<Student> studentList = new ArrayList<>();
        Field[] fields = Student.class.getDeclaredFields();
        while (rs.next()) {
            Student student = new Student();
            for (int i = 0; i < fields.length; i++) {
                Field field = Student.class.getDeclaredField(fields[i].getName());
                field.setAccessible(true);
                if (field.getGenericType().toString().equals("class java.lang.Integer")) {
                    field.set(student, Integer.parseInt(String.valueOf(rs.getObject(i + 1))));
                } else {
                    field.set(student, rs.getObject(i + 1));
                }
            }
            studentList.add(student);
        }
        return studentList;
    }

    //释放资源 , 使用连接池无需释放资源(弃用)
    public static void close(Connection conn, PreparedStatement ptmt, ResultSet rs) {
        close(conn, ptmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, PreparedStatement ptmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ptmt != null) {
            try {
                ptmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


