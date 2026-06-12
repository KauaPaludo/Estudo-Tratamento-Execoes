package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

import model.execption.DomainException;
import model.entities.Reservation;


public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation reservation;

        try{
            System.out.println("Enter Room Number:");
            int roomNumber = sc.nextInt();
            sc.nextLine(); // Consume the newline
            System.out.println("Enter Check-in date (dd/MM/yyyy):");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Enter Check-out date (dd/MM/yyyy):");
            Date checkOut = sdf.parse(sc.next());
            reservation = new Reservation(checkIn, checkOut, roomNumber);
            System.out.println("Reservation: " + reservation);

            System.out.println("\nEnter new Check-in date (dd/MM/yyyy):");
            checkIn = sdf.parse(sc.next());
            System.out.println("Enter new Check-out date (dd/MM/yyyy):");
            checkOut  = sdf.parse(sc.next());
            reservation.updateDates(checkIn,checkOut);
            System.out.println("Updated Reservation: " + reservation);
        }catch (ParseException e){
            System.out.println("IVALIDE DATE FORMAT");;
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}
