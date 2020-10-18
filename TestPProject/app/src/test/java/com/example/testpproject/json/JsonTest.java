package com.example.testpproject.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    @Test
    public void test() {

        Student student = new Student("张三", "男", 26);

        Gson gson = new Gson();
        String json = gson.toJson(student);
        System.out.println(json);

        Student student1 = gson.fromJson(json, Student.class);
        System.out.println(student1.toString());

        List<Student> list = new ArrayList<>(6);
        list.add(new Student("韩琦", "男", 27));
        list.add(new Student("涵涵", "女", 26));
        list.add(new Student("哈哈", "男", 25));

        String json1 = gson.toJson(list);
        System.out.println(json1);
        List<Student> list1 = gson.fromJson(json1, new TypeToken<List<Student>>() {
        }.getType());

        for (int i = 0; i < list1.size(); i++) {

            System.out.println(list1.get(i).toString());
        }
//        jsonobject解析json数据
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getString("name"));
        System.out.println(jsonObject.getString("gender"));
        System.out.println(jsonObject.getInteger("age"));

        String jsonString = JSONObject.toJSONString(student);
        System.out.println(jsonString);
        JSONObject parseObject = JSONObject.parseObject(jsonString);
        System.out.println(parseObject.toString());


        Student student2 = JSONObject.parseObject(jsonString, Student.class);
        System.out.println("测试" + student2.toString());
    }


    @Test
    public void test2() {
        List<Student> list = new ArrayList<>(6);
        list.add(new Student("韩琦", "男", 27));
        list.add(new Student("涵涵", "女", 26));
        list.add(new Student("哈哈", "男", 25));

        String jsonString = JSONObject.toJSONString(list);
        System.out.println(jsonString);
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        int size = jsonArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("name") + "===" + jsonObject.getString("gender") + "===" + jsonObject.getInteger("age"));
        }

    }

    @Test
    public void test3() {

        List<Teacher.StudentBean> studentList = new ArrayList<>(6);
        Teacher.StudentBean student = new Teacher.StudentBean("喊喊", "28");
        Teacher.StudentBean student2 = new Teacher.StudentBean("哈哈", "66");

        Teacher.CourseBean course = new Teacher.CourseBean("english", "88");

        studentList.add(student);
        studentList.add(student2);


        Teacher teacher = new Teacher(course, "王琳", "45", studentList);

        String jsonString = JSONObject.toJSONString(teacher);

        System.out.println(jsonString);

//        Gson gson = new Gson();
//        String s = gson.toJson(teacher);
//        System.out.println(s);


        JSONObject parseObject = JSONObject.parseObject(jsonString);

        String teacherName = parseObject.getString("teacherName");
        System.out.println(teacherName);
        String teacherAge = parseObject.getString("teacherAge");
        System.out.println(teacherAge);


        JSONObject course1 = parseObject.getJSONObject("course");
        System.out.println(course1.getString("code"));
        System.out.println(course1.getString("courseName"));

        JSONArray jsonArray = parseObject.getJSONArray("student");


        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.toString());
            String studentName = jsonObject.getString("studentName");
            System.out.println(studentName);
        }

        System.out.println("===================");
        Teacher teacher1 = JSONObject.parseObject(jsonString, Teacher.class);
        System.out.println(teacher1.toString());
        System.out.println(teacher1.getStudent().toString());
        List<Teacher.StudentBean> student1 = teacher1.getStudent();
        for (int i = 0; i < student1.size(); i++) {
            System.out.println(student1.get(i));
        }

        System.out.println(teacher1.getCourse());

    }

    @Test
    public void test6() throws Exception {
        JSONArray pigs = new JSONArray();
        JSONObject pig1 = new JSONObject();
        pig1.put("name", "佩奇");
        JSONObject pig2 = new JSONObject();
        pig2.put("name", "猪猪侠");
        pigs.add("八戒");
        pigs.add(pig1);
        pigs.add(pig2);
        /*
         * 这样构造的JSONArray对象如下
         * ["八戒",{"name":"佩奇"},{"name":"猪猪侠"}]
         */
        System.out.println(pigs.get(0));
        System.out.println(pigs.getJSONObject(1));
        System.out.println(pigs.getJSONObject(2));
        JSONObject jsonObject = pigs.getJSONObject(2);
        System.out.println(jsonObject.getString("name"));

    }


    @Test
    public void test7() {
        JSONObject student = new JSONObject();
        /*
         * put(key,value)其中key是键名，一般为字符串，用于调用后边的value,
         * value的值为String或JSONObject或JSONArray对象
         */
        //put(key,value)添加String对象
        student.put("name", "小明");
        student.put("sno", "20160000");

        JSONObject address = new JSONObject();
        address.put("city", "石家庄市");
        address.put("country", "长安区");
        student.put("address", address);

        System.out.println(student.toString());

        JSONArray family = new JSONArray();
        JSONObject father = new JSONObject();
        father.put("name", "小明老爸");
        father.put("age", 40);
        JSONObject mother = new JSONObject();
        mother.put("name", "小明老妈");
        mother.put("age", 41);
        family.add(father);
        family.add(mother);

        student.put("family", family);

        System.out.println(student.getJSONObject("address"));
        System.out.println(student.getJSONArray("family"));

        JSONArray jsonArray = student.getJSONArray("family");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject);
            System.out.println(jsonObject.getString("name"));
            System.out.println(jsonObject.getString("age"));

        }
    }
}
