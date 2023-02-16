package com.technoelevate.postsharing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.technoelevate.postsharing.model.Notification;
import com.technoelevate.postsharing.repository.NotificationStorageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationStorageService {

	private final NotificationStorageRepository notifRepository;

	public Notification createNotificationStorage(Notification notificationStorage) {
		return notifRepository.save(notificationStorage);
	}

	public Notification getNotificationsByID(String id) {
		log.info("getNotificationsByID with id {}", id);
		return notifRepository.findById(id).orElseThrow(() -> new RuntimeException("notification not found!"));
	}

	public List<Notification> getNotificationsByUserIDNotRead(String userID) {
		return notifRepository.findByUserToIdAndDeliveredFalse(userID);
	}

	public List<Notification> getNotificationsByUserID(String userID) {
		return notifRepository.findByUserToId(userID);
	}

	public Notification changeNotifStatusToRead(String notifID) {
		var notif = notifRepository.findById(notifID).orElseThrow(() -> new RuntimeException("not found!"));
		notif.setRead(true);
		return notifRepository.save(notif);
	}

	public void clear() {
		notifRepository.deleteAll();
	}
}
