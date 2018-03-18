package com.amisoft.pcfservice.controller;

import com.amisoft.pcfservice.dao.AttendeeDao;
import com.amisoft.pcfservice.entity.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/attendee")
public class AttendeeController {

    @Autowired
    AttendeeDao attendeeDao;

    @GetMapping("/addAttendee")
    public String addAttendee(@RequestParam(value = "firstName") String firstName) {

        Attendee attendee = new Attendee(firstName);
        attendeeDao.save(attendee);

        return "Attendee saved successfully :" + firstName;

    }


    @GetMapping("/findAllAttendee")
    public ResponseEntity<List<Attendee>> fetchAllAttendee() {

        List<Attendee> attendeeList = (List<Attendee>)attendeeDao.findAll();

        if (attendeeList.size() > 0)
            return ResponseEntity.status(HttpStatus.OK).body((attendeeList));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    }


}
