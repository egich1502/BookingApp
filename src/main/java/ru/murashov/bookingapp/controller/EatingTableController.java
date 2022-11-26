package ru.murashov.bookingapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.murashov.bookingapp.model.EatingTable;
import ru.murashov.bookingapp.service.EatingTableService;

@RestController
@RequestMapping("api/tables")
public class EatingTableController {

  private final EatingTableService eatingTableService;

  @Autowired
  public EatingTableController(EatingTableService eatingTableService) {
    this.eatingTableService = eatingTableService;
  }

  @GetMapping(path = "", produces = "application/json")
  public List<EatingTable> getAllTables() {
    return eatingTableService.getAllTables();
  }

  @GetMapping(path = "{id}", produces = "application/json")
  public EatingTable getTableById(@PathVariable("id") int id) {
    return eatingTableService.getTableById(id);
  }

  @PostMapping(path = "save", consumes = "application/json", produces = "application/json")
  public ResponseEntity<EatingTable> saveTable(@RequestBody EatingTable eatingTable) {
    return ResponseEntity.ok(eatingTableService.saveTable(eatingTable));
  }
}
