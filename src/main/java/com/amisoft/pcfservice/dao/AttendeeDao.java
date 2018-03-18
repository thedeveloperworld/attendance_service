package com.amisoft.pcfservice.dao;

import com.amisoft.pcfservice.entity.Attendee;
import org.springframework.data.repository.CrudRepository;

public interface AttendeeDao extends CrudRepository<Attendee,Long> {

    Attendee findAttendeeByFirstName(String firstName);
}
