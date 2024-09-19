package com.uri;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URIDemo {
    public static void main(String[] args) {
        try {
            // Construct a URI from a string
            URI uri = new URI("http://www.example.com:8080/index.html?name=milad#section1");

            // Access various URI components
            System.out.println("Scheme: " + uri.getScheme()); // Output: http
            System.out.println("Authority: " + uri.getAuthority()); // Output: www.example.com:8080
            System.out.println("Path: " + uri.getPath()); // Output: /index.html
            System.out.println("Query: " + uri.getQuery()); // Output: name=John
            System.out.println("Fragment: " + uri.getFragment()); // Output: section1

            // Convert URI to URL
            URL url = uri.toURL();
            System.out.println("URL: " + url);

        } catch (URISyntaxException | java.net.MalformedURLException e) {
            e.printStackTrace();
        }
    }
}