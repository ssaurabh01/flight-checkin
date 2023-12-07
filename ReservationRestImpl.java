package com.saurabh.flightcheckin.intergration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.saurabh.flightcheckin.intergration.dto.Reservation;
import com.saurabh.flightcheckin.intergration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestImpl implements ReservationRestClient {

	private static final String RESERVATION_REST_URL = "http://localhost:8080/locationweb/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		RestTemplate restTemplate=new RestTemplate();
		Reservation reservation = restTemplate
				.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate=new RestTemplate();
		Reservation reservation = restTemplate
				.postForObject(RESERVATION_REST_URL,request, Reservation.class);
		return reservation;
	}

}
