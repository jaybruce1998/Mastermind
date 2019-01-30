import java.util.*;
public class mastermindSolver
{
   static ArrayList<String> possibilities=new ArrayList<String>();
   static String guess="1122", temp, g;
   static int red=0, white, r, w;
   public static void editTemp(int i, int j)
   {
      if(i<1)
         temp=temp.substring(1);
      else
         temp=temp.substring(0, i)+temp.substring(i+1);
      if(j<1)
         g=g.substring(1);
      else
         g=g.substring(0, j)+g.substring(j+1);
   }
   public static boolean shouldRemove(int index)
   {
      g=guess;
      if(index>=possibilities.size())
         return false;
      temp=possibilities.get(index);
      r=0;
      w=0;
      for(int i=3; i>=0; i--)
         if(temp.charAt(i)==g.charAt(i))
         {
            r++;
            editTemp(i, i);
         }
      for(int i=0; i<g.length(); i++)
         while(i<g.length()&&temp.contains(""+g.charAt(i)))
         {
            w++;
            editTemp(temp.indexOf(""+g.charAt(i)), i);
         }
      return r!=red||w!=white;
   }
   public static void main(String[] args)
   {
      Scanner input=new Scanner(System.in);
      for(int a=1; a<7; a++)
         for(int b=1; b<7; b++)
            for(int c=1; c<7; c++)
               for(int d=1; d<7; d++)
                  possibilities.add(a+""+b+""+c+""+d);
      for(int i=0; i<10&&red<4; i++)
      {
         System.out.println("My guess is "+guess+".");
         System.out.println("How many red pegs are there?");
         red=input.nextInt();
         System.out.println("How many white pegs are there?");
         white=input.nextInt();
         for(int j=0; j<possibilities.size(); j++)
            while(shouldRemove(j))
               possibilities.remove(j);
         guess=possibilities.get((int)(Math.random()*possibilities.size()));
      }
      if(red>3)
         System.out.println("I guessed your number!");
      else
      {
         System.out.println("Your number could have been...");
         for(int i=possibilities.size()-1; i>=0; i--)
            System.out.println(possibilities.get(i));
      }
   }
}