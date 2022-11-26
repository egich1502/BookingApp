package ru.murashov.bookingapp.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.murashov.bookingapp.model.Booking;
import ru.murashov.bookingapp.service.BookingService;
import ru.murashov.bookingapp.service.EatingTableService;

@RestController
@RequestMapping("api/tables/{tableId}/booking")
public class BookingController {

  private final EatingTableService eatingTableService;
  private final BookingService bookingService;

  @Autowired
  public BookingController(EatingTableService eatingTableService, BookingService bookingService) {
    this.eatingTableService = eatingTableService;
    this.bookingService = bookingService;
  }

  @GetMapping(path = "", produces = "application/json")
  public Set<Booking> getAllBookingsForTable(@PathVariable("tableId") int id) {
    return eatingTableService.getTableById(id).getBookings();
  }

  @GetMapping(path = "{bookingId}", produces = "application/json")
  public Booking getBookingById(@PathVariable("tableId") int tableId, @PathVariable int bookingId) {
    return bookingService.getBookingById(tableId, bookingId);
  }

  @PostMapping(path = "new", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Booking> saveNewBooking(@PathVariable int tableId,
      @RequestBody Booking booking) {
    Booking newBooking = bookingService.saveNewBooking(tableId, booking);
    if (newBooking != null) {
      return ResponseEntity.ok(newBooking);
    } else {
      return new ResponseEntity<>(booking, HttpStatus.BAD_REQUEST);
    }
  }

}
