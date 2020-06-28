package com.epam.service;

public interface MessageService {

    void printStartMessage();

    void printMatchesLeft(int matchesLeft);

    void printWhoMoves(boolean isComputerMove);

    int chooseNumberOfMatches();

    void endGame(boolean isComputerMove);
}
