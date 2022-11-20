package ru.murashov.bookingapp.service;


import org.springframework.stereotype.Service;
import ru.murashov.bookingapp.model.Booking;
import ru.murashov.bookingapp.repository.BookingRepository;

@Service
public class BookingService {

  private final BookingRepository bookingRepository;

  public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  public Booking save(Booking booking) {
    return bookingRepository.save(booking);
  }

}
