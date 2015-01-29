package org.psf.domain;

public class Registry {

    private final long id;
    
    private String name;
        
    private String host;
    
    private int port;
    
    private String protocol;

    public Registry(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getHost() {
    	return host;
    }
    
    public void setHost(String host) {
    	this.host = host;
    }
    
    public int getPort() {
    	return port;
    }
    
    public void setPort(int port) {
    	this.port = port;
    }
    
    public String getProtocol() {
    	return protocol;
    }
    
    public void setProtocol(String protocol) {
    	this.protocol = protocol;
    }
    
}