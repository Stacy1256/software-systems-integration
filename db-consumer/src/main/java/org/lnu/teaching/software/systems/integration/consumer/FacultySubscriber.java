package org.lnu.teaching.software.systems.integration.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.lnu.teaching.software.systems.integration.entity.Faculty;
import org.lnu.teaching.software.systems.integration.repository.FacultyRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FacultySubscriber {

    private final FacultyRepository facultyRepository;

    private final ObjectMapper objectMapper;

    public void handleMessage(String message, String topicName) {
        Faculty faculty;
        try {
            faculty = objectMapper.readValue(message, Faculty.class);
        } catch (JsonProcessingException e) {
            System.out.println("Failed parse faculty");
            throw new RuntimeException(e);
        }

        try {
            facultyRepository.create(faculty);
            System.out.println("Saved new faculty " + faculty.getName());
        } catch (RuntimeException e) {
            System.out.println("Faculty " + faculty.getName() + " already exists");
        }
    }
}
