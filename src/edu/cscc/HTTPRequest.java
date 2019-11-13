package edu.cscc;


import java.io.File;

public class HTTPRequest {
    private String request;         // request string
    private String path;            // path to file
    private boolean validRequest;   // is request valid?


    public HTTPRequest(String r) {
        this.request = request;
        this.path = path;
        this.validRequest = validRequest;
    }

    public boolean isValidRequest() {
        return (validRequest);
    }

    public String getPath() {
        return (path);
    }

    private boolean parse(String r) {
       String parsedString = getPath();
       String delimiters = ("[\t\n?]") ;
       String[] stringParts = parsedString.split(delimiters);
       File file = new File(stringParts[1]);
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
}
