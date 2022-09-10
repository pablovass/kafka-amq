package com.pablovass.controller;

import com.pablovass.model.Message;
import com.pablovass.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping
    public void send(@RequestBody Message message){
        messageService.send(message);
    }
}
