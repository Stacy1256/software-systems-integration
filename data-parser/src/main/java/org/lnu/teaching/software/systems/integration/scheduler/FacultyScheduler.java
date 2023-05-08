package org.lnu.teaching.software.systems.integration.scheduler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.entity.Faculty;
import org.lnu.teaching.software.systems.integration.publisher.RedisPublisher;
import org.lnu.teaching.software.systems.integration.service.FacultyService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultyScheduler {

    private static final String NEW_FACULTY_TOPIC = "NEW_FACULTY_TOPIC";

    private final FacultyService facultyService;

    private final RedisPublisher redisPublisher;

    private final ObjectMapper objectMapper;

    @Scheduled(fixedDelay = 10 * 1000)
    public void test() {
        List<Faculty> faculties = facultyService.findFaculties();

        faculties.forEach(faculty -> {
            try {
                redisPublisher.publish(NEW_FACULTY_TOPIC, objectMapper.writeValueAsString(faculty));
            } catch (Exception e) {
                System.out.println("Failed to publish Faculty!");
            }
        });
    }
}
