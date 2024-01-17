package org.sid.securityservice.Web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class customerRestAPITest {
    @GetMapping("/api")
    Map<String,Object>customer(){
        return Map.of("name","hassan","email","hassan@gmail.com");
    }
}
