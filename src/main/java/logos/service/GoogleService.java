package logos.service;

import java.util.List;

public interface GoogleService {
    
	String createGoogleAuthorizationURL();
    
    List<String> createGoogleAccessToken(String code);
	
}
