package org.example.bilibili.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;

/**
 * @author Xiaobo Bi (869384236@qq.com)
 */
@UtilityClass
public class JsonUtil {

    public <T> T toObject(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.fromJson(json, clazz);
    }
}
