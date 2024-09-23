package utils;

import java.util.UUID;

public class ID {
    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
