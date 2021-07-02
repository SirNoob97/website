package com.github.SirNoob97.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebSite {

  @GetMapping("/")
  public String index() {
    return "index";
  }
}
