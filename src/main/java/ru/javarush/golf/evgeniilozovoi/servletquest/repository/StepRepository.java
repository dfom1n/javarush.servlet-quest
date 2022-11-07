package ru.javarush.golf.evgeniilozovoi.servletquest.repository;

import ru.javarush.golf.evgeniilozovoi.servletquest.model.Step;
import ru.javarush.golf.evgeniilozovoi.servletquest.parser.JsonSimpleParser;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StepRepository {
    private List<Step> list;

    public StepRepository() {
        this.list = new JsonSimpleParser().parseSteps();
    }

    public List<Step> getByNext(int next) {
        List<Step> collect = list.stream().filter(step -> step.getCurrent() == next).collect(Collectors.toList());
        return collect.size() < 2 ? null : collect;
    }

    public List<Step> getFirst() {
        return list.stream().filter(step -> step.getCurrent() == 1).collect(Collectors.toList());
    }

    public String getQuestion(int current) {
        return list.stream()
                .filter(step -> step.getCurrent() == current)
                .filter(Objects::nonNull)
                .findFirst()
                .get()
                .getQuestion();
    }

    public String getFirstQuestion() {
        return list.stream()
                .filter(step -> step.getCurrent() == 1)
                .filter(Objects::nonNull)
                .findFirst()
                .get()
                .getQuestion();
    }
}
