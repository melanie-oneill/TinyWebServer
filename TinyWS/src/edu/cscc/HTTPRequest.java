package edu.cscc;

public class HTTPRequest {
    private String request;         // request string
    private String path;            // path to file
    private boolean validRequest;   // is request valid?

    public HTTPRequest(String r) {
        // TODO Constructor
    }

    public boolean isValidRequest() {
        return (validRequest);
    }

    public String getPath() {
        return (path);
    }

    // TODO uncomment
    // private boolean parse(String r) {
        //  TODO code here
    // }
}
