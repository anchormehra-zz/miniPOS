/*
 * Author:  Vikash Mehra
 * website: myothant.com
 * email:   myothant@myothant.com
 */
import java.util.Scanner;
public class POS{
    public static void main(String[] args){
        Scanner Goola=new Scanner(System.in);
        double p1=5.00;//Price of item 1;
        double p2=6.00;//Price of item 2;
        double p3=7.00;//Price of item 3;
        double p4=8.00;//Price of item 4;
        double p5=9.00;//Price of item 5;
        char a;
        int i0=0;
        double t0=0;
        double t1=0;
        double tax=.08; //Sale tax (.08 means 8%)
        double t2=0;
        double t3=0;
        double t4=0;
        double t5=0;
        double cupon=0;
        char l;
        double d=.1; // Discount (.1 means 10%)
        double fee=1; //Credit Card processing fee (in dollars) // No fee for 20$ or more before tax.
        
        do{
            System.out.println("Enter item number 1-5: ");
            i0=Goola.nextInt();
            switch(i0){
                case 1:t0=p1;   break;
                case 2:t0=p2;   break;
                case 3:t0=p3;   break;
                case 4:t0=p4;   break;
                case 5:t0=p5;   break;
                default :System.out.println("Invalid item");
            }
            t1+=t0;
            System.out.println("Want to add more items? Enter y for yes and n for no: ");
            a=Goola.next().charAt(0);
        }while(a=='y');
          
        int pm=0;
        do{
        System.out.println("Enter payment method (1 as cash and 2 as credit card): ");
        pm=Goola.nextInt();
    }while(pm<1 || pm>2);
        if(pm==1){
        System.out.println("Enter cupon credit (0 for no cupon) : ");
        cupon=Goola.nextDouble();
       //***************************************Revise      do{
        System.out.println("Loyal customer? (y for yes and n for no)");
        l=Goola.next().charAt(0);
       //***************************************Revise      }while(l != 'y' || l != 'n');
        if(l=='y'){
            t2=t1-(t1*d);
            t3=t2-cupon;
        }
        else if(l=='n'){
            t3=t1-cupon;
       }
       
     }
        else{
            System.out.println("Enter cupon credit (0 for no cupon) : ");
        cupon=Goola.nextDouble();
        //***************************************Revise     do{
        System.out.println("Loyal customer? (y for yes and n for no)");
        l=Goola.next().charAt(0);
       //***************************************Revise      }while(l != 'y' || l != 'n');
        if(l=='y'){
            t2=t1-(t1*d);
            t3=t2-cupon;
        }
        else if(l=='n'){
            t3=t1-cupon;
        
       }
     }
     if(cupon>0){
     System.out.println("Cupon credit: $"+cupon);
    }
     if(l=='y'){
         System.out.println("Discount: $"+(t1*d));
        }
     System.out.println("Total price before cupon applied: $"+t2);
        System.out.println("Total price before tax (cupon applied): $"+t3);
     if(pm==2){
         if(t3<20){
     System.out.println("Credit card processing fee: $1");
    }
    }
     t4=t3*tax;
     System.out.printf("Sales tax: $ %.2f",t4);
     System.out.println();
     if(pm==1){
     t5=t3+t4;
    }
    else{
        if(t3>=20){
            t5=t3+t4;
        }
        else{
            t5=t3+t4+fee;
        }
    }
     System.out.printf("Total price after tax: $ %.2f",t5);
     System.out.println();
     if(pm==1){
         System.out.println("Amount Paid: $");
         double am = Goola.nextDouble();
         double change=am-t5;
         System.out.printf("Change : $ %.2f",change);
    }
  }
}