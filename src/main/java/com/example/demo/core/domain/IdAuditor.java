package com.example.demo.core.domain;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class IdAuditor implements AuditorAware<UUID> {
    @Override
    public Optional<UUID> getCurrentAuditor() {
        return Optional.of(UUID.randomUUID());
    }
}
