package com.jp.exception;

public class BancoException extends RuntimeException {
    public BancoException(String message) {
        super("João Pedro's Bank: " + message);
    }
}
