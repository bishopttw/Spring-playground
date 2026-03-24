package Spring.cmd.Spring;

import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController

public class GuessGame{
     
     Random random = new Random();
     private int randomNumber = random.nextInt(10) + 1;



@GetMapping("/guess")
   public String showForm(){
   
       return "<html><body>" + 
                 "<h2>Guess a number between 1 and 10</h2>" +
                 "<form action='/guess/check' method='get'>" +
                    "<input type='number' name='UserGuess' placeholder='Enter your guess'/>" +
                    "<button type='submit'>Check Guess</button>" +
                 "</form>" +
                 "</body></html>";
 }




     @GetMapping("/guess/check")
     public String guess(@RequestParam int UserGuess){
          
          if (UserGuess < randomNumber) {
		return "<h2>Sorry you didn't get it. Try again!</h2>" +                  
                       "<form action='/guess/check' method='get'>" +
                            "<input type='number' name='UserGuess' placeholder='Enter your guess'/>" +
                            "<button type='submit'>Check Guess</button>" +
                       "</form>";

			} else if (UserGuess > randomNumber) {
		return "<h2>Sorry you didn't get it. Try again!</h2>" +                  
                       "<form action='/guess/check' method='get'>" +
                            "<input type='number' name='UserGuess' placeholder='Enter your guess'/>" +
                            "<button type='submit'>Check Guess</button>" +
                       "</form>";

			} else {
				return "Correct You got it right.";
			}

 }


  @GetMapping("/guess/new")
  public String newGame(){
     randomNumber = random.nextInt(10) + 1;
     
    return "Game refreshed, You can play again";
}
}