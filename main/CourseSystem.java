package com.bitedu.main;

        import com.bitedu.data.Student;

        import static com.bitedu.db.DatabaseOperation.insertStudent;
        import static com.bitedu.db.DatabaseOperation.selectStudent;

//客户端：
public class CourseSystem {
    public static void main(String[] args) {
        Student stu=new Student();
        stu.setSn(20191218);
        stu.setName("小卤蛋");
        stu.setClassId(2);
        insertStudent(stu);
        //selectStudent(stu);
    }
}
