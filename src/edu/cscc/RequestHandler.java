package edu.cscc;

import java.io.*;
import java.net.Socket;

public class RequestHandler {
    private static Socket connection;
    private static TinyWS tinyWS = new TinyWS();

    public RequestHandler(Socket connection) {
        try {
            this.connection = connection;
            processRequest();
        }
        catch(Exception e){
            tinyWS.fatalError(e);
        }
    }

    public void processRequest() throws IOException {
        String req = readRequest();
        System.out.println("Got the request: " + req);
    }

    private String readRequest() throws IOException {

        // Set socket timeout to 500 milliseconds

        //Bobby Notes: had to set Socket Timeout to 0 to bypass issues
        connection.setSoTimeout(0);
        int recBufSize = connection.getReceiveBufferSize();
        InputStream in = connection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            System.out.println("Testing reader");
            content.append(line);
        }
        bufferedReader.close();
        //Bobby Notes: content.toString is not working at the moment. will need some debugging

        return(content.toString());
    }
}
