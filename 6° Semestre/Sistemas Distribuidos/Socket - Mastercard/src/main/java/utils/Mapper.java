package utils;

import com.google.gson.Gson;

public class Mapper {

    public static <T> T jsonToObject(String content, Class<T> clazz) {
        return new Gson().fromJson(content, clazz);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
