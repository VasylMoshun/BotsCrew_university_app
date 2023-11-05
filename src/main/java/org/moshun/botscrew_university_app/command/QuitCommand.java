package org.moshun.botscrew_university_app.command;

import org.springframework.stereotype.Component;

@Component
public class QuitCommand implements Command{
    @Override
    public void execute(String query) {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "quit";
    }
}
