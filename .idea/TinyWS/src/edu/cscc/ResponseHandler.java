package edu.cscc;

import java.io.*;
import java.net.*;

public class ResponseHandler {
    private static final String NOT_FOUND_RESPONSE =
            "HTTP/1.0 404 NotFound\n" +
                    "Server: TinyWS\n" +
                    "Content-type: text/plain\n\n" +
                    "Requested file not found.";

    private static final String FORBIDDEN_RESPONSE =
            "HTTP/1.0 403 Forbidden\n" +
                    "Server: TinyWS\n" +
                    "Content-type: text/plain\n\n" +
                    "Requested action is forbidden.  So there!";

    private static final String HTTP_OK_HEADER =
            "HTTP/1.0 200 OK\n" +
                    "Server: TinyWS\n" +
                    "Content-type: ";

    private HTTPRequest request;
    private int responseCode;

    public ResponseHandler(HTTPRequest request) {
        this.request = request;
        responseCode = 404;
    }

    /**
     * Send HTTP Response
     */
    public void sendResponse(Socket connection) throws IOException {
        byte[] response = null;
        int sendbufsize = connection.getSendBufferSize();
        BufferedOutputStream out = new BufferedOutputStream(
                connection.getOutputStream(), sendbufsize);
       // TODO code here
}

    // Find requested file, assume Document Root is in html folder in project directory
    private byte[] getFile(String path) {
       // TODO code here

        // TODO delete next statement
        return(null);
    }

    // Read file, return byte array (null if error)
    private byte[] readFile(File f) {
        // TODO code here

        // TODO delete next statement
        return(null);
    }

    // Return mimetype based on file suffix (or null if error)
    private String getMimeType(String path) {
        String mimeType = null;

        // TODO code here

        return mimeType;
    }
}
