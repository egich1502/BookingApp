package ru.murashov.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.murashov.bookingapp.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
