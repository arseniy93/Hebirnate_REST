package com.rigin.service;

import com.rigin.model.entity.Activity;
import com.rigin.repository.ActivityRepository;
import com.rigin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.mapping.List;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

//    public void createActivity(String content) {
//        Date updatedDate = getNowDate();
//
//        activityRepository.save(Activity.builder()
//                .createdDate(updatedDate)
//                .content(content)
//                .build());
//    }

    private static Date getNowDate() {
        Date updatedDate;
        LocalDateTime localDateTime = LocalDateTime.now();
        updatedDate = Date.from(localDateTime.toInstant(ZoneOffset.of("+08:00")));
        return updatedDate;
    }

//    public void updateActivity(Long id, String content) {
//        var activity = activityRepository.findById(id);
//        if (activity.isPresent()) {
//            log.warn("{} id of activity  found", id);
//            activityRepository.update(new Activity(activity.get().getId(), activity.get().getCreatedDate(), getNowDate(), content));
//        }
//        else{
//            log.warn("{} id of activity not found", id);
//        }
//    }

}
