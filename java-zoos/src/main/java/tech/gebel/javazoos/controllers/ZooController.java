package tech.gebel.javazoos.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.gebel.javazoos.models.Zoo;
import tech.gebel.javazoos.services.ZooService;

@RestController
@RequestMapping("/zoos")
public class ZooController {
  private final ZooService zooService;

  public ZooController(ZooService zooService) {
    this.zooService = zooService;
  }

  @GetMapping("/zoos")
  private ResponseEntity<?> getZoos() {
    List<Zoo> zoos = zooService.getZoos();
    return new ResponseEntity<>(zoos, HttpStatus.OK);
  }
}
