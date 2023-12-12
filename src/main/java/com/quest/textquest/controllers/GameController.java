package com.quest.textquest.controllers;

import com.quest.textquest.models.AnswerChoice;
import com.quest.textquest.models.GameDataEntity;
import com.quest.textquest.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class GameController {

    private final QuestService questService;

    @Autowired
    public GameController(QuestService questService) {
        this.questService = questService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) Integer questionId) {
        if (questionId == null) {
            questionId = 1;
        }

        GameDataEntity questionData = questService.getQuestionById(questionId);

        if (questionData == null) {
            return "game_over";
        }

        model.addAttribute("questionText", questionData.getQuestion());
        model.addAttribute("questionId", questionId);

        List<AnswerChoice> answers = Arrays.asList(
                new AnswerChoice(questionData.getCorrectAnswer(), true),
                new AnswerChoice(questionData.getWrongAnswer(), false)
        );
        model.addAttribute("answers", answers);

        return "index";
    }

    @GetMapping("/play/answer")
    public String play(@RequestParam(required = false) Integer questionId, @RequestParam(required = false) String choice) {
        if (questionId == null || choice == null) {
            return "redirect:/";
        }

        GameDataEntity currentQuestion = questService.getQuestionById(questionId);
        if (currentQuestion == null) {
            return "redirect:/game_over";
        }
        System.out.println("Current Question ID: " + questionId);
        System.out.println("Choice: " + choice);

        if (choice.equals(currentQuestion.getCorrectAnswer())) {
            Integer nextQuestionId = currentQuestion.getNextQuestionId();
            if (nextQuestionId != null) {
                return "redirect:/?questionId=" + nextQuestionId;
            } else {
                return "redirect:/game_success";
            }
        } else {
            return "redirect:/game_over";
        }
    }

    @GetMapping("/game_over")
    public String gameOver() {
        return "game_over";
    }

    @GetMapping("/game_success")
    public String gameSuccess() {
        return "game_success";
    }
}