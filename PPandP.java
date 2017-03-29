// Name: Sabrina Aravena

import java.util.Scanner;  // Needed for Scanner class

public class PPandP
{
  public static void main(String[] args)
  {
    // intializes variables to zero
    int customerInput = 0;
    int memberInput = 0;
    int optionInput = 0;
    int plPizzaUpdate = 0;
    int peppPizzaUpdate = 0;
    int cherryPieUpdate = 0;
    int charmOrderUpdate = 0;
    double payInput = 0;

    Scanner scanInput = new Scanner(System.in);

    do
    {
      System.out.println("\nWelcome to Pies, Pies and Pis!\n");
      System.out.print("Is there a customer in line?  (Enter 1 if YES, and 2 if NO) ");

      // checks for wrong intial input
      if(scanInput.hasNextInt())
      {
        customerInput = scanInput.nextInt();

        if (customerInput == 1)  //executes if customer is there
        {
          System.out.print("Are you a Pie Card member? (Enter 1 if YES and 2 if NO) ");
          memberInput = scanInput.nextInt();

          if (memberInput == 1)  // executes if customer is a pie card member
          {
            System.out.println("\nWelcome back, Pie Card holder!\n");
            System.out.println("For being a member, you will receive:");
            System.out.println("-Pepperoni pizza for the price of plain\n" +
                               "-$0.25 off a slice of cherry pie\n" +
                               "-$2.00 off a whole cherry pie\n" +
                               "-10% off each Pi charm\n\n");

            while(optionInput != 4)  // continuously loop until check out
            {
              System.out.print("\nPlease choose an option: \n");
              System.out.println("1)\tUpdate Pizza Order\n" +
                                 "2)\tUpdate Cherry Pie Order\n" +
                                 "3)\tUpdate Charm Order\n" +
                                 "4)\tCheck Out\n\n");

              optionInput = scanInput.nextInt();

              if (optionInput == 1)  // executes to update pizza order
              {
                System.out.println("\nHere is your current order: ");
                if (plPizzaUpdate == 0 && peppPizzaUpdate == 0)
                  System.out.println("No pizzas ordered.\n");
                else
                {
                  System.out.println(plPizzaUpdate + " plain pizzas.");
                  System.out.println(peppPizzaUpdate + " pepperoni pizzas.\n");
                }

                System.out.print("How many plain pizzas would you like for $10.00 each?: ");
                plPizzaUpdate = scanInput.nextInt();
                if (plPizzaUpdate < 0)
                {
                  System.out.println("Negative number taken as 0.\n");
                  plPizzaUpdate = 0;
                }

                System.out.print("How many pepperoni pizzas would you like for $10.00 each?: ");
                peppPizzaUpdate = scanInput.nextInt();
                if (peppPizzaUpdate < 0)
                {
                  System.out.println("Negative number taken as 0.\n");
                  peppPizzaUpdate = 0;
                }
              }
              else if (optionInput == 2)  // executs to update cherry pie order
              {
                System.out.println("\nHere is your current order: ");
                if (cherryPieUpdate == 0)
                System.out.println("No cherry pies ordered.\n");
                else
                {
                  System.out.println(cherryPieUpdate/6 + " whole cherry pies.");
                  System.out.println(cherryPieUpdate%6 + " cherry pie slices.\n");
                }

                System.out.println("How many cherry pie slices would you like for: ");
                System.out.println("\t$1.75 per slice\n" +
                                   "\t$8.00 per pie (6 slices)");
              cherryPieUpdate = scanInput.nextInt();
               if (cherryPieUpdate < 0)
                {
                  System.out.println("Negative number taken as 0.\n");
                  cherryPieUpdate = 0;
                }
              }
              else if (optionInput == 3)  // executes to update charm order
              {
                System.out.println("\nHere is your current order: ");
                if (charmOrderUpdate == 0)
                System.out.println("No gold Pi charms ordered.\n");
                else
                {
                  System.out.println(charmOrderUpdate + " Pi charms.");
                }

                System.out.print("How many Pi charms would you like for $45.00 each? ");
                charmOrderUpdate = scanInput.nextInt();
                if (charmOrderUpdate < 0)
                {
                  System.out.println("Negative number taken as 0.\n");
                  cherryPieUpdate = 0;
                }
              }
              else if (optionInput == 4)  // if customer checks out
              {
                System.out.println("Here is your subtotal: \n");

                double totalPlPizza;
                double totalPeppPizza;
                double totalWholePie;
                double totalSlicePie;
                double totalCharm;
                double subTotal;
                double bonusDiscount;
                double newSub;
                double tax;
                double total;

                // arithmetic to calculate total
                totalPlPizza = plPizzaUpdate * 10.00;
                totalPeppPizza = peppPizzaUpdate * 10.00;
                totalWholePie = cherryPieUpdate/6 * 8.00;
                totalSlicePie = cherryPieUpdate%6 * 1.75;
                totalCharm = charmOrderUpdate *45.00;
                subTotal = totalPlPizza + totalPeppPizza + totalWholePie + totalSlicePie + totalCharm;
                bonusDiscount = subTotal * 0.10;
                newSub = subTotal - bonusDiscount;
                tax = newSub * 0.07;

                // displys all items and total
                System.out.format(plPizzaUpdate + " plain pizzas\t\t\t$" + "%.2f%n", (double)totalPlPizza);
                System.out.format(peppPizzaUpdate + " pepperoni pizzas\t\t$" + "%.2f%n", (double)totalPeppPizza);
                System.out.format(cherryPieUpdate/6 + " whole cherry pies\t\t$" + "%.2f%n", (double)totalWholePie);
                System.out.format(cherryPieUpdate%6 + " cherry pie slices\t\t$" + "%.2f%n", (double)totalSlicePie);
                System.out.format(charmOrderUpdate + " Pi charms\t\t\t$" + "%.2f%n", (double)totalCharm);
                System.out.println("-------------------------------------------");
                System.out.format("Subtotal:\t\t\t$%.2f%n", (double)subTotal);

                // Additional bonus discount added if customer spends over $100
                if (subTotal > 100.00)
                {
                  System.out.print("Bonus discount of 10%\t\t");
                  System.out.format("-$%.2f%n", (double)bonusDiscount);
                  System.out.println("-------------------------------------------");
                  System.out.format("New subtotal:\t\t\t$%.2f%n", (double) newSub);
                }

                System.out.format("Tax:\t\t\t\t$%.2f%n", (double)tax);
                System.out.println("-------------------------------------------");

                if (subTotal > 100)
                {
                  total = newSub + tax;
                  System.out.format("Total:\t\t\t\t$%.2f%n", (double)total);
                }
                else
                {
                  total = subTotal + tax;
                  System.out.format("Total:\t\t\t\t$%.2f%n", (double)total);
                }

                // calculates customers change
                System.out.print("Please enter your payment amount: $");
                payInput = scanInput.nextDouble();

                if (payInput < total)
                {
                  System.out.println("Error: Not enough money.");
                  System.out.print("\nPlease enter your payment amount: $");
                  payInput = scanInput.nextDouble();
                }
                else if (payInput >= total)
                {
                  double change;
                  change = payInput - total;
                  System.out.format("Your change\t\t\t$%.2f%n", change);
                  System.out.println("Thanks for shopping with PPandP! Have a nice day!");
                }
                else
                {
                  System.out.println("Input Invalid");
                }

              }
              else
                System.out.println("Input Invalid: Please eneter a number from 1-4 for options.");
              }  // end while
            }  // end if memberInput
            // executes if customer is not a pie card memeber
            else if (memberInput == 2)
            {
              while(optionInput != 4)  // continuously loops until check out
              {
                System.out.print("\nPlease choose an option: \n");
                System.out.println("1)\tUpdate Pizza Order\n" +
                                   "2)\tUpdate Cherry Pie Order\n" +
                                   "3)\tUpdate Charm Order\n" +
                                   "4)\tCheck Out\n\n");

                optionInput = scanInput.nextInt();
                if (optionInput == 1)  // updates pizza order
                {
                  System.out.println("\nHere is your current order: ");
                  if (plPizzaUpdate == 0 && peppPizzaUpdate == 0)
                    System.out.println("No pizzas ordered.\n");
                  else
                  {
                    System.out.println(plPizzaUpdate + " plain pizzas.");
                    System.out.println(peppPizzaUpdate + " pepperoni pizzas.\n");
                  }

                  System.out.print("How many plain pizzas would you like for $10.00 each?: ");
                  plPizzaUpdate = scanInput.nextInt();
                  if (plPizzaUpdate < 0)
                  {
                    System.out.println("Negative number taken as 0.\n");
                    plPizzaUpdate = 0;
                  }

                  System.out.print("How many pepperoni pizzas would you like for $10.00 each?: ");
                  peppPizzaUpdate = scanInput.nextInt();
                  if (peppPizzaUpdate < 0)
                  {
                    System.out.println("Negative number taken as 0.\n");
                    peppPizzaUpdate = 0;
                  }
                }
                else if (optionInput == 2)  // updates cherry pie order
                {
                  System.out.println("\nHere is your current order: ");
                  if (cherryPieUpdate == 0)
                  System.out.println("No cherry pies ordered.\n");
                  else
                  {
                    System.out.println(cherryPieUpdate/6 + " whole cherry pies.");
                    System.out.println(cherryPieUpdate%6 + " cherry pie slices.\n");
                  }

                  System.out.println("How many cherry pie slices would you like for: ");
                  System.out.println("\t$1.75 per slice\n" +
                                     "\t$8.00 per pie (6 slices)");
                   cherryPieUpdate = scanInput.nextInt();
                   if (cherryPieUpdate < 0)
                   {
                     System.out.println("Negative number taken as 0.\n");
                     cherryPieUpdate = 0;
                   }
                 }
                 else if (optionInput == 3)  // updates charm order
                 {
                   System.out.println("\nHere is your current order: ");
                   if (charmOrderUpdate == 0)
                   System.out.println("No gold Pi charms ordered.\n");
                   else
                   {
                     System.out.println(charmOrderUpdate + " Pi charms.");
                   }

                   System.out.print("How many Pi charms would you like for $45.00 each? ");
                   charmOrderUpdate = scanInput.nextInt();
                   if (charmOrderUpdate < 0)
                   {
                     System.out.println("Negative number taken as 0.\n");
                     cherryPieUpdate = 0;
                   }
                 }
                 else if (optionInput == 4)  // totals order
                 {
                   System.out.println("Here is your subtotal: \n");

                   double totalPlPizza;
                   double totalPeppPizza;
                   double totalWholePie;
                   double totalSlicePie;
                   double totalCharm;
                   double subTotal;
                   double bonusDiscount;
                   double newSub;
                   double tax;
                   double total;

                   // calculations for total
                   totalPlPizza = plPizzaUpdate * 10.00;
                   totalPeppPizza = peppPizzaUpdate * 12.00;
                   totalWholePie = cherryPieUpdate/6 * 10.00;
                   totalSlicePie = cherryPieUpdate%6 * 2.00;
                   totalCharm = charmOrderUpdate *50.00;
                   subTotal = totalPlPizza + totalPeppPizza + totalWholePie + totalSlicePie + totalCharm;
                   tax = subTotal * 0.07;
                   total = subTotal + tax;

                   // diaplys total
                   System.out.format(plPizzaUpdate + " plain pizzas\t\t\t$" + "%.2f%n", (double)totalPlPizza);
                   System.out.format(peppPizzaUpdate + " pepperoni pizzas\t\t$" + "%.2f%n", (double)totalPeppPizza);
                   System.out.format(cherryPieUpdate/6 + " whole cherry pies\t\t$" + "%.2f%n", (double)totalWholePie);
                   System.out.format(cherryPieUpdate%6 + " cherry pie slices\t\t$" + "%.2f%n", (double)totalSlicePie);
                   System.out.format(charmOrderUpdate + " Pi charms\t\t\t$" + "%.2f%n", (double)totalCharm);
                   System.out.println("-------------------------------------------");
                   System.out.format("Subtotal:\t\t\t$%.2f%n", (double)subTotal);
                   System.out.format("Tax:\t\t\t\t$%.2f%n", (double)tax);
                   System.out.println("-------------------------------------------");
                   System.out.format("Total:\t\t\t\t$%.2f%n", (double)total);

                   // Calculates customers change
                   System.out.print("Please enter your payment amount: $");
                   payInput = scanInput.nextDouble();

                   if (payInput < total)
                   {
                     System.out.println("Error: Not enough money.");
                     System.out.print("\nPlease enter your payment amount: $");
                     payInput = scanInput.nextDouble();
                   }
                   else if (payInput >= total)
                   {
                     double change;
                     change = payInput - total;
                     System.out.format("Your change\t\t\t$%.2f%n", change);
                     System.out.println("Thanks for shopping with PPandP! Have a nice day!");
                   }
                   else
                   {
                     System.out.println("Input Invalid");
                   }
                 }
                 else
                  System.out.println("Input Invalid: Please enter a number from 1-4 for options.");
                }  // end while
              }  // end if memberInput
              else
              {
                System.out.println("Invalid Input: Please enter 1 for YES or 2 for NO");
              }
        }
        else if (customerInput == 2)  // executes if customer is not there
        {
          System.out.println("NO CUSTOMERS\n");
        }
        else  // Prints an error message if customer does not enter 1 or 2
        {
          System.out.println("Input Invalid: Plesase enter 1 for YES or 2 for NO.");
        }
      }
      else  // Prints an error message if customer does not enter an integer
      {
        scanInput.next();
        System.out.println("Input Invalid: Please enter 1 for YES or 2 for NO.\n");
      }
    } while (customerInput != 2);  // end do-while
  }  // end main
}  // end PPandP
