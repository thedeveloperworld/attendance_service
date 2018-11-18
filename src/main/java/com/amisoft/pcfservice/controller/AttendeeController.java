package com.amisoft.pcfservice.controller;

import com.amisoft.pcfservice.dao.AttendeeDao;
import com.amisoft.pcfservice.entity.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

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
    public String fetchAllAttendee() {

        List<Attendee> attendeeList = (List<Attendee>) attendeeDao.findAll();
        StringBuilder attendeeNameCollector = new StringBuilder("<center>");

        attendeeList.forEach(s -> attendeeNameCollector.append("<br><b>" + s.getFirstName() + "</b></br>"));
        attendeeNameCollector.append("</center>");

        return attendeeNameCollector.toString();


    }


}
