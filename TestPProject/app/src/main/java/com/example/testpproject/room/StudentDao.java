package com.example.testpproject.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Update
    void update(Student... students);

    @Update
    int update(List<Student> students);

    @Query("update Student set age = :age where name like :name")
    int updat(int age, String name);

    @Insert
    void insert(Student... students);

    @Insert
    void insert(List<Student> students);

    //    删除单个对象
    @Delete
    int delete(Student student);

    //   可以删除所有数据
    @Query("delete from Student where name like :name")
    int deleteByName(String name);


    @Query("select * from Student")
    List<Student> getAll();

    @Query("select * from Student where name like :name")
    List<Student> findByName(String name);

    @Query("select * from Student where name in (:names)")
    List<Student> findByNames(String[] names);

    @Query("select * from Student where name like :name and gender like :gender limit 1,2")
    List<Student> findBynameAndGender(String name, String gender);

    @Query("select name,gender from Student")
    List<StudentField> localVariable();

    @Query("select * from User")
    List<User> getUsers();


//    @Query("insert into User values ('1',3)")
//    void insert(List<User> users);

    @Insert
    void insert1(List<User> list);
}
