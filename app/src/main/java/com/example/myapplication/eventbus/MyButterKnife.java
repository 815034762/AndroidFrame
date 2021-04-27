package com.example.myapplication.eventbus;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.myapplication.eventbus.annotation.BindView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 仿butterKnife
 *
 * @author ly-zhangty
 */
public class MyButterKnife {

    public static void bind(Activity activity) {
        // 利用反射代替findViewById方法
        Class<?> clazz = activity.getClass();
        // getDeclaredFields可以获取所有的字段,clazz.getFields只能获取public的
        Field[] fields = clazz.getDeclaredFields();
        // 获取数量
        for (Field field : fields) {
            // 有BindView注解
            if (field.isAnnotationPresent(BindView.class)) {
                int viewId = 0;
                Method findViewById;
                BindView annotation = field.getAnnotation(BindView.class);
                viewId = annotation.value();
                Log.e("zty", "view's id is " + viewId);
                try {
                    findViewById = clazz.getMethod("findViewById", int.class);
                    try {
                        View view = (View) findViewById.invoke(activity, viewId);
                        // 取消访问检查，private也可以访问
                        field.setAccessible(true);
                        field.set(activity, view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        Log.e("zty", "Exception is " + e.getLocalizedMessage());
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        Log.e("zty", "InvocationTargetException is " + e.getLocalizedMessage());
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
