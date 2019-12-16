package com.netcracker.reflection;


@SuppressWarnings("serial")
public class InjectorException extends Exception{
    InjectorException(Exception exep) {
        super(exep.getMessage());
    }
}
