package com.umpay.eosrpc4j.exceptions;

public class SignatureException extends EOSException {

    public SignatureException(String message) {
        super(message);
    }

    public SignatureException(String message, Throwable cause) {
        super(message, cause);
    }

}
