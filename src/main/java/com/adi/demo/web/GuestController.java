package com.adi.demo.web;

import com.adi.demo.data.entity.Guest;
import com.adi.demo.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public String getAllGuests(Model model){
        List<Guest> result = new ArrayList<>();
        this.guestRepository.findAll().forEach(guest -> {
            result.add(guest);
        });
        result.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if(o1.getLastName() == o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        model.addAttribute("guestList",result);
        return "guests";
    }
}
