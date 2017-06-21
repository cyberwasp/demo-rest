package ru.cwasp.demo.rest.resteasy;

import java.io.Serializable;

public class ResteasyExampleException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public ResteasyExampleException() {
        super("AAA!!!!");
    }

}