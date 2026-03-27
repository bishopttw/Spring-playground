package Spring.cmd.Spring;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
public class GuessGame{
     
     Random random = new Random();
     private int randomNumber = random.nextInt(10) + 1;

     @GetMapping("/guess")
     public String showForm(){
         return "<html>" +
                "<head>" +
                "<style>" +
                    "body{background-color: #1a1a2e; height: 100vh; display: flex; align-items: center; justify-content: center; margin: 0; font-family: Poppins, sans-serif;}" +
                    ".main-box{background-color: skyblue; display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 1.5rem; padding: 3rem; border-radius: 16px; width: 400px;}" +
                    "h2{font-size: 1.5rem; margin: 0; text-align: center; color: #1a1a2e;}" +
                    ".box{display: flex; align-items: center; justify-content: center; gap: 1rem;}" +
                    "input{padding: 0.8rem 1rem; border: none; border-radius: 8px; font-size: 1rem; width: 130px;}" +
                    "button{padding: 0.8rem 1.5rem; background-color: #1a1a2e; color: white; border: none; border-radius: 6rem; cursor: pointer; font-size: 1rem;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                    "<div class='main-box'>" +
                        "<h2>Guess a number between 1 and 10</h2>" +
                        "<form action='/guess/check' method='get' class='box'>" +
                            "<input type='number' name='UserGuess' placeholder='Your guess'/>" +
                            "<button type='submit'>Check</button>" +
                        "</form>" +
                    "</div>" +
                "</body></html>";
     }

     @GetMapping("/guess/check")
     public String guess(@RequestParam int UserGuess){
         
         String sharedStyle = "<html><head><style>" +
             "body{ background-color:#1a1a2e; font-family: Poppins, sans-serif; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 2rem; margin: 0;}" +
             ".wrong{background-color: #dc3545; color: white; padding: 2rem 3rem; border-radius: 12px; text-align: center;}" +
             ".correct{background-color: #28a745; color: white; padding: 2rem 3rem; border-radius: 12px; text-align: center;}" +
             ".box{display: flex; align-items: center; gap: 1rem;}" +
             "input{padding: 0.8rem 1rem; border: none; border-radius: 8px; font-size: 1rem; width: 130px;}" +
             "button{padding: 0.8rem 1.5rem; background-color: skyblue; color: #1a1a2e; border: none; border-radius: 6rem; cursor: pointer; font-size: 1rem; font-weight: bold;}" +
             "a{background-color: white; color: #1a1a2e; padding: 0.8rem 2rem; border-radius: 6rem; text-decoration: none; font-weight: bold;}" +
             "</style></head><body>";

         if (UserGuess < randomNumber) {
             return sharedStyle +
                    "<div class='wrong'><h2>Too low! Try again!</h2></div>" +
                    "<form action='/guess/check' method='get' class='box'>" +
                        "<input type='number' name='UserGuess' placeholder='Your guess'/>" +
                        "<button type='submit'>Check</button>" +
                    "</form>" +
                    "</body></html>";

         } else if (UserGuess > randomNumber) {
             return sharedStyle +
                    "<div class='wrong'><h2>Too high! Try again!</h2></div>" +
                    "<form action='/guess/check' method='get' class='box'>" +
                        "<input type='number' name='UserGuess' placeholder='Your guess'/>" +
                        "<button type='submit'>Check</button>" +
                    "</form>" +
                    "</body></html>";

         } else {
             return sharedStyle +
                    "<div class='correct'>" +
                        "<h2>🎉 Correct! You got it right!</h2>" +
                        "<a href='/guess/new'>Play Again</a>" +
                    "</div>" +
                    "</body></html>";
         }
     }

     @GetMapping("/guess/new")
     public String newGame(){
         randomNumber = random.nextInt(10) + 1;
         return "<html><head><style>" +
                "body{background-color: #1a1a2e; height: 100vh; display: flex; flex-direction: column; align-items: center; justify-content: center; gap: 2rem; margin: 0; font-family: Poppins, sans-serif;}" +
                "a{background-color: skyblue; color: #1a1a2e; padding: 1rem 2rem; border-radius: 6rem; text-decoration: none; font-weight: bold; font-size: 1.2rem;}" +
                "h2{color: white;}" +
                "</style></head><body>" +
                "<h2>New game started! Good luck! 🎮</h2>" +
                "<a href='/guess'>Play Now</a>" +
                "</body></html>";
     }
}