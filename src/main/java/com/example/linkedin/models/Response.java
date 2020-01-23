package com.example.linkedin.models;

public class Response {
    private Long id;
    private String message;
    private String name;

    public Response(Long id, String message, String name) {
        this.id = id;
        this.message = message;
        this.name = name;
    }

    public Response(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
