package com.amrita.jpl.cys21051.p2;
import java.util.*;

abstract class QuizGame {
    void startGame() {
        askQuestion();
    }

    abstract void askQuestion();

    abstract void evaluateAnswer(String answer);
}

interface QuizGameListener {
    void ifQuestionisAsked(String question);

    void ifAnswerisEvaluated(boolean isCorrect);
}

class QuizGameServer extends QuizGame implements QuizGameListener {
    private String[] questions = {
            "20CYS383 is the course code for JAVA LAB(true/false)?", "Is the colour of the sky blue(true/false)?",
    };
    private int currentQuestionIndex = 0;

    @Override
    void startGame() {
        System.out.println("Server initiated the QuizGame!");
        super.startGame();
    }

    @Override
    void askQuestion() {
        if (currentQuestionIndex >= questions.length) {
            System.out.println("All questions have been asked.");
            return;
        }

        String question = questions[currentQuestionIndex];
        ifQuestionisAsked(question);
    }

    @Override
    void evaluateAnswer(String answer) {
        boolean isCorrect = answer.equals("true");
        ifAnswerisEvaluated(isCorrect);
    }

    @Override
    public void ifQuestionisAsked(String question) {
        System.out.println("Server's question: " + question);
        currentQuestionIndex++;
    }

    @Override
    public void ifAnswerisEvaluated(boolean isCorrect) {
        System.out.println("The answer is" + isCorrect);
        askQuestion();
    }
}

class QuizGameClient extends QuizGame implements QuizGameListener {
    @Override
    void startGame() {
        System.out.println("Client initiated the QuizGame!");
        super.startGame();
    }

    @Override
    void askQuestion() {
        String question = "20CYS383 is the course code for JAVA LAB(1/0)?";
        ifQuestionisAsked(question);
        String question1 = "Is the colour of the sky blue(true/false)?";
        ifQuestionisAsked(question1);
    }

    @Override
    void evaluateAnswer(String answer) {
        System.out.println("Client sent answer: " + answer);
        boolean isCorrect = answer.equals("true");
        ifAnswerisEvaluated(isCorrect);
    }

    @Override
    public void ifQuestionisAsked(String question) {
        System.out.println("Client got a question: " + question);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write your answer(true, false): ");
        String answer = scanner.nextLine();
        evaluateAnswer(answer);
    }
    int i = 0;
    @Override
    public void ifAnswerisEvaluated(boolean isCorrect) {
        System.out.println("Client got result: The answer is " + isCorrect);
        if(isCorrect){
            i++;
            System.out.println("You've got 1 mark");
            System.out.println("Total Marks= " + i);
        }
        else {
            System.out.println("You've got 0 mark");
            System.out.println("Total Marks= " + i);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        QuizGameServer qgs = new QuizGameServer();
        qgs.startGame();

        QuizGameClient qgc = new QuizGameClient();
        qgc.startGame();
    }
}
