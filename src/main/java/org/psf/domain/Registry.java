package org.psf.domain;

import org.springframework.data.annotation.Id;

public class Registry {

	@Id
    private long id;
    
    private String name;
        
    private String host;
    
    private int port;
    
    private String protocol;

    public Registry() {
    }
    
    public Registry(long id, String name, String host, int port, String protocol) {
    	this.id = id;
    	this.name = name;
    	this.host = host; 
    	this.port = port;
    	this.protocol = protocol;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
    	this.id = id;
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