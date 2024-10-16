package com.example.ROPULVA.Component;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;

@Component

public class EventsComponent {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EventsComponent.class);

    public void logEventAction(String action, Long eventId) {
        logger.info("Action: {} for Event ID: {}", action, eventId);
    }

    public void validateEventData(String title, String description) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Event title cannot be empty.");
        }

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Event description cannot be empty.");
        }
    }

}
