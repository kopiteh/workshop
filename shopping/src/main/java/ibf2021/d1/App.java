package ibf2021.d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App 
{

    public static void main( String[] args )
    {
        System.out.println("Welcome to your shopping cart");

        List<String> cart = new ArrayList<>();
        
        Scanner scan = new Scanner(System.in);
        String prompt = scan.next();
        String wishlist = scan.nextLine();
        
        int n = 0;

        while (n==0) //This is to loop the programe until an "end" command is triggered.
        {  
            while (!prompt.startsWith("list") && !prompt.startsWith("delete") && !prompt.startsWith("add") && !prompt.startsWith("end"))
            
            {
                System.out.println("Please use only the following command: 'list', 'add' or 'delete'");
                prompt = scan.next();
                wishlist = scan.nextLine();
            }
            
            while (prompt.startsWith("list"))
            {
                if (cart.size()==0)
                {
                    System.out.println("Your cart is empty");
                }
                
                else
                {
                    int x = 1;
                    for (String i : cart)
                    {
                        System.out.println(x + ". " + i);
                        x = x+1 ; 
                    }
                }
                prompt = scan.next();
                wishlist = scan.nextLine();
            }

            while (prompt.startsWith("add")) //Add items 
            {
                //prompt = prompt.split(" ")[1].trim();
                String[] items = wishlist.trim().split(",");

                for (String x: items)
                {
                    if (cart.contains(x))
                        System.out.println("You have " + x + " in your cart.");
                    else
                    {
                        cart.add(x);
                        System.out.println(x + " added to cart.");    
                    }
                }

                prompt = scan.next();
                wishlist = scan.nextLine();
            }
            
            while (prompt.startsWith("delete"))
            {
                int y = Integer.valueOf(wishlist.trim());
                
                if (y > cart.size())
                {
                    System.out.println("Error. Invalid selection");
                    prompt = scan.next();
                    wishlist = scan.nextLine();
                }
                
                else 
                {
                    System.out.printf(cart.get(y-1) + " is removed.\n");
                    cart.remove(y-1);
                    prompt = scan.next();
                    wishlist = scan.nextLine();
                }
            }
            
            while (prompt.startsWith("end")) //End the loop
            {
                n = 1;
                System.out.println("Thank you see you again");
                break;
            }
        }
    }
}

      
           


  
