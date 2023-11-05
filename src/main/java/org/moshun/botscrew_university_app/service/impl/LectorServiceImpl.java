package org.moshun.botscrew_university_app.service.impl;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.moshun.botscrew_university_app.repo.LectorRepository;
import org.moshun.botscrew_university_app.service.LectorService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public List<String> globalSearch(String template) {
        return lectorRepository.globalSearch(template);
    }
}
