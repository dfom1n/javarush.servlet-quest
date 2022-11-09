package ru.javarush.golf.evgeniilozovoi.servletquest.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import ru.javarush.golf.evgeniilozovoi.servletquest.model.Step;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonSimpleParser {
    private static Lang language;
    private static final String absolutePath = "C:\\Java\\IdeaProjects\\servlet\\";
    // TODO: 07.11.2022 fix to work with relative path 
    private static final String workDir = System.getProperty("user.dir")+File.separator;
    private String PATH = absolutePath+language.getPath();
    private static final String LIST_NAME = "steps";
    private static final String CURRENT_STEP = "current";
    private static final String NEXT_STEP = "next";
    private static final String TEXT_STEP = "text";
    private static final String QUESTION_STEP = "question";

    public static void setLanguage(Lang language) {
        JsonSimpleParser.language = language;
    }

    public List<Step> parseSteps() {
        JSONParser jsonParser = new JSONParser();
        List<Step> stepList = new ArrayList<>();
        try (FileReader reader = new FileReader(PATH)) {

            JSONObject stepJsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray steps = (JSONArray) stepJsonObject.get(LIST_NAME);

            for (Object step : steps) {
                JSONObject stepJson = (JSONObject) step;
                Long current = (Long) stepJson.get(CURRENT_STEP);
                Long next = (Long) stepJson.get(NEXT_STEP);
                String text = (String) stepJson.get(TEXT_STEP);
                String question = (String) stepJson.get(QUESTION_STEP);
                Step newStep;
                if (next == -1 && text == null) {
                    newStep = new Step(Math.toIntExact(current), question);
                } else {
                    newStep = new Step(Math.toIntExact(current), Math.toIntExact(next), text, question);
                }
                stepList.add(newStep);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stepList;
    }
}
