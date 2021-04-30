package com.example.myapplication.eventbus;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.example.myapplication.eventbus.annotation.BindView;
import com.example.myapplication.eventbus.annotation.SetContentLayout;

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
        setContentView(activity);
        findViewById(activity);
    }

    public static void setContentView(Activity activity) {
        // 利用反射代替setContentView方法
        Class<?> clazz = activity.getClass();
        boolean hasSetContentLayout = clazz.isAnnotationPresent(SetContentLayout.class);
        if (hasSetContentLayout) {
            SetContentLayout setContentLayout = clazz.getAnnotation(SetContentLayout.class);
            // 获取注解的值
            int layout = setContentLayout.layout();
            try {
                Method method = clazz.getMethod("setContentView",int.class);
                method.setAccessible(true);
                method.invoke(activity, layout);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


    public static void findViewById(Activity activity) {
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
