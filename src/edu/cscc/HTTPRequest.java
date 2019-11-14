package edu.cscc;

import java.io.File;


/**
 * @author Bobby Linse, Christin Goff, Melanie O'Neill
 * @date November 2019
 */
public class HTTPRequest {
    private String request;
    private String path;
    private boolean validRequest;
    private static final String REG_EX_DELIMINATERS = "[\t\n?]";

    /**
     * @desctiption This constructor takes in a request stream, parses
     * the request, and gets the path,
     * @param r Request
     */
    public HTTPRequest(String r) {
        request = r;
        validRequest = parse(request);
        path = getPath();

    }

    /**
     * @return boolean validRequest
     */
    public boolean isValidRequest() {
        return validRequest;
    }

    /**
     * @return String path
     */
    public String getPath() {
        return path;
    }

    /**
     * @description This method will take in a request, parse the
     * request for the file path, and return true or false if the
     * request is valid based on some requirements
     * @param request
     * @return validRequest
     */
    private boolean parse(String request) {
       String[] stringParts = getParsedRequest(request, REG_EX_DELIMINATERS);

       path = stringParts[1];
       File file = new File(path);

       if(stringParts.length >= 2 && stringParts[0] == "GET" && file.exists()){
           System.out.println("Received GET and file exists");
           validRequest = true;
           return validRequest;

       } else if (!file.exists()){
           System.out.println("file does not exist");
           validRequest = false;
           return validRequest;

       } else if(stringParts.length < 2){
           System.out.println("array has less than two values.");
           validRequest = false;
           return validRequest;

       } else if(stringParts[0] != "GET"){
           System.out.println("Request is not a get.");
           validRequest = false;
           return validRequest;

       } else {
           System.out.println("something went wrong in parse.");
           validRequest = false;
           return validRequest;
       }

    }

    /**
     * @description This method will take in a request, and a
     * delimiter, and return a String array of your webservers requests
     * in order to have it more parse-able.
     * @param request
     * @param regExDelimiters
     * @return
     */
    public String[] getParsedRequest(String request, String regExDelimiters) {
        return request.split(regExDelimiters);
    }
}
