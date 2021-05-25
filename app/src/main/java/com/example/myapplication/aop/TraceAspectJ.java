package com.example.myapplication.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;

/**
 * @author ly-zhangty
 */
@Aspect
public class TraceAspectJ {

    private static final String POINTCUP_METHOD = "execution(@com.example.myapplication.aop.Trace * *(..))";

    @Pointcut(POINTCUP_METHOD)
    public void annoHaviorTrace() {
        Log.e("zty", "=====annoHaviorTrace=====");
    }

    @Around("annoHaviorTrace()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        Object[] param;
        param = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 注解里面使用注解
        //第一个维度对应参数列表里参数的数目，第二个维度对应参数列表里对应的注解。如上图的示例方法有四个参数。则第一个维度的长度就是四
        // public void testa(@TestAnnocation(pat = "5") String s,
        //   @TestAnnocation2 @TestAnnocation(pat = "6") String s1,
        //   String s3,
        //   @TestAnnocation(pat = "9") String s4) {
        //   System.out.println("------------" + s);
        // }
        Annotation[][] annotations = methodSignature.getMethod().getParameterAnnotations();
        for(int i = 0; i < annotations.length; i++) {
            // 只考虑只有一个注解的情况
            Annotation annotation = annotations[i][0];
            // 是否包含Trace注解
            if("Trace".equals(annotation.annotationType().getSimpleName())) {
             TraceParam traceParam = (TraceParam) annotation;
                Log.e("ztys", "  :注解参数获取到的值:  " + param[0]);
            }
        }

//        TraceParam traceParam = methodSignature.getMethod().getAnnotation(TraceParam.class);
//        Log.e("ztys", "  :methodSignature.getMethod().getAnnotation获取到的值:  " + traceParam.param());
        
        Trace trace = methodSignature.getMethod().getAnnotation(Trace.class);
        Object object = joinPoint.getThis(); // 调用该方法的对象
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();
        String[] reserve = trace.reserve();
        String traceId = trace.traceId();
        boolean isBefore = trace.isBefore();
        if (isBefore) {
            Log.e("ztys", object.getClass().getSimpleName() + "在方法之前执行");
            // 返回null,因为不执行joinPoint.proceed()方法，所以不会执行有Trace注解的方法
            return null;
        } else {
            Log.e("ztys", object.getClass().getSimpleName() + "在方法之后执行");
        }
        result = joinPoint.proceed();
        return result;
    }


}
