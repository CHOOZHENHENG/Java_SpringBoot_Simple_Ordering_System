package com.example.order.validation;

import com.example.order.annotation.Constraint;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

@Slf4j
public class BeanValidator {
    public static void validateWithException(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();

        validateClassField(fields, object);

        for(Field field : fields) {
            if(field.getType().getPackageName().equals(object.getClass().getPackageName())){
                try{
                    Field innerField = object.getClass().getDeclaredField(field.getName());
                    innerField.setAccessible(true);
                    Object value = innerField.get(object);
                    Field[] innerPropField = value.getClass().getDeclaredFields();
                    validateClassField(innerPropField, value);
                }catch (NoSuchFieldException | IllegalAccessException e){
                    log.error("encounter an error while validate inner field.", e);
                    throw new RuntimeException("validate inner field error");
                }
            }
        }
    }

    public static void validateClassField(Field[] fields, Object object) {
        for(Field field : fields) {
            try {
                if (field.isSynthetic() || Modifier.isStatic(field.getModifiers()) ||
                        (field.getType() == boolean.class)) {
                    continue;
                }

                String methodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
                Object invoke = object.getClass().getMethod(methodName).invoke(object);

                Annotation[] annotations = field.getAnnotations();

                for(Annotation annotation : annotations) {
                    Constraint constraints = annotation.annotationType().getAnnotation(Constraint.class);

                    if (constraints != null) {
                        synchronized (constraints.validateBy()){
                            Class<? extends Validator> validate = constraints.validateBy();
                            Validator validator = validate.getDeclaredConstructor().newInstance();
                            validator.initialize(annotation);
                            boolean isValid = validator.isValid(invoke);
                            if(!isValid){
                                throw new IllegalArgumentException((String) annotation.annotationType().getMethod("message").invoke(annotation));
                            }
                        }
                    }
                }
            }catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e){
                log.error("encounter an error while validate bean.", e);
                throw new RuntimeException("validate bean error");
            }
        }
    }
}
