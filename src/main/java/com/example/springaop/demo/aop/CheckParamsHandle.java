package com.example.springaop.demo.aop;


import com.example.springaop.demo.annotion.CheckParams;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
public class CheckParamsHandle {



    @Around("@annotation(com.example.springaop.demo.annotion.CheckParams)")
    public Object check(ProceedingJoinPoint joinPoint)throws Throwable {


        CheckParams checkParams = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(CheckParams.class);

        String methodName = joinPoint.getSignature().getName();

        Object target = joinPoint.getTarget();
        //得到拦截的方法
        Method method = getMethodByClassAndName(target.getClass(), methodName);
        //方法的参数
        Object[] args = joinPoint.getArgs();
        String msg = "";
        boolean flag = true;

        Class clazz = checkParams.modelClass();

        for (Object obj : args) {


            /**
             * 1.判断参数性质
             *    1.1 request的请求对象
             *    1.2 直接封装的参数
             *    1.3 key-value容器封装参数
             *
             */
            if (clazz!=null){
                if (obj.getClass()== clazz) {

                    Field[] fields = obj.getClass().getDeclaredFields();

                    // 遍历获得参数
                    for (Field field : fields) {

                        // 逻辑判断 - 感觉可以切出来
                        NotNull notNull = field.getAnnotation(NotNull.class);

                        if (notNull != null) {

                            field.setAccessible(true);
                            Object value = field.get(obj);
                            if (StringUtils.isEmpty(value)) {
                                msg = notNull.message();
                                flag = false;
                            }
                        }

                    }

                }

            }else{

                // 判断是否有map
                if (obj instanceof Map){




                }


            }


        }

        if (flag) {
            return joinPoint.proceed();
        } else{
            System.out.println("msg : " +msg);
            return null;
        }

    }

    /**
     * 根据类和方法名得到方法
     */
    public Method getMethodByClassAndName(Class c , String methodName){
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            if(method.getName().equals(methodName)){
                return method ;
            }
        }
        return null;
    }



}
