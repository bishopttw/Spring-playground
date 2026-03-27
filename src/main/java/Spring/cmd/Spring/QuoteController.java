package Spring.cmd.Spring;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import com.github.javafaker.Faker;

@RestController

public class QuoteController{
       
       Faker faker = new Faker();


   @GetMapping("/quotes")
   public String showPage(){
       return "<html><body>" +
              "<style> " +
                 " body{background-color: #1a1a2e; " +
                      " color: #ffffff; " +
                      " height: 100vh; " +
                      " display: flex; " +
                      " flex-direction: column; " +
                      " align-items: center; " +
                      " justify-content: center; " +
                      " gap: 2rem; " +
                  "}"+
                   " h1{ " +
                      " color: #ffffff; " +
                      " font-size: 3rem; " + 
                   " }" +
                   "button{ " +
                     " background-color: #28a745; " +
                     " color : white; " +
                     " padding: 1rem 2rem; " +
                     " border-radius: 6rem; " +
                     " border: 3px solid #28a745; " +
                     " cursor: pointer; " +
                   "}" +
                   
              "</style>" +
              
             "<h1> DAILY INSPIRATION </h1>" +
             "<form action='/quotes/generate' method='get'>" +
                   "<button type='submit'>Generate Quotes</button>" +
              "</form>" +

              "</body></html>";    
}
  

   @GetMapping("/quotes/generate")
   public String generateQuotes(){
      List<String> myList = new ArrayList<>();
      for(int i = 0; i < 100; i++){
        myList.add(faker.chuckNorris().fact());  
      }

      String html = " <html><body>" +
                    " <style>" +
		    " body{background-color: #1a1a2e; color: white; font-family: Arial, sans-serif; padding: 2rem; }" +
                    " h1{ color: #28a745; text-align: center; font-size: 2rem; margin-bottom: 2rem; }" +
		    " .card{background-color: #16213e; border: 2px solid #28a745; border-radius: 8px; padding: 1rem; margin-bottom: 1rem; color: white; }" +
                    " .back-btn{ display: inline-block; background-color: #28a745; color: white; padding: 0.8rem 2rem; border-radius: 6rem; text-decoration: none; margin-bottom: 2rem;}" +
		    " </style>" +
 		    " <a class='back-btn' href='/quotes'>&larr; Back</a>" +
                    " <h1> THE QUOTES</h1> " ;
                    

         for(int i = 0; i < myList.size(); i++){
             html += "<div class='card'>" + "<p>" + (i + 1) + ". " + myList.get(i) + "</p>" + "</div>";
         }
         html += " </body></html>" ;
     return html;
  }
}