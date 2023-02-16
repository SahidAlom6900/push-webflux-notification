package com.technoelevate.postsharing.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.technoelevate.postsharing.model.Notification;

@Repository
public interface NotificationStorageRepository extends MongoRepository<Notification, String> {

    Optional<Notification> findById(String id);

    List<Notification> findByUserToId(String id);


    List<Notification> findByUserToIdAndDeliveredFalse(String id);


}
