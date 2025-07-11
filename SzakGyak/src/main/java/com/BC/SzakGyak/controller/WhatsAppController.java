package com.BC.SzakGyak.controller;


import com.BC.SzakGyak.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WhatsAppController {

    @Autowired
    private TwilioService twilioService;

    @GetMapping("/")
    public String index() {
        return "test";
    }

    @PostMapping("/send-message")
    public String sendMessage(@RequestParam String phoneNumber, @RequestParam String message, Model model) {
        twilioService.sendMessage(phoneNumber, message);
        model.addAttribute("status", "Message sent to " + phoneNumber);
        return "test"; // Visszatérés az index oldalra
    }
}
