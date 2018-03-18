package com.amisoft.pcfservice.entity;


import javax.persistence.*;


@Entity
@Table(name = "t_attendee")
public class Attendee {

        @Id
        @GeneratedValue
        private Long id;

        @Column(nullable = false)
        private String firstName;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }


        public Attendee() {
        }

        public Attendee(String firstName) {

                this.firstName = firstName;
        }
}
