/*
 * Copyright (C) 2016 Jecelyin Peng <jecelyin@gmail.com>
 *
 * This file is part of 920 Text Editor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.jecelyin.common.utils;

import android.os.Parcel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Utility class to use reflection to call methods.
 * getMethods方法, 包其继承类的方法,但不包括私有方法
 * getDeclaredMethods方法只包含当前类的方法,但包括私有方法
 *
 */
public class MethodReflection {
    private Method method;
    private String className;
    private String methodName;

    /**
     *
     * @param object
     * @param methodName
     * @param argTypes null if argument not
     */
    public MethodReflection(Object object, String methodName, Class<?>[] argTypes) {
        this(object.getClass(), methodName, argTypes);
    }

    /**
     *
     * @param cls
     * @param methodName
     * @param argTypes null if argument not
     */
    public MethodReflection(Class<?> cls, String methodName, Class<?>[] argTypes) {
        className = cls.getName();
        this.methodName = methodName;

        try {
            method = cls.getDeclaredMethod(methodName, argTypes);
        } catch (Exception e) {
            try {
                method = cls.getMethod(methodName, argTypes);
            } catch (Exception e1) {
                L.e("MethodReflection", "Can't reflection method: " + methodName, e1);
            }
        }

        if (method != null)
            method.setAccessible(true);
    }

    public boolean exists() {
        return method != null;
    }

    /**
     *
     * @param instance null if static method
     * @param args
     * @return
     * @throws Throwable
     */
    private Object call(Object instance, Object... args) throws Throwable {
        if (method == null)
            throw new NoSuchMethodException(className + "#" + methodName);

        try {
            return method.invoke(instance, args);
        } catch (Exception e) {
            if(e instanceof InvocationTargetException){
                throw ((InvocationTargetException) e).getTargetException();
            } else {
                throw e;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Object instance, Object... args) throws Throwable {
        return (T) call(instance, args);
    }

    @SuppressWarnings("unchecked")
    public <T> T staticGet(Object... args) throws Throwable {
        return (T) call(null, args);
    }

    /**
     *
     * @param instance null if static method
     * @param args
     * @throws Throwable
     */
    public void invoke(Object instance, Object... args) throws Throwable {
        get(instance, args);
    }

    public void staticInvoke(Object... args) throws Throwable {
        get(null, args);
    }

    /**
     * 修改 static final Type type = xx; 这样的值
     * @param field
     * @param newValue
     * @throws Exception
     */
    public static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
//        Field modifiersField = Field.class.getDeclaredField("accessFlags");
//        modifiersField.setAccessible(true);
//        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }

    public static void setFinalStatic(Class<Parcel> cls, String varName, Object value) throws Exception {
        Field f;
        try {
            f = cls.getDeclaredField(varName);
        }catch (NoSuchFieldException e) {
            f = cls.getField(varName);
        }
        setFinalStatic(f, value);
    }
}
