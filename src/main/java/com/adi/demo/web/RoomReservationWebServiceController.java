package com.adi.demo.web;

import com.adi.demo.business.domain.RoomReservation;
import com.adi.demo.business.service.ReservationService;
import com.adi.demo.utils.DateUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/room/reservations")
@Api(value="onlinereservation", description = "Online Guest Information")
public class RoomReservationWebServiceController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name="date",required = false)String dateString){
        Date date= DateUtils.createdDateFromDateString(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
}
