package com.example.testpproject.zyhs.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }


    private Student(Parcel parcel) {

        name = parcel.readString();
        age = parcel.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeInt(age);

    }


    public static final Creator<Student> CREATOR = new Creator<Student>() {

        @Override
        public Student createFromParcel(Parcel source) {

            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
