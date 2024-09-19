package com.posix;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Set;
import static java.nio.file.attribute.PosixFilePermission.*;

public class PosixFileAttributesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Improved File System Interface - in java-Advanced\\PosixFileAttributes-nio-2-in-java\\src\\main\\resources\\example.txt");

        try {
            // Get PosixFileAttributeView
            PosixFileAttributeView posixView = Files.getFileAttributeView(filePath, PosixFileAttributeView.class);

            if (posixView != null) {
                // Read file attributes
                PosixFileAttributes attributes = posixView.readAttributes();
                System.out.println("Owner: " + attributes.owner());
                System.out.println("Group: " + attributes.group());
                System.out.println("Permissions: " + attributes.permissions());

                // change file permissions (give read and write to owner)
                Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-r-----");
                posixView.setPermissions(perms);

                System.out.println("Permissions updated: " + perms);
            } else {
                System.out.println("POSIX file attribute view is not supported on this file system.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
