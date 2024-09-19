package com.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;

public class PathFeaturesDemo {
    public static void main(String[] args) {
        Path path = Paths.get("reports", "2015", "jan");

        // Compare routes
        Path anotherPath = Paths.get("reports", "2015", "jan");
        System.out.println("Paths are equal: " + path.equals(anotherPath)); // Output: true

        // Checking the start and end of the route
        System.out.println("Starts with 'reports': " + path.startsWith("reports")); // true
        System.out.println("Ends with 'jan': " + path.endsWith("jan")); // true

        // Convert to URI
        URI uri = path.toUri();
        System.out.println("Path URI: " + uri); // Output: URI for file path

        // Another example: path to another file
        Path path2 = Paths.get("C:", "Users", "example", "documents", "file.txt");
        System.out.println("Path2 starts with 'C:\\Users': " + path2.startsWith(Paths.get("C:", "Users")));
        System.out.println("Path2 ends with 'file.txt': " + path2.endsWith("file.txt"));
    }
}
