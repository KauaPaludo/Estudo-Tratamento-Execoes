package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import model.entities.Reservation;


public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation reservation;

        System.out.println("Enter Room Number:");
        int roomNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.println("Enter Check-in date (dd/MM/yyyy):");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Enter Check-out date (dd/MM/yyyy):");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error: Check-out date must be after check-in date.");
        } else {
            reservation = new Reservation(checkIn, checkOut, roomNumber);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter new Check-in date (dd/MM/yyyy):");
            Date newCheckIn = sdf.parse(sc.next());
            System.out.println("Enter new Check-out date (dd/MM/yyyy):");
            Date newCheckOut = sdf.parse(sc.next());

            if(!newCheckIn.after(checkIn) || !newCheckOut.after(checkOut)){
                System.out.println("Error: New check-in and check-out dates must be after the original dates.");
            }else if (!newCheckOut.after(newCheckIn)) {
                System.out.println("Error: New check-out date must be after new check-in date.");
            } else {
                reservation.updateDates(newCheckIn, newCheckOut);
                System.out.println("Updated Reservation: " + reservation);
            }
        }



        sc.close();
    }
}
