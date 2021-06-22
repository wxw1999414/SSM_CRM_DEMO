package com.yc137.util;

public class ProjectException extends Exception{
    public ProjectException(){
        super();
    }

    private String message;
    public ProjectException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
