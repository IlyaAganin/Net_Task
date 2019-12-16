package com.netcracker.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import com.netcracker.reflection.InjectorException;
//import com.netcracker.reflection.LabInject;
import com.netcracker.sort.ISorted;

/**
 * class which store method for record of object
 * @param <T> parameter of typing
 */
public class Injector<T> {
    /**
     * method which realize injection
     * @param rep object of class repository which will be checked by reflection
     * @param <T> parameter of typing
     * @throws InjectorException exception which will be thrown when file of type .properties cannot be acquired 
     */
    public static <T> T inject(T rep) throws InjectorException {
        String propsPath = "src\\main\\resources\\props.properties";
        Class<?> clazz =  rep.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(propsPath));
        } catch (IOException e) {
            throw new InjectorException(e);
        }

        for (Field field: fields) {
            System.out.println(field.getClass().getName());
            if (field.isAnnotationPresent(LabInject.class)) {
                try {
                    Class<?> seatedClass =  Class
                            .forName(
                            props.getProperty(
                                    ISorted.class.getName())
                            );

                    Object seatedClassObject = seatedClass.newInstance();
                    field.setAccessible(true);
                    field.set(rep, seatedClassObject);

                } catch(IllegalAccessException e ) {
                   throw new InjectorException(e);
                } catch (ClassNotFoundException e) {
                   throw  new InjectorException(e);
                } catch(InstantiationException e) {
                    throw new InjectorException(e);
                }
            }


        }
        return rep;
    }
}
