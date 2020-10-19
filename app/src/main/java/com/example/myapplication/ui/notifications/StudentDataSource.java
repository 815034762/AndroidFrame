package com.example.myapplication.ui.notifications;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据的来源（room，网络，...）
 *
 * 同学们：这里是数据源，获取数据目前是在这里完成的
 *
 * 官方文档上，继承的是ItemKeyedDataSource, 而这里实现的是PositionalDataSource
 *
 * PositionalDataSource<Student>: 适用于目标数据总数的固定，通过特别的位置加载数据(0-10)
 *  比如从数据库中的1200条开始加在20条数据。
 */

/**
 * 数据源 第三种
 */
public class StudentDataSource extends PositionalDataSource<Student> {

    /**
     * 同学们可以理解是加载第一页数据的时候，会执行此函数来完成
     * 加载初始化数据，可以这么来理解，加载的是第一页的数据。
     * 形象的说，当我们第一次打开页面，需要回调此方法来获取数据。
     * @param params
     * @param callback
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Student> callback) {
        // @1 数据源     @2 位置     @3 总大小
        callback.onResult(getStudents(0, 20), 0, 1000);
    }

    /**
     * 当有了初始化数据之后，滑动的时候如果需要加载数据的话，会调用此方法。
     * @param params
     * @param callback
     */
    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Student> callback) {
        // @1 从哪里开始加载(位置 内部算的)     @2 size(size 内部算的)
        callback.onResult(getStudents(params.startPosition, params.loadSize));
    }

    /**
     * 同学们，可以理解这里是数据源，数据的来源（数据库，文件，网络服务器响应  等等）
     * @param startPosition
     * @param pageSize
     * @return
     */
    private List<Student> getStudents(int startPosition, int pageSize) {
        List<Student> list = new ArrayList<>();
        for (int i = startPosition; i < startPosition + pageSize; i++) {
            Student student = new Student();
            student.setId("ID号是:" + i);
            student.setName("我名称:" + i);
            student.setSex("我性别:" + i);
            list.add(student);
        }
        return list;
    }
}
