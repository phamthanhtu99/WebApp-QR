package App.Controller;

import App.DTO.Authentication.AuthenticationReponse;
import App.DTO.Authentication.AuthenticationRequest;
import App.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService UserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    @RequestMapping("/home")
    public String home(){
        return "hiji";
    }



    @RequestMapping(value = "/authentication",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getPassword(),authenticationRequest.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("sdsd",e);
        }
         final    UserDetails userDetails= UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt=jwtUtil.gennerateToken(userDetails);
        return  ResponseEntity.ok(new AuthenticationReponse(jwt));
        }
}
