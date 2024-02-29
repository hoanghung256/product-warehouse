package com.app.models;

import com.app.Configuration;

/**
 *
 * @author hoang hung
 */
public class StatusDto {
    /**
     * Status of response
     * 0: request preform successfully 
     * 1: request preform failed
     */
    private int status;
    /**
     * Message of response
     */
    private Object result;

    public StatusDto(int status, Object result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return Configuration.gson.toJson(this);
    }
}
