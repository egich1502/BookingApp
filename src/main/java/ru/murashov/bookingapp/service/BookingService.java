package ru.murashov.bookingapp.service;


import java.util.Set;
import org.springframework.stereotype.Service;
import ru.murashov.bookingapp.model.Booking;
import ru.murashov.bookingapp.model.EatingTable;
import ru.murashov.bookingapp.repository.BookingRepository;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;
  private final EatingTableService eatingTableService;

  public BookingService(BookingRepository bookingRepository,
      EatingTableService eatingTableService) {
    this.bookingRepository = bookingRepository;
    this.eatingTableService = eatingTableService;
  }

  public Booking getBookingById(int tableId, int bookingId) {
    EatingTable table = eatingTableService.getTableById(tableId);
    Set<Booking> bookings = table.getBookings();
    return bookings.stream().filter(x -> x.getId().equals(bookingId)).toList().get(0);
  }

  public Booking saveNewBooking(int tableId, Booking booking) {
    EatingTable table = eatingTableService.getTableById(tableId);
    booking.setEatingTable(table.getId());
    table.getBookings().add(booking);
    try {
      return bookingRepository.save(booking);
    } catch (Exception e) {
      return null;
    }
  }

}
