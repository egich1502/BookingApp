package ru.murashov.bookingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("")
  public String getMainPage() {
    return "index";
  }

  @GetMapping("tables/{id}/booking")
  public String getSpecificTable() {
    return "specific_table";
  }

}
