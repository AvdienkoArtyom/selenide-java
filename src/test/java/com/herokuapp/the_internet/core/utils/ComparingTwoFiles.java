package com.herokuapp.the_internet.core.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ComparingTwoFiles {

    public static boolean comparing(Path expected, Path actual) {
        try {
            byte[] bytes1 = Files.readAllBytes(expected);
            byte[] bytes2 = Files.readAllBytes(actual);

            if (bytes1.length != bytes2.length) {
                return false;
            }
            for (int i = 0; i < bytes1.length; i++) {
                if (bytes1[i] != bytes2[i]) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
