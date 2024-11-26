package org.acme.exception;

public class DeviceNotFoundException extends Exception {

    public DeviceNotFoundException(String message)  {
        super(message);
    }
}
