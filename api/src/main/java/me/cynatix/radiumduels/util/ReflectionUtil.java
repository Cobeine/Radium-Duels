package me.cynatix.radiumduels.util;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ReflectionUtil {

    public static HashMap<Field, Object> getFields(Object object) {

        Field[] fields = object.getClass().getDeclaredFields();
        HashMap<Field, Object> map = new HashMap<>();

        try {

            for (Field field : fields) {

                Object value = field.get(object);
                map.put(field, value);

            }

        } catch (Exception ignored) {}


        return map;
    }

    public static void updateField(Field field, Object value, Object clazz) {

        try {

            field.setAccessible(true);
            field.set(clazz, value);

        } catch (Exception ignored) {}


    }


}




