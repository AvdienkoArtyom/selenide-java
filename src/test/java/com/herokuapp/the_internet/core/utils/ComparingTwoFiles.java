package com.herokuapp.the_internet.core.utils;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ComparingTwoFiles {

    public static boolean comparing(Path expected, Path actual) {
        try {
            byte[] expectedBytes = Files.readAllBytes(expected);
            byte[] actualBytes = Files.readAllBytes(actual);
            Assertions.assertArrayEquals(expectedBytes, actualBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
