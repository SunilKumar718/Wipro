package spring1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:datafile.properties")
public class ComponentClass {

    @Value("${URL}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public String getUrl() { 
    	return url; 
	}
    public String getusername() { 
    	return username; 
	}
    public String getPassword() { 
    	return password; 
	}
}
