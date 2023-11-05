package org.moshun.botscrew_university_app.command;

public interface Command {
    void execute(String query);

    String getName();
}
