package ru.javarush.golf.evgeniilozovoi.servletquest.parser;


public enum Lang {
    RU("questStepsRU.json"), EN("questStepsEN.json");

    private final String path;

    Lang(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

