package org.moshun.botscrew_university_app.command;

import java.util.List;
import org.moshun.botscrew_university_app.service.LectorService;
import org.springframework.stereotype.Component;

@Component
public class GlobalSearchCommand implements Command{
    private final LectorService lectorService;

    public GlobalSearchCommand(LectorService lectorService) {
        this.lectorService = lectorService;
    }

    @Override
    public void execute(String query) {
        List<String> globalSearch = lectorService.globalSearch(query);
        System.out.println(globalSearch);
    }

    @Override
    public String getName() {
        return "5";
    }
}
