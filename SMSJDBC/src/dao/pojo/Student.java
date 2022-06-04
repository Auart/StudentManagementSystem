package dao.pojo;
public class Student {
    private Integer id;//学生id
    private String name;//姓名
    private String sex;//性别
    private Integer age;//年龄
    private String nativePlace;//籍贯
    private String department;//系部
    private String major;//专业
    private Integer phone;//电话

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer age, String nativePlace, String department, String major,Integer phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nativePlace = nativePlace;
        this.department = department;
        this.major = major;
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", nativePlace='" + nativePlace + '\'' +
                ", department='" + department + '\'' +
                ", major='" + major + '\'' +
                ", phone=" + phone +
                '}';
    }

}
