package com.adi.demo.business.service;

import com.adi.demo.data.entity.Guest;
import com.adi.demo.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {
    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> listAllGuests(){
        List<Guest> guestList= new ArrayList<>();
        Iterable<Guest> guests = guestRepository.findAll();
        guests.forEach(guestList::add);
        guestList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });
        return guestList;
    }

    public Guest showGuestById(Long id){
        return guestRepository.findById(id).orElse(null);
    }

    public Guest saveGuest(Guest guest){
        return guestRepository.save(guest);
    }

}
