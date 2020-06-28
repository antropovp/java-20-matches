package com.epam.service;

public class ComputerLogicServiceImpl implements ComputerLogicService {

    @Override
    public int chooseNumberOfMatches(int matchesLeft) {

        int numberOfMatchesChosen = 0;

        numberOfMatchesChosen = (matchesLeft - 1) % 4;

        System.out.println(numberOfMatchesChosen);

        return numberOfMatchesChosen;
    }
}
