package com.technoelevate.postsharing.controller;

import com.technoelevate.postsharing.model.Notification;
import com.technoelevate.postsharing.service.PushNotificationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/push-notifications")
@Slf4j
@RequiredArgsConstructor
public class PushNotificationController {

    private final PushNotificationService service;

    @GetMapping("/{userID}")
    public Flux<ServerSentEvent<List<Notification>>> streamLastMessage(@PathVariable String userID) {
    	log.info("streamLastMessage with userid {}",userID);
        return service.getNotificationsByUserToID(userID);
    }

}
