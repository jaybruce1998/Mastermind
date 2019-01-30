import java.util.*;
public class Mastermind
{
   static Scanner input=new Scanner(System.in);
   public static void main(String[] args)
   {
      String code="", guess;
      int ran, red=0, white;
      for(int i=0; i<4; i++)
      {
         ran=(int)(Math.random()*6)+1;
         code+=ran;
      }
      for(int i=0; i<10&&red<4; i++)
      {
         guess="";
         while(guess.length()!=4)
         {
            System.out.println("What would you like to guess?");
            guess=""+input.nextInt();
            if(guess.length()!=4)
               System.out.println(guess+" is not a valid guess.");
         }
         red=0;
         white=0;
         for(int j=0; j<4; j++)
         {
            if(guess.charAt(j)==code.charAt(j))
               red++;
            else
               if(guess.contains(""+code.charAt(j)))
                  white++;
         }
         System.out.println(guess+" Red: "+red+" White: "+white);
      }
      if(red>3)
         System.out.println("Congratulations! You guessed the code!");
      else
         System.out.println("You ran out of guesses! The actual code was "+code+".");
   }
}