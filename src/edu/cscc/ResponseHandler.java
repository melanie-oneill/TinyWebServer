package edu.cscc;

import javax.activation.MimeType;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

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
    private Config config = new Config();
    String folder = config.getProperty("defaultFolder");

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
        if (path != null) {
            if (path.contains("..")){
                responseCode = 403;
            }
            else if (path.contains("/")){
                path = path.concat("/"+folder);
            }
            else if ((!path.contains("/")) || (!path.contains(".."))) {
                path = folder.concat("/" + path);
            }
            //TODO: Check the garbage above ^
            //Check to see if path is a file or a directory
        }
       // TODO delete next statement
        return(null);
    }

    // Read file, return byte array (null if error)
    private byte[] readFile(File f) {
        FileInputStream fis = null;

        byte[] bArray = new byte[(int) f.length()];
        try{
            fis = new FileInputStream(f);
            fis.read(bArray);
            fis.close();
        } catch(IOException e){
            System.out.println("Issue reading file as byte[].");
            e.printStackTrace();
        }
        return bArray;
    }

    // Return mimetype based on file suffix (or null if error)
    private String getMimeType(String path) {
        String mimeType = null;
        File f = new File(path);
        mimeType = URLConnection.guessContentTypeFromName(f.getName());

        System.out.println("File type: "+path);
        System.out.println("Mime type: "+mimeType);


        return mimeType;
    }
}
