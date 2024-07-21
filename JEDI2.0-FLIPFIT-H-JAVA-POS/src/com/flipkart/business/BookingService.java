package com.flipkart.business;

import com.flipkart.bean.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookingService {
    Scanner scanner = new Scanner(System.in);
    public void cancelslotbooking(String userid, GymCenter gymCenter, LocalDateTime st){
        CustomerService customerService=new CustomerService();
        Customer customer=customerService.customers.get(userid);
        for(pair<Booking, Boolean> bk:customer.getBookings()){
            if(bk.getFirst().getStarttime()==st){
                List<Booking> bookingList=null;
                Slot slot=null;
                for(Slot sl: gymCenter.getSlots()){
                    if(sl.getStarttime()==st){
                        slot=sl;
                        break;
                    }
                }
                if(bk.getSecond()){
                    for(Booking bsl:slot.getBookings()){
                        if(bsl.getUserID().equals(userid)){
                            slot.getBookings().remove(bsl);
                            slot.increaseCapacity();
                            break;
                        }
                    }
                }
                else{
                    for(Booking bsl:slot.getWaitings()){
                        if(bsl.getUserID().equals(userid)){
                            slot.getWaitings().remove(bsl);
                            break;
                        }
                    }
                }
                customer.getBookings().remove(bk);
                break;
            }
        }

    }
    public void bookSlot(String userid, GymCenter gymCenter, LocalDateTime st){

        List<Slot> slots=gymCenter.getSlots();
        Slot slot = null;
        for (Slot sl:slots){
            if(sl.getStarttime()==st){
                slot=sl;
                break;
            }
        }
        String bkid="0"+slot.getBookings().size()+1;
        Booking newbooking = new Booking(userid, bkid, gymCenter, st);
        if(slot.getCapacity()>0){
            CustomerService customerService=new CustomerService();
            Customer customer=customerService.customers.get(userid);
            int f=0;
            for(pair<Booking, Boolean> bk:customer.getBookings()){
                if(bk.getFirst().getStarttime()==st){
                    cancelslotbooking(userid, bk.getFirst().getGymCenter(), st);
                    f=1;
                }
            }
            customer.getBookings().add(new pair<>(newbooking, true));
            slot.getBookings().add(newbooking);
            slot.reduceCapacity();
            if(f==1){
                System.out.println("Previous overlapping booking is cancelled.");
            }
            System.out.println("Confirm booking at "+ gymCenter.getGymName()+" "+st+".");
        }
        else{
            System.out.println("Slot is already full.");
            CustomerService customerService=new CustomerService();
            Customer customer=customerService.customers.get(userid);
            int f=0;
            pair<Booking, Boolean> oldbk=null;
            for(pair<Booking, Boolean> bk:customer.getBookings()){
                if(bk.getFirst().getStarttime()==st){
                    oldbk=bk;
                    if(bk.getSecond()){
                        f=1;
                    }
                }
            }
            if(f==1){
                System.out.println("You already have confirmed booking for this time slot "+st+" at "+oldbk.getFirst().getGymCenter().getGymName()+".");
                System.out.println("Note: If you wish to book slot you will loose previous confirmed booking.");
            }
            System.out.println("Do you still want to book slot in waitlist?");
            System.out.println("Enter choice: ");
            System.out.println("1. YES");
            System.out.println("2. NO");
            String ch=scanner.nextLine();
            switch (ch){
                case "1":
                    cancelslotbooking(userid, oldbk.getFirst().getGymCenter(), st);
                    slot.getWaitings().add(newbooking);
                    customer.getBookings().add(new pair<>(newbooking,false));
                    if(f==1){
                        System.out.println("Previous overlapping booking is cancelled.");
                    }
                    System.out.println("Booking on the waitlist at "+gymCenter.getGymName()+" "+st+".");
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

}
