package ru.murashov.bookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.murashov.bookingapp.model.EatingTable;

@Repository
public interface TableRepository extends JpaRepository<EatingTable, Integer> {

}
