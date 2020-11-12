package com.willfp.studentmanager.serialisation.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.willfp.studentmanager.groups.Group;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SerialisationUtils {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static String serialiseGroup(Group group) {
        String json = GSON.toJson(group);
        return json;
    }

    public static Group deserialiseGroup(String json, Class<? extends Group> type) {
        Group group = GSON.fromJson(json, type);
        return group;
    }

    public static Group deserialiseGroup(File file, Class<? extends Group> type) {
        String path = file.getAbsolutePath();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        Group group = GSON.fromJson(bufferedReader, type);
        return group;
    }
}
