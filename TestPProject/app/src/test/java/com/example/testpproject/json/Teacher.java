package com.example.testpproject.json;

import java.util.List;

public class Teacher {
    /**
     * course : {"code":"88","courseName":"english"}
     * student : [{"studentAge":"28","studentName":"喊喊"},{"studentAge":"66","studentName":"哈哈"}]
     * teacherAge : 45
     * teacherName : 王琳
     */

    private CourseBean course;
    private String teacherAge;
    private String teacherName;
    private List<StudentBean> student;


    public Teacher(CourseBean course, String teacherAge, String teacherName, List<StudentBean> student) {
        this.course = course;
        this.teacherAge = teacherAge;
        this.teacherName = teacherName;
        this.student = student;
    }

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<StudentBean> getStudent() {
        return student;
    }

    public void setStudent(List<StudentBean> student) {
        this.student = student;
    }

    public static class CourseBean {
        /**
         * code : 88
         * courseName : english
         */

        private String code;
        private String courseName;


        public CourseBean(String code, String courseName) {
            this.code = code;
            this.courseName = courseName;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        @Override
        public String toString() {
            return "CourseBean{" +
                    "code='" + code + '\'' +
                    ", courseName='" + courseName + '\'' +
                    '}';
        }
    }

    public static class StudentBean {
        /**
         * studentAge : 28
         * studentName : 喊喊
         */

        private String studentAge;
        private String studentName;


        public StudentBean(String studentAge, String studentName) {
            this.studentAge = studentAge;
            this.studentName = studentName;
        }

        public String getStudentAge() {
            return studentAge;
        }

        public void setStudentAge(String studentAge) {
            this.studentAge = studentAge;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        @Override
        public String toString() {
            return "StudentBean{" +
                    "studentAge='" + studentAge + '\'' +
                    ", studentName='" + studentName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "course=" + course +
                ", teacherAge='" + teacherAge + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", student=" + student +
                '}';
    }

    //    private String teacherName;
//    private String teacherAge;
//    private Course course;
//    private List<Students> student;
//
//
//    public Teacher() {
//    }
//
//    public Teacher(String teacherName, String teacherAge, Course course, List<Students> student) {
//        this.teacherName = teacherName;
//        this.teacherAge = teacherAge;
//        this.course = course;
//        this.student = student;
//    }
//
//
//    public String getTeacherName() {
//        return teacherName;
//    }
//
//    public void setTeacherName(String teacherName) {
//        this.teacherName = teacherName;
//    }
//
//    public String getTeacherAge() {
//        return teacherAge;
//    }
//
//    public void setTeacherAge(String teacherAge) {
//        this.teacherAge = teacherAge;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//
//    public List<Students> getStudent() {
//        return student;
//    }
//
//    public void setStudent(List<Students> student) {
//        this.student = student;
//    }
//
//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "teacherName='" + teacherName + '\'' +
//                ", teacherAge='" + teacherAge + '\'' +
//                ", course=" + course +
//                ", student=" + student +
//                '}';
//    }
//
//
//    public class Students {
//
//        private String studentName;
//        private String studentAge;
//
//        public Students(String studentName, String studentAge) {
//            this.studentName = studentName;
//            this.studentAge = studentAge;
//        }
//
//        public String getStudentName() {
//            return studentName;
//        }
//
//        public void setStudentName(String studentName) {
//            this.studentName = studentName;
//        }
//
//        public String getStudentAge() {
//            return studentAge;
//        }
//
//        public void setStudentAge(String studentAge) {
//            this.studentAge = studentAge;
//        }
//
//        @Override
//        public String toString() {
//            return "Student{" +
//                    "studentName='" + studentName + '\'' +
//                    ", studentAge='" + studentAge + '\'' +
//                    '}';
//        }
//    }
//
//    public class Course {
//
//        private String courseName;
//        private String code;
//
//        public Course(String courseName, String code) {
//            this.courseName = courseName;
//            this.code = code;
//        }
//
//        public String getCourseName() {
//            return courseName;
//        }
//
//        public void setCourseName(String courseName) {
//            this.courseName = courseName;
//        }
//
//        public String getCode() {
//            return code;
//        }
//
//        public void setCode(String code) {
//            this.code = code;
//        }
//
//        @Override
//        public String toString() {
//            return "Course{" +
//                    "courseName='" + courseName + '\'' +
//                    ", code='" + code + '\'' +
//                    '}';
//        }
//    }


}
