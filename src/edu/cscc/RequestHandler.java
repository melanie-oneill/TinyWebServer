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
            String[] reqArray = req.split("[ ]+");

            /** ---------------For Debugging----------------------
             *  System.out.println("Full Request: "+ req);
             *
             *   EXAMPLE OUTPUT:
             *  Full Request:
             *      GET /images HTTP/1.1Host: localhost:8080User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0Accept: text/html,application/xhtml+xml,application/xml;q=0.9,**;q=0.8Accept-Language: en-US,en;q=0.5Accept-Encoding: gzip, deflateConnection: keep-aliveUpgrade-Insecure-Requests: 1
             *  ---------------------------------------------------
             */

            System.out.println("Request: " + reqArray[0] +" "+ reqArray[1]);
            HTTPRequest httpRequest = new HTTPRequest(req);
            ResponseHandler responseHandler = new ResponseHandler(httpRequest);
            responseHandler.sendResponse(connection);
        }
        finally {
            connection.close();
        }
    }

    private String readRequest() throws IOException {

        connection.setSoTimeout(5000);
        InputStream in = connection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        StringBuilder content = new StringBuilder();
        String line;
        try {
              while ((line = bufferedReader.readLine()) != null) {
                  content.append(line);

            }
        } finally {
            bufferedReader.close();


            /** ---------------For Debugging----------------------
             *  String[] request = content.toString().split("[ ]+");
             *  System.out.println("Content: "+ request[0] + " " + request[1]);
             *
             *   EXAMPLE OUTPUT:
             *  "Content: GET /images"
             *  "Content: GET /"
             *  ---------------------------------------------------
             */

            return (content.toString());
        }
    }
}
