package ru.murashov.bookingapp.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.murashov.bookingapp.model.Booking;
import ru.murashov.bookingapp.model.EatingTable;
import ru.murashov.bookingapp.service.BookingService;
import ru.murashov.bookingapp.service.EatingTableService;

@RestController
@RequestMapping("tables/{table_id}/booking")
public class BookingController {

  private final EatingTableService eatingTableService;
  private final BookingService bookingService;

  @Autowired
  public BookingController(EatingTableService eatingTableService, BookingService bookingService) {
    this.eatingTableService = eatingTableService;
    this.bookingService = bookingService;
  }

  @GetMapping(path = "", produces = "application/json")
  public Set<Booking> getAllBookingsForTable(@PathVariable("table_id") int id) {
    EatingTable table = eatingTableService.getTableById(id);
    return table.getBookings();
  }

  @GetMapping(path = "{booking_id}", produces = "application/json")
  public Booking getBookingById(@PathVariable("table_id") int tableId,
      @PathVariable int booking_id) {
    EatingTable table = eatingTableService.getTableById(tableId);
    Set<Booking> bookings = table.getBookings();
    return bookings.stream().filter(x -> x.getId().equals(booking_id)).toList().get(0);
  }

  @PostMapping(path = "new", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Booking> saveNewBooking(@PathVariable int table_id,
      @RequestBody Booking booking) {
    EatingTable table = eatingTableService.getTableById(table_id);
    booking.setEatingTable(table.getId());
    table.getBookings().add(booking);
    return ResponseEntity.ok(bookingService.save(booking));
  }

}
