package com.setec.coffee_shop.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.setec.coffee_shop.entities.Booked;
import com.setec.coffee_shop.repos.BookedRepo;
import com.setec.coffee_shop.service.MyTelegramBot;

@Controller
public class MyController {
	@GetMapping({ "/", "home" })
	public String home(Model mod) {
		Booked booked = new Booked(
				0,
				"",
				"",
				"",
				LocalDate.now(),
				LocalTime.now(),
				1
				);
		mod.addAttribute("booked", booked);
		return "index";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

	@GetMapping("/reservation")
	public String reservation(Model mod) {
		Booked booked = new Booked(
				0,
				"",
				"",
				"",
				LocalDate.now(),
				LocalTime.now(),
				1
				);
		mod.addAttribute("booked", booked);
		return "reservation";
	}

	@GetMapping("/service")
	public String service() {
		return "service";
	}

	@GetMapping("/testimonial")
	public String testimonial() {
		return "testimonial";
	}
	@Autowired
	private BookedRepo bookedRepo;
	@Autowired
	private MyTelegramBot send;
	@PostMapping("/success")
	public String success(@ModelAttribute Booked booked) {
	    bookedRepo.save(booked);
	    String message = "==========Reservation==========\n" +
	    				 "ID :"+booked.getId()+"\n"+
	                     "Name: " + booked.getName() + "\n" +
	                     "Email: " + booked.getEmail() + "\n" +
	                     "Phone: " + booked.getPhoneNumber() + "\n" +
	                     "Reserved for: " + booked.getDate() + " at " + booked.getTime() + "\n" +
	                     "Guests: " + booked.getPerson() + "\n" ;
	    send.sendMessage(message);  // Sends the formatted message to Telegram
	    return "success";
	}

}
