package ticket;

import java.util.Scanner;

import java.util.Stack;

import java.util.InputMismatchException;

class Passenger

{

int ticketNo;

String name;

int seatNo;

Passenger next;



Passenger(int t, String n, int s) 

{

    ticketNo = t;

    name = n;

    seatNo = s;

    next = null;

}

}

public class Ticket1

{

Passenger head = null;

Stack<Integer> cancelled = new Stack<>();



int seats[] = new int[10];

int ticket = 1;



void book(String name) 

{

    for (int i = 0; i < seats.length; i++) 

    {

        if (seats[i] == 0) 

        {

            seats[i] = 1;



            Passenger p = new Passenger(ticket, name, i + 1);



            if (head == null)

                head = p;

            else 

            {

                Passenger Cnode = head;



                while (Cnode.next != null)

                    Cnode = Cnode.next;



                Cnode.next = p;

            }



            System.out.println("Ticket Booked");

            System.out.println("Ticket No: " + ticket);

            System.out.println("Seat No: " + (i + 1));



            ticket++;

            return;

        }

    }



    System.out.println("No Seats Available");

}



void cancel(int tno) 

{

    Passenger Cnode = head;

    Passenger prev = null;



    while (Cnode != null) 

    {

        if (Cnode.ticketNo == tno) 

        {

            seats[Cnode.seatNo - 1] = 0;



            cancelled.push(tno);



            if (prev == null)

                head = Cnode.next;

            else

                prev.next = Cnode.next;



            System.out.println("Ticket Cancelled");

            return;

        }



        prev = Cnode;

        Cnode = Cnode.next;

    }



    System.out.println("Ticket Not Found");

}



void display() 

{

    Passenger Cnode = head;



    if (Cnode == null) 

    {

        System.out.println("No Bookings");

        return;

    }



    while (Cnode != null) 

    {

        System.out.println("Ticket: " + Cnode.ticketNo +

                " Name: " + Cnode.name +

                " Seat: " + Cnode.seatNo);



        Cnode = Cnode.next;

    }

}



public static void main(String args[]) 

{

    Scanner sc = new Scanner(System.in);

    Ticket1 obj = new Ticket1();



    int ch = 0;



    do 

    {

        System.out.println("\n1.Book Ticket");

        System.out.println("2.Cancel Ticket");

        System.out.println("3.Display Passengers");

        System.out.println("4.Exit");



        try

        {

            System.out.print("Enter choice: ");

            ch = sc.nextInt();



            switch (ch) 

            {



                case 1:

                    System.out.print("Enter Name: ");

                    String name = sc.next();

                    obj.book(name);

                    break;



                case 2:

                    try

                    {

                        System.out.print("Enter Ticket No: ");

                        int t = sc.nextInt();

                        obj.cancel(t);

                    }

                    catch(InputMismatchException e)

                    {

                        System.out.println("Invalid ticket number!");

                        sc.next();

                    }

                    break;



                case 3:

                    obj.display();

                    break;



                case 4:

                    System.out.println("Exiting...");

                    break;



                default:

                    System.out.println("Invalid choice!");

            }

        }

        catch(InputMismatchException e)

        {

            System.out.println("Invalid input! Enter numbers only.");

            sc.next();

            ch = 0;

        }



    } while (ch != 4);

}

}