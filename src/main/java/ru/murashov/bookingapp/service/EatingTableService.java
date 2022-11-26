package ru.murashov.bookingapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.murashov.bookingapp.model.EatingTable;
import ru.murashov.bookingapp.repository.TableRepository;

@Service
public class EatingTableService {

  private final TableRepository tableRepository;

  public EatingTableService(TableRepository tableRepository) {
    this.tableRepository = tableRepository;
  }

  public List<EatingTable> getAllTables() {
    return tableRepository.findAll();
  }

  public EatingTable getTableById(int id) {
    return tableRepository.findById(id).get();
  }

  public EatingTable saveTable(EatingTable eatingTable) {
    return tableRepository.save(eatingTable);
  }

}