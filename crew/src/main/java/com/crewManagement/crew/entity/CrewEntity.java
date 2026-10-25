package com.crewManagement.crew.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CrewEntity {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long crewId;

        private String crewName;

        private LocalDate dob;

        private String passportNumber;

        private LocalDate passportExpiryDate;

        private String flightNumberAssigned;

        private String originAirport;

        private String destinationAirport;

        private String journeyStatus;



        public Long getCrewId() {
            return crewId;
        }

        public void setCrewId(Long crewId) {
            this.crewId = crewId;
        }

        public String getCrewName() {
            return crewName;
        }

        public void setCrewName(String crewName) {
            this.crewName = crewName;
        }

        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }

        public String getPassportNumber() {
            return passportNumber;
        }

        public void setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
        }

        public LocalDate getPassportExpiryDate() {
            return passportExpiryDate;
        }

        public void setPassportExpiryDate(LocalDate passportExpiryDate) {
            this.passportExpiryDate = passportExpiryDate;
        }

        public String getFlightNumberAssigned() {
            return flightNumberAssigned;
        }

        public void setFlightNumberAssigned(String flightNumberAssigned) {
            this.flightNumberAssigned = flightNumberAssigned;
        }

        public String getOriginAirport() {
            return originAirport;
        }

        public void setOriginAirport(String originAirport) {
            this.originAirport = originAirport;
        }

        public String getDestinationAirport() {
            return destinationAirport;
        }

        public void setDestinationAirport(String destinationAirport) {
            this.destinationAirport = destinationAirport;
        }

        public String getJourneyStatus() {
            return journeyStatus;
        }

        public void setJourneyStatus(String journeyStatus) {
            this.journeyStatus = journeyStatus;
        }




    }
