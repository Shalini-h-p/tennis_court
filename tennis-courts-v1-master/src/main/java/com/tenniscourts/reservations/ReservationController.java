package com.tenniscourts.reservations;

import com.tenniscourts.config.BaseRestController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping
@RestController
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;
    @RequestMapping(value = "bookReservation",method = RequestMethod.POST )
    public ResponseEntity<Void> bookReservation(CreateReservationRequestDTO createReservationRequestDTO) {
        return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
    }
    @RequestMapping(value = "findReservation",method = RequestMethod.GET)
    public ResponseEntity<ReservationDTO> findReservation(Long reservationId) {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }
    @RequestMapping(value = "cancelReservation",method = RequestMethod.DELETE)
    public ResponseEntity<ReservationDTO> cancelReservation(Long reservationId) {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }
    @RequestMapping(value = "rescheduleReservation",method = RequestMethod.PUT )
    public ResponseEntity<ReservationDTO> rescheduleReservation(Long reservationId, Long scheduleId) {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }
}
