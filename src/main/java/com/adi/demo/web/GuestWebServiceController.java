package com.adi.demo.web;

import com.adi.demo.business.service.GuestService;
import com.adi.demo.data.entity.Guest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room/guests")
@Api(value="onlinereservation", description = "Online Guest Information")
public class GuestWebServiceController {
    private final GuestService guestService;

    @Autowired
    public GuestWebServiceController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Guest> list(){
        return guestService.listAllGuests();
    }

    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Guest show(@PathVariable Long id){
        return guestService.showGuestById(id);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST, produces = "application/json")
    public ResponseEntity add(@RequestBody Guest guest){
        guestService.saveGuest(guest);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

}
