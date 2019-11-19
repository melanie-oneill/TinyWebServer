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
        try {
            String req = readRequest();
            System.out.println("Got the request: " + req);
//            HTTPRequest httpRequest = new HTTPRequest(req);
//            ResponseHandler responseHandler = new ResponseHandler(httpRequest);
//            responseHandler.sendResponse(connection);
        }
        finally {
            //connection.close();
        }
    }

    private String readRequest() throws IOException {

        // Set socket timeout to 500 milliseconds

        //Bobby Notes: had to set Socket Timeout to 0 to bypass issues
//        connection.setSoTimeout(0);
        connection.setSoTimeout(5000);
        int recBufSize = connection.getReceiveBufferSize();
        InputStream in = connection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder content = new StringBuilder();
        String line;
        try {
//            while ((bufferedReader.ready()) && ((line = bufferedReader.readLine()) != null)) {
              while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Testing reader"); //delete this
                content.append(line);
            }
        } finally {
            bufferedReader.close();
            //Bobby Notes: content.toString is not working at the moment. will need some debugging

            return (content.toString());
        }
    }
}
