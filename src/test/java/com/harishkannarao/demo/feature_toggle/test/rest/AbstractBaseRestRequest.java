package com.harishkannarao.demo.feature_toggle.test.rest;

public abstract class AbstractBaseRestRequest<T extends AbstractBaseRestRequest> {
    protected final String testUrl;
    protected String path;

    public AbstractBaseRestRequest(String testUrl) {
        this.testUrl = testUrl;
    }

    public T path(String path) {
        this.path = path;
        return (T) this;
    }
}
