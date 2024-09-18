package org.nttdata.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonUtil {
    public static Map<String, String> getFormDataFromJson(String filePath) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        JSONObject json = new JSONObject(content);
        JSONArray formDataArray = json.getJSONArray("form_data");

        if (formDataArray.length() > 0) {
            JSONObject jsonObject = formDataArray.getJSONObject(0);

            Map<String, String> dataMap = new HashMap<>();
            Iterator<String> keys = jsonObject.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonObject.getString(key);
                dataMap.put(key, value);
            }

            return dataMap;
        }

        throw new IllegalArgumentException("No data found in JSON file");
    }
}
