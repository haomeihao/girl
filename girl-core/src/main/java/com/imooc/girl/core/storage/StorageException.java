package com.imooc.girl.core.storage;

/**
 * Created by hmh on 2017/8/2.
 */
public class StorageException extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
