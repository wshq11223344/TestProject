package com.example.testpproject.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.os.Bundle;
import android.util.Log;

import com.example.testpproject.R;

import java.util.ArrayList;
import java.util.List;

public class Db2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db2);


        new Thread(() -> {


            StudentDao studentDao = AppDataBase.getInstance().studentDao();

            List<Student> list = new ArrayList<>();

            list.add(new Student("han1", "男", 26));
            list.add(new Student("han2", "男", 23));
            list.add(new Student("han3", "男", 26));
            list.add(new Student("han4", "男", 25));
            list.add(new Student("han5", "男", 28));
//
//
            studentDao.insert(list);
            List<Student> studentList = studentDao.getAll();
//
            Log.e("=====", studentList.toString());


//            studentDao.insert(new Student("han", "男", 26));
//            studentDao.insert(new Student("hn", "男", 23));
//            studentDao.insert(new Student("han", "男", 26));
//            studentDao.insert(new Student("an", "男", 25));
//            studentDao.insert(new Student("n", "男", 28));


//

//            List<Student> students = studentDao.findByName("han");
//
//            Log.e("=====", students.toString());
//
//            List<Student> students1 = studentDao.findByNames(new String[]{"an", "n"});
//
//            Log.e("=====", students1.toString());
//
//
//            List<Student> bynameAndGender = studentDao.findBynameAndGender("han", "男");
//
//            Log.e("===bynameAndGender==", bynameAndGender.toString());
//
//            List<StudentField> studentFields = studentDao.localVariable();
//
//            Log.e("=====", studentFields.toString());

//            int delete = studentDao.deleteByName("han");
//            Log.e("=====", delete + "");

//            Student student = new Student("hn", "男", 23);
//            student.setStId(2);
//            int delete = studentDao.delete(student);
//            Log.e("=====", delete + "");

//            Student student = new Student("hn", "男", 30);
//            student.setStId(2);
//            studentDao.update(student);

//            Student student = new Student("han1", "男", 26);
//            student.setStId(1);
//            Student student1 = new Student("han2", "男", 27);
//            student.setStId(2);
//            Student student2 = new Student("han3", "男", 28);
//            student.setStId(3);
//            Student student3 = new Student("han4", "男", 29);
//            student.setStId(4);
//            Student student4 = new Student("han5", "男", 30);
//            student.setStId(5);
//            List<Student> list = new ArrayList<>();
//            list.add(student);
//            list.add(student1);
//            list.add(student2);
//            list.add(student3);
//            list.add(student4);

//            int update = studentDao.update(list);
//            Log.e("======", update + "");

//            int updat = studentDao.updat(36, "han");
//
//            Log.e("======", updat + "");


//            User user = new User("张三", 1);
//            User user2 = new User("李四", 2);
//
//            List<User> list = new ArrayList<>();
//            list.add(user);
//            list.add(user2);
//
//            studentDao.insert1(list);
//
            List<User> userList = studentDao.getUsers();

            Log.e("=====", userList.toString());


        }).start();

    }


    @Override
    protected void onStop() {
        super.onStop();
    }

}
