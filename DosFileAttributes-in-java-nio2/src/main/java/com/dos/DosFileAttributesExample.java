package com.dos;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class DosFileAttributesExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Improved File System Interface - in java-Advanced\\DosFileAttributes-in-java-nio2\\src\\main\\resources\\example.txt");

        try {
            // Get DosFileAttributeView
            DosFileAttributeView dosView = Files.getFileAttributeView(filePath, DosFileAttributeView.class);

            if (dosView != null) {
                // Read and display properties
                boolean isArchive = dosView.readAttributes().isArchive();
                boolean isHidden = dosView.readAttributes().isHidden();
                boolean isReadOnly = dosView.readAttributes().isReadOnly();
                boolean isSystem = dosView.readAttributes().isSystem();

                System.out.println("Archive: " + isArchive);
                System.out.println("Hidden: " + isHidden);
                System.out.println("Read-only: " + isReadOnly);
                System.out.println("System: " + isSystem);

                // Set the file to hidden mode
                dosView.setHidden(true);
                System.out.println("File set to hidden.");
            } else {
                System.out.println("DosFileAttributeView is not supported on this file system.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
