package logos.service;

import java.util.List;

public interface FacebookService {
    
	String createFacebookAuthorizationURL();
    
    List<String> createFacebookAccessToken(String code);
	
}

