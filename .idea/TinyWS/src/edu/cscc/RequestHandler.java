package edu.cscc;

import java.io.*;
import java.net.Socket;

public class RequestHandler {
    private Socket connection;

    public RequestHandler(Socket connection) {
        this.connection = connection;
    }

    public void processRequest() {
        // TODO code here
    }

    private String readRequest() throws IOException {
        // Set socket timeout to 500 milliseconds
        connection.setSoTimeout(500);
        int recbufsize = connection.getReceiveBufferSize();
        InputStream in = connection.getInputStream();

        // TODO add code here

        // TODO - detete following statement
        return(null);
    }
}
