/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpooling_package;
/**
 * Imported Packages from Java util package and io package
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.IOException;

/**
 *
 * @author zezo
 */
public class CarPooling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creating passenger
        passengerData passenger[]=new passengerData[5];
        
        passenger[0]=new Subscriber();
        passenger[1]=new Subscriber();
        passenger[2]=new nonSubscriber();
        passenger[3]=new Subscriber();
        passenger[4]=new nonSubscriber();
        
        ArrayList<routeDestination>Routes=new ArrayList<routeDestination>();
        routeDestination Route;
        
        //StartAdress - EndAdress - Length
        Route=new routeDestination("Giza","El-shohada","Short Way");
        Routes.add(Route);
        Route=new routeDestination("Giza","El-Menia","Normal Way");
        Routes.add(Route);
        Route=new routeDestination("Giza","Loxur","Long Way");
        Routes.add(Route);
        
        ArrayList<carSystem>Cars=new ArrayList<carSystem>();
        carSystem Car;
        
        // numberOfTripsPerDay - routeDestination Route - maxCapactityPerTrip - driverName
        Car=new carSystem(20,Routes.get(0),10,"Hassan Aly");
        Cars.add(Car);
        Car.displayData();
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        Car=new carSystem(6,Routes.get(1),14,"Gamal Mostafa");
        Cars.add(Car);
        Car.displayData();
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        Car=new carSystem(2,Routes.get(2),20,"Said Jamel");
        Cars.add(Car);
        Car.displayData();
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
        //--------------------------------------------------------------//
        
        //(ticket #1)
        
        passenger[0].reserveTickets(Cars.get(0));
        passenger[0].Ticket.displayData();
        passenger[0].subscribeAFrequentPassenger(70,40);
        
         for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
         //--------------------------------------------------------------//
         
         //(ticket #2)
        passenger[1].searchForRoutes("Giza","Loxur");
        passenger[1].passengerIssue("");
        
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
         //--------------------------------------------------------------//
         
        //(ticket #3)
        passenger[3].searchForRoutes("Alex","Cairo");
        passenger[3].passengerIssue("Route from Giza to Loxur was so fast and not confortble!!");
         for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
         //--------------------------------------------------------------//
         
        //(ticket #4)
        passenger[2].reserveTickets(Cars.get(0));
        passenger[2].unsubscribeAFrequentPassenger();
        passenger[2].Ticket.displayData();

         for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
         //--------------------------------------------------------------//
         
        //(ticket #5)
        //the more older your the less price you will get
        passenger[4].reserveTickets(Cars.get(2));
        passenger[4].subscribeAFrequentPassenger(25,80);
        passenger[4].Ticket.displayData();//After subscribe
         for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
         //--------------------------------------------------------------//
         
        //(ticket #6)
        //the more older your the less price you will get
        passenger[2].reserveTickets(Cars.get(1));
        passenger[2].subscribeAFrequentPassenger(95,100);
        passenger[2].Ticket.displayData();//After subscribe
         for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*==*");   
        }
        for(int i=0;i<20;++i){
            System.out.print((i==19)?"\n":"*--*");   
        }
        
         //--------------------------------------------------------------//
    }
    
}

/** This class is provided to route destination details */
class routeDestination {
    //private varibles
    private String startLocation;
    private String endDestination;
    private String routeLength;
    
    /**Linked list object for start point of route to use in search on route*/
    public static LinkedList<String> startPoint = new LinkedList<String>();
    
    /**Linked list object for end point of route to use in search on route*/
    public static LinkedList<String> endPoint = new LinkedList<String>();
    
    /**
     * Default Constructor OF Route Destination Details
     * 
     * @param startLocation
     * @param endDestination
     * @param routeLength 
     */
    public routeDestination(String startLocation,String endDestination,String routeLength)
    {
        this.startLocation = startLocation;
        this.endDestination = endDestination;
        this.routeLength=routeLength;
        startPoint.add(startLocation);
        endPoint.add(endDestination);
    }
    /**
     * A Final Method 
     * 
     * @return get start location of trip
     */
    public final String getStartLocation() {
        return startLocation;
    }
    /**
     * A Final Method
     * 
     * @return get end of destination of trip  
     */
    public final String getEndDestination() {
        return endDestination;
    }
    /**
     * A Final Method
     * 
     * @return the length of route in the trip
     */
    public final String getRouteLength() {
        return routeLength;
    }
    
}

/**The Car System Class to defined the details*/
class carSystem {
    
   public int carCode;
   //Static Varible
   private static int codeCounter = 0;
   private int numberOfTripsPerDay;
   private routeDestination Route;
   private int maxCapactityPerTrip;
   private String driverName;
   
   /**
    * Default Constructor to car system details
    * 
    * @param numberOfTripsPerDay
    * @param Route
    * @param maxCapactityPerTrip
    * @param driverName 
    */
   public carSystem(int numberOfTripsPerDay,routeDestination Route,int maxCapactityPerTrip,String driverName){
       this.numberOfTripsPerDay = numberOfTripsPerDay;
       this.Route = Route;
       this.maxCapactityPerTrip = maxCapactityPerTrip;
       this.driverName = driverName;
       
       codeCounter++;
       this.carCode = codeCounter;
   }
     // Static Metod
    /**
     * @return returns code counter
     */
    public static int getCodeCounter() {
        return codeCounter;
    }
    /**
     * @return returns number of trips per day
     */
    public int getNumberOfTripsPerDay() {
        return numberOfTripsPerDay;
    }
    /**
     * @return returns route
     */
    public routeDestination getRoute() {
        return Route;
    }
    /**
     * @return returns maximum capacity per trip
     */
    public int getMaxCapactityPerTrip() {
        return maxCapactityPerTrip;
    }
    /**
     * @return returns driver name
     */
    public String getDriverName() {
        return driverName;
    }
   
    public void displayData()
    {   
        System.out.println("\t\t\tThis is Car Details");
        System.out.println("The Car Code: " + carCode);
        System.out.println("Car's Driver Name is " + driverName);
        System.out.printf("Route:(From %s - To %s)\n" ,Route.getStartLocation(),Route.getEndDestination());
        System.out.println("Car's Capasity Per Trip : " + maxCapactityPerTrip);
        System.out.println("The Car Trips Per Day : " + numberOfTripsPerDay);   
    }
}

/**The booking ticket System Class to defined the details*/
class bookingTicketsSystem {
    
    private carSystem Car;
    private double ticketPrice;
    private int ticketCode;
    //Static Varible
    private static int countCode;
    //Static Varible
    public static double Discount;
    public boolean checkDiscounte;
    /**
     * Default Constructor for booking ticket from the system
     * @param Car 
     */
    bookingTicketsSystem(carSystem Car)
    {
        this.Car = Car;
        countCode++;
        ticketCode=countCode;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    
    //Private Method
    private void calcuateTotalPaymentOfTicket()
    {
           switch (Car.getRoute().getRouteLength())
            {
                case "Long Way":
                    ticketPrice=150;
                    break;
                case "Normal Way":
                    ticketPrice=75;
                    break;
                default:
                    ticketPrice=35;
                    break;
            }
           
           if(checkDiscounte)
           {
               //Calculated Data Member
               ticketPrice=ticketPrice-(ticketPrice*Discount);
           } 
    }
    
    public void displayData()
    {
                calcuateTotalPaymentOfTicket();
                System.out.println("The Ticket Code: " + ticketCode);
                System.out.println("The Car Code: " + Car.carCode);
                System.out.println("Car's Driver Name is : " + Car.getDriverName());
                System.out.printf("Route:(From %s - To %s)\n" ,Car.getRoute().getStartLocation(),Car.getRoute().getEndDestination());
                System.out.printf("The Price of trip %.1f Pounds.\n" , ticketPrice); 
   }   
}

/**The Passenger data is an abstract Class to defined the details*/

abstract class passengerData {
    protected bookingTicketsSystem Ticket;
    protected ArrayList<bookingTicketsSystem> Tickets;
    protected String Report;
    protected boolean checkSubscription;
    //Final variable
    protected final double factorizationofSubscribe;
    
    /**
     *Default Passenger Data constructor.
    */
    public passengerData() {
        Tickets=new ArrayList<bookingTicketsSystem>();
        factorizationofSubscribe=1500;
    }
    
    //Abstract Method
    public abstract void reserveTickets(carSystem Car);
    //Final Method
    /**
     * Method to search for route
     * 
     * @param startPoint
     * @param endPoint 
     */
    public final void searchForRoutes(String startPoint,String endPoint)
    {
        boolean isFound= false;
        for(String string:routeDestination.startPoint)
           if(string.equals(startPoint))
               for(String s:routeDestination.endPoint)
                     if(s.equals(endPoint))
                         isFound=true;
        if(isFound)
        {
            System.out.println("Route is found Successufly.");   
        }
        else
           System.err.println("This Route is not Exists!!"); 
    }
    
    //Final Method
    /**
     * This Method Calculate Fees Check subscription
     * @param passengerAge
     * @param numberOfTripsPerDay 
     */
    public final void subscribeAFrequentPassenger(int passengerAge,int numberOfTripsPerDay){
        boolean Worning=false;
        try{
            if(checkSubscription == true){//If you are already Subscriber
                Worning = true;
            throw new InvalidInputException("You are already a Subscriber in our System!!");
            }
        }catch(InvalidInputException ex){
            System.err.println("Something Wrong:"+ex.getMessage());
        }
        
        if(!Worning){
                    double Fees=1;
                    Fees = (numberOfTripsPerDay/passengerAge)*(factorizationofSubscribe);
                    checkSubscription = Ticket.checkDiscounte =true;
                    System.out.println("Your Subscribtion has been maded Successfuly!!");
                    System.out.printf("Your Fees is %.1f Pounds\n",Fees);
                    System.out.println("We hope you enjoy with us this year, And Thank You!!!  ");

        }
        
    }
    
    //Final Method
    /**
     *This Method To check Subscription of nonSubscriper
     */
    public final void unsubscribeAFrequentPassenger(){
        boolean Worning=false;
        try{
            if(checkSubscription==false){//YOU are not a Subscriber
            Worning=true;
            throw new InvalidInputException("You are Already a nonsubscriber in Our System!!");
            }
        }catch(InvalidInputException ex){
            System.err.println("Something Wrong:"+ex.getMessage());
        }
        if(!Worning){
            checkSubscription= Ticket.checkDiscounte =false;
            System.out.println("Your now aren't a Subscription in our System !!!  ");
            System.out.println("We hope you find this System Good, and Thank you !!!  ");
        } 
    }
    //Final Method
    /**
     * This Method To make A Report Complaint.
     * 
     * @param reportComplaint 
     */
    public final void passengerIssue(String reportComplaint){
        boolean Worning=false;
        try{
            if(reportComplaint.equals("")){//YOU are not a Subscriber
                Worning=true;
            throw new IOException("This message doesn't consiste any Issue!!");//InvalidInputMessage
            }
        }catch(IOException ex){
            System.err.println("Something Wrong:"+ex.getMessage());      
        }
        if(!Worning){
            this.Report = reportComplaint;
            System.out.println("Your Issue has been sented succesfuly!! ");
        }
        
    }

}

/**A class to defined error massage to the user*/
class InvalidInputException extends Exception{
    /**
     * Default Constructor
     * 
     * @param Error 
     */
    public InvalidInputException(String Error)
    {
        super(Error);
    }
}

/**Child Class that Represent discount for Subscriber passengers and Some details */
class Subscriber extends passengerData{
         private final double Discount;
         public Subscriber(){
         Discount=0.5;
         Ticket.Discount=this.Discount;
         checkSubscription=true;
     } 
     
     @Override
        public void reserveTickets(carSystem Car){
        Ticket = new bookingTicketsSystem(Car);
        Tickets.add(Ticket);
        Ticket.checkDiscounte=(checkSubscription)?true:false;
        
        System.out.println("The Ticket is reserved Sucssfully !!");
        System.out.println("As A Subscriber Passenger You have Discount 50% on ticket Price!!");
     }
    }
/**Child class that Represent un subscribe a frequent Passenger Details*/
class nonSubscriber extends passengerData{
    public nonSubscriber(){
         checkSubscription=false;
     }
    @Override
    public void reserveTickets(carSystem Car){
        Ticket = new bookingTicketsSystem(Car);
        Tickets.add(Ticket);
        Ticket.checkDiscounte=(checkSubscription)?true:false;
        System.out.println("The Ticket is Reserved Sucssfully !!");
    }
    
    public void rewardToPassenger(carSystem Car){
        reserveTickets(Car);
        
     }
}

/**Interface that represent the different types of reward*/
interface rewardToPassenger{
    public void displayRewardDitails();
}
/**child class that represent normal reward for passenger */
class normalReward implements rewardToPassenger{
@Override

/**child class that represent normal reward for passenger */
public void displayRewardDitails(){
    System.out.println("You rewared with us a ticket for second trip for free in the same way.!!");
}
}

/**child class that represent spacial reward */
class spacialReward implements rewardToPassenger{
@Override
public void displayRewardDitails(){
    System.out.println("You rewared with us a two tickets for two trips for free in any way!!");
}
}

