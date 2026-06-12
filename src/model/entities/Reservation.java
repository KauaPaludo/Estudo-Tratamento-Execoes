package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer RoomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Date checkIn, Date checkOut,Integer RoomNumber) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.RoomNumber=RoomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Integer getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        RoomNumber = roomNumber;
    }
    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }
    public String updateDates(Date checkIn,Date checkOut,Date newCheckIn,Date newCheckOut){

        if(!newCheckIn.after(checkIn) || !newCheckOut.after(checkOut)){
            return "Error: New check-in and check-out dates must be after the original dates.";
        }else if (!newCheckOut.after(newCheckIn)) {
            return "Error: New check-out date must be after new check-in date.";
        }

        this.checkIn=checkIn;
        this.checkOut=checkOut;
        return "Dates updated successfully.";
    }

    @Override
    public String toString() {
        return "Room"+ RoomNumber + "Check-in: " + sdf.format(checkIn) + ", Check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
    }
}
