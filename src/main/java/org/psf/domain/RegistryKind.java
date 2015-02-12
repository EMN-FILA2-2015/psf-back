package org.psf.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class RegistryKind {

	@NotNull
	@NotEmpty
    private String name;
        
    private String logo;
    
    private String host;
    
    @Range(min = 0, max = 65535)
    private int port;
    
    private boolean isPublic;

    public RegistryKind() {
    }
 
    public RegistryKind(String name, String logo, String host, int port, boolean isPublic) {
		this.name = name;
		this.logo = logo;
		this.host = host;
		this.port = port;
		this.isPublic = isPublic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
}