package com.epam.service;

public class GameServiceImpl implements GameService {

    private boolean isComputerMove = true;
    private int matchesLeft = 20;
    private MessageService messageService = new MessageServiceImpl();
    private ComputerLogicService computerLogicService = new ComputerLogicServiceImpl();

    @Override
    public void start() {

        messageService.printStartMessage();

        while (matchesLeft > 1) {
            move();
        }

        messageService.endGame(isComputerMove);
    }

    @Override
    public void move() {

        int numberOfMatchesChosen = 0;

        messageService.printMatchesLeft(matchesLeft);
        messageService.printWhoMoves(isComputerMove);

        if (isComputerMove) {
            numberOfMatchesChosen = computerLogicService.chooseNumberOfMatches(matchesLeft);
        } else {
            do {
                numberOfMatchesChosen = messageService.chooseNumberOfMatches();
            } while (!checkNumberOfMatchesChosen(numberOfMatchesChosen));
        }

        isComputerMove = !isComputerMove;
        matchesLeft -= numberOfMatchesChosen;
    }

    @Override
    public boolean checkNumberOfMatchesChosen(int numberOfMatchesChosen) {
        if ((numberOfMatchesChosen < 1) || (numberOfMatchesChosen > 3) || (matchesLeft - numberOfMatchesChosen < 1)) {
            System.out.println("ОШИБКА: Некорректное количество спичек!");
            messageService.printWhoMoves(false);
            return false;
        }

        return true;
    }
}
