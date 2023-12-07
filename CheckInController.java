package com.saurabh.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saurabh.flightcheckin.intergration.ReservationRestClient;
import com.saurabh.flightcheckin.intergration.dto.Reservation;
import com.saurabh.flightcheckin.intergration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient restClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCHeckIn(@RequestParam("reservationId") Long reservationId,ModelMap modelmap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelmap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(Long reservationId,@RequestParam("numberOfBags") int numberOfBgas) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBgas);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}
	
}
