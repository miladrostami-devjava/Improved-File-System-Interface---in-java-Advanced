package com.match;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileTreeMatchingExample {
    public static void main(String[] args) throws IOException {
        Path startDir = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Improved File System Interface - in java-Advanced\\FileTreeMatching-in-java\\src\\main\\resources\\docs");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");

        // Navigating the file tree and matching paths with the Glob pattern
        Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (matcher.matches(file)) {
                    System.out.println("Matching file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
