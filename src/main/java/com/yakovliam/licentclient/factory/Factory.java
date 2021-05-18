package com.yakovliam.licentclient.factory;

public interface Factory<T, R> {

    /**
     * Builds and r from a t
     *
     * @param t t
     * @return r
     */
    R build(T t);
}
