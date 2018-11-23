package com.umpay.eosrpc4j.exceptions;

public class KeyException extends EOSException {

    public KeyException(String message) {
        super(message);
    }

    public KeyException(String message, Throwable cause) {
        super(message, cause);
    }

}
