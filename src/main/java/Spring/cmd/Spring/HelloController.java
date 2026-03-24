package Spring.cmd.Spring;

import org.springframework.web.bind.annotation.*;
import java.util.*;
//import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{

     @GetMapping("/")
     public String sayHello(){
           return "<h1>Welcome to NIIT Semseter 3!</h1><p>Your Spring Boot Server is Officially Live.</p>";
     }

     @GetMapping("/api/status")
     public Map<String, Object> getStatus(){
      Map<String, Object> task = new HashMap<>();
     task.put("status", "Success");
     task.put("Instructor", "Wisdom Amaju");
     task.put("message", "The map task is working perfectly");
     return task;
  }
}