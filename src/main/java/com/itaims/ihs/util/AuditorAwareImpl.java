package com.itaims.ihs.util;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.logging.Logger;

public class AuditorAwareImpl implements AuditorAware<String> {
    private static final Logger logger = Logger.getLogger(AuditorAwareImpl.class.getName());

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
