package com.epam.service;

public interface GameService {

    boolean isComputerMove = true;
    int matchesLeft = 20;
    MessageService messageService = new MessageServiceImpl();
    ComputerLogicService computerLogicService = new ComputerLogicServiceImpl();

    void start();

    void move();

    boolean checkNumberOfMatchesChosen(int numberOfMatchesChosen);
}
