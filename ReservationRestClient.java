package com.saurabh.flightcheckin.intergration;

import com.saurabh.flightcheckin.intergration.dto.Reservation;
import com.saurabh.flightcheckin.intergration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);
}
