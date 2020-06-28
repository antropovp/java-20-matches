package com.epam.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MessageServiceImpl implements MessageService {

    @Override
    public void printStartMessage() {
        System.out.println("Правила игры:\n" +
                "В начале игры на столе лежит 20 спичек;\n" +
                "Игроки ходят по очереди, убирая на выбор 1, 2 или 3 спички;\n" +
                "Проигравшим считается тот, кто возьмет со стола последнюю спичку.\n");
    }

    @Override
    public void printMatchesLeft(int matchesLeft) {
        System.out.println("На столе осталось " + matchesLeft + " спичек.");
    }

    @Override
    public void printWhoMoves(boolean isComputerMove) {
        if (isComputerMove) {
            System.out.print("Количество выбранных компьютером спичек: ");
        } else {
            System.out.print("- Ход игрока. Введите количество спичек: ");
        }
    }

    @Override
    public int chooseNumberOfMatches() {

        int numberOfMatchesChosen = 0;

        Scanner in = new Scanner(System.in);
        try {
            numberOfMatchesChosen = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ОШИБКА: Неверный формат введённых данных.");
        }

        return numberOfMatchesChosen;
    }

    @Override
    public void endGame(boolean isComputerMove) {
        if (isComputerMove) {
            System.out.println("Для компьютера осталась последняя спичка. Компьютер проиграл!");
        } else {
            System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
        }
    }
}
