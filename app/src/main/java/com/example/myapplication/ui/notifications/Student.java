package com.example.myapplication.ui.notifications;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

/**
 * 实体bean
 */
public class Student {

    private String id;
    private String name;
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    // 比较的函数
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) &&
                name.equals(student.name) &&
                sex.equals(student.sex);
    }

    // 比较的函数
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }
}
