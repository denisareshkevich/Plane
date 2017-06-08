package com.epam.oreshkevich.exeption;

/**
 * Created by Denis Areshkevich on 30.05.2017.
 */
public class CanNotReadFileException extends Exception {

    public CanNotReadFileException() {
    }

    public CanNotReadFileException(String message) {
        super(message);
    }

    public CanNotReadFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CanNotReadFileException(Throwable cause) {
        super(cause);
    }
}
