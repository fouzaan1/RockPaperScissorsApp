package com.rps.rockpaperscissorsapp.controller;

import com.rps.rockpaperscissorsapp.model.Move;
import com.rps.rockpaperscissorsapp.model.PlayerMove;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
@RequestMapping("/index")
public class GameController {

    @RequestMapping(value = "selectChoice", method = RequestMethod.GET)
    public static String getPlayerMove() {
        String choice = "1";
        String playerChoice = choice.toUpperCase();
        if (playerChoice.equals("ROCK") || playerChoice.equals("PAPER") || playerChoice.equals("SCISSORS")) {
            return playerChoice;
        } else {
            System.out.println("This is not Valid Move, Try again!");
            return "Bad Input";
        }

    }

    //    @RequestMapping({"/","/index"})
    public static String getComputerMove() {

        String computerChoice;
        Random random = new Random();
        int input = random.nextInt(3) + 1;
        if (input == 1) {
            computerChoice = Move.ROCK.name();
        } else if (input == 2) {
            computerChoice = Move.PAPER.name();
        } else {
            computerChoice = Move.SCISSORS.name();
        }
        return computerChoice;
    }

    public String displayResutl() {

        String playerMove = getPlayerMove();
        System.out.println("Your move is: " + playerMove);
        if (!playerMove.equals("Bad Input")) {
            String computerMove = getComputerMove();
            System.out.println("Computer move is: " + computerMove);
            if (playerMove.equals(computerMove)) {
                System.out.println("Game is Tie !!");
            }
            // If playerMove is ROCK
            else if (playerMove.equals(Move.ROCK.name())) {
                if (computerMove.equals(Move.PAPER.name())) {
                    System.out.println("Computer Wins");
                    System.out.println("Better Luck Next Time!");
                } else {
                    System.out.println("You Win!");
                    System.out.println("OOhhOO, Congratulations!!! ");
                }
            }
            // If playerMove is PAPER
            else if (playerMove.equals(Move.PAPER.name())) {
                if (computerMove.equals(Move.SCISSORS.name())) {
                    System.out.println("Computer Wins");
                    System.out.println("Better Luck Next Time!");
                } else {
                    System.out.println("You Win!");
                    System.out.println("OOhhOO, Congratulations!!! ");
                }
            }
            // If playerMove is SCISSORS
            else {
                if (computerMove.equals(Move.ROCK.name())) {
                    System.out.println("Computer Wins");
                    System.out.println("Better Luck Next Time!");
                } else {
                    System.out.println("You Win!");
                    System.out.println("OOhhOO, Congratulations!!! ");
                }
            }
        }

return "";
    }
}