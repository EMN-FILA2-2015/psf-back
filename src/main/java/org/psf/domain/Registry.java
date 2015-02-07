package org.psf.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="registries")
public class Registry {

	@Id
    private long id;
    
	@NotNull
	@NotEmpty
    private String name;
        
    private String host;
    
    @Range(min = 0, max = 65535)
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