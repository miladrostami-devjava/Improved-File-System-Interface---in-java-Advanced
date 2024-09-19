package com.store;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.io.IOException;

public class FileStoreExample {
    public static void main(String[] args) {
        try {
            // Browse through all available file storages on the system
            for (FileStore store : FileSystems.getDefault().getFileStores()) {
                System.out.println("File Store: " + store.name());
                System.out.println("Type: " + store.type());
                System.out.println("Total Space: " + store.getTotalSpace() + " bytes");
                System.out.println("Usable Space: " + store.getUsableSpace() + " bytes");
                System.out.println("Is Read-Only: " + store.isReadOnly());
                System.out.println("--------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}