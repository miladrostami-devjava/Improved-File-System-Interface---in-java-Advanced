package ir.watchapi;

import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
import java.io.IOException;

public class WatchServiceExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Directory path to monitor
        Path path = Paths.get("C:\\Users\\Parse\\Desktop\\MiladTask\\JavaCoreTask\\Improved File System Interface - in java-Advanced\\WatchServiceAPI-in-java\\src\\main\\resources\\watched_directory");

        // Create WatchService
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // Register directory with WatchService for event types
        path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

        System.out.println("Monitoring directory: " + path);

        // Monitoring loop for events
        while (true) {
            // Waits for an event
            WatchKey key = watchService.take();

            // Process events
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();

                // The name of the file related to the event
                Path fileName = (Path) event.context();

                if (kind == ENTRY_CREATE) {
                    System.out.println("File created: " + fileName);
                } else if (kind == ENTRY_DELETE) {
                    System.out.println("File deleted: " + fileName);
                } else if (kind == ENTRY_MODIFY) {
                    System.out.println("File modified: " + fileName);
                }
            }

            // Reset WatchKey
            boolean valid = key.reset();
            if (!valid) {
                break; // Exit if no longer monitored
            }
        }
    }
}