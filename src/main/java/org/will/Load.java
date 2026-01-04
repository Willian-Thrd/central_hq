package org.will;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Load {
    private static final File dir = new File(System.getProperty("user.dir"));
    private static final File contentDir = dir.getParentFile();
    private static final File file = new File(contentDir, "contents/checked.json");

    public static Set<File> load() {
        Set<File> result =  new HashSet<>();

        if (!file.exists()) {
            return result;
        }

        try (FileReader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type type = new TypeToken<Set<String>>() {}.getType();

            Set<String> paths = gson.fromJson(reader, type);

            if (paths != null) {
                for (String p : paths) {
                    File f = new File(p);
                    if (f.exists()) {
                        result.add(f);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
