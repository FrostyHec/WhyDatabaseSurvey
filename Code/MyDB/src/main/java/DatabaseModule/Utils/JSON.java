package DatabaseModule.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JSON {
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(Class.class, new TypeAdapter()).create();;

    public static String serialize(Object o) {
        return gson.toJson(o);
    }

    public static <T> T deserialize(String json, Class<T> cls) {
        if (json==null) return null;
        return gson.fromJson(json, cls);
    }
}
