/*
 * Picture.java
 *
 * Version:
 *     17.0.3
 *
 * Revisions:
 *     2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class that represents the Picture game.
 *
 * @author      Vishal Panchidi
 * @author      Neeraj Bandi
 */

public class Picture {
//    Stores name of Player1
    public static String player1Name;

//    Stores name of Player2
    public static String player2Name;

//    Stores file name of First File
    public static String superManFileName;

//    Stores file name of Second File
    public static String batManFileName;

//    Stores name of Word File where all the words are stored
    public static String wordFileName;

//    Stores the value of the first Word
    public static char[] firstWord;

//    Stores the value of the Second Word
    public static char[] secondWord;

//    storing value of guessed words by Player One
    public static char[] storing;

//    storing value of guessed words by Player Two
    public static char[] storing2;

//    storing value number  of guessed words by Player One
    public static int guessedWords1=0;

//    storing value of number of guessed words by player Two
    public static int guessedWords2=0;


    public static String finalString = new String();
    public  static String finalString2 = new String();

//    Number of lines in the file which is being read
    public static int soManyWordToPLayWith = 0;

    public static final String[] theWords = new String[10231];
    public static final Scanner readGuess = new Scanner(System.in);
    public static boolean wordGuessed = false;

    /**
     * Reads the Words from file and accumulates the program Input.
     * @param fileName : name of the file in the program.
     */

    public static void readWordsFromFile(String fileName) {
        try (
                BufferedReader input = new BufferedReader( new FileReader(fileName))){
            int counter = 0;
            soManyWordToPLayWith=0;
            while ( ( theWords[counter++] = input.readLine() ) != null ){
                soManyWordToPLayWith ++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}


    /**
     * Compares the userInput from Player and compares with Word1 from the words file.
     * Stores the matched array.
     * Removes the matched elements.
     * @param word : input from word file.
     * @param userInput : Input entered by the User.
     */

    public static void compareWordsFromPlayerOne(String word, String userInput){
        //Converting user userInput to character array
        char[] userInputChar = userInput.toCharArray();
        //Storing the input character
        char inputCharacter = userInputChar[0];
        boolean guessedInCurrentCheck = false;

        for(int index = 0;index < firstWord.length; index++){
            //checking if input character is equal any of the letters from word 1.
            if(inputCharacter == (firstWord[index])) {
                storing[index] = firstWord[index];
                //replacing the matched letter with signature so that duplicate count can be avoided.
                firstWord[index] = '^';
                guessedWords1 = guessedWords1 + 1;
                guessedInCurrentCheck = true;
            }
        }
        //Storing the guessed words and Printing
        finalString = new String(storing);
        System.out.println("" + new String(storing));

        //Checking if word found in current check
        if(guessedInCurrentCheck){
            System.out.println(player1Name + " have guessed " + guessedWords1 + " words correctly");
            System.out.println();
            printImage(word, guessedWords1, superManFileName);
        }else {
            System.out.println("No words guessed in this attempt "+player1Name);
        }

        //Checking if all the letters in the words are guessed
        if(finalString.equals(word)){
            // boolean value to represent the guessed word.
            wordGuessed = true;
            System.out.println(player1Name+ " WON!!!");
        }
    }

    /**
     * Compares the userInput from Player and compares with Word 2 from the words file.
     * Stores the matched array.
     * Removes the matched elements.
     * @param word2 : input from word file.
     * @param userInput : Input entered by the User.
     */

    public static void compareWordsFromPlayerTwo(String word2, String userInput){
        //Converting user userInput to character array
        char[] userInputChar = userInput.toCharArray();
        //Storing the input character
        char inputCharacter = userInputChar[0];
        boolean guessedInCurrentCheck = false;
        for(int index = 0;index < secondWord.length; index++){
            //checking if input character is equal any of the letters from word 2.
            if(inputCharacter == (secondWord[index])) {
                storing2[index] = secondWord[index];
                //replacing the matched letter with signature so that duplicate count can be avoided.
                secondWord[index] = '^';
                guessedWords2 = guessedWords2 + 1;
                guessedInCurrentCheck = true;

            }
        }

        //Storing the guessed words and Printing
        finalString2 = new String(storing2);
        System.out.println("" + new String(storing2));
        System.out.println();

        //Checking if word found in current check
        if(guessedInCurrentCheck){
            System.out.println(player2Name+" have guessed "+ guessedWords2+" words correctly");
            System.out.println();
            printImage(word2, guessedWords2,batManFileName);
        }else {
            System.out.println("No words guessed in this attempt for "+player2Name);
        }

        //Checking if all the letters in the words are guessed
        if(finalString2.equals(word2)){
            wordGuessed = true;
            System.out.println(player2Name+ " WON!!!");
        }
    }


    /**
     * Prints the Image according to the percentage of guessed numbers.
     * @param word : word that has to be guessed by respective players.
     * @param count : number of guessed words from respective player.
     * @param fileName : file name from which image has to be picked.
     */

    public static void printImage(String word,int count,String fileName){
        //reads file from respective files for according to the player
        readWordsFromFile(fileName);

        int lineNumber=0;
        //Gets every line of the Image
        while(lineNumber<soManyWordToPLayWith){
            //Converts every line of to a character array
            char[] oneLine = getWord(lineNumber).toCharArray();
            int lettersChanged = 0;
            Random rand = new Random();
            int guessed = count;
            //Percent of data that had to be shown
            int percentOfDataToBeShown = 100 - ((100 * guessed) / word.length());
            //Number of letters that need to be replaced by Blank spaces
            int lettersToBeChanged = (oneLine.length * percentOfDataToBeShown) / 100;


            while(lettersChanged < lettersToBeChanged){
                int upperbound = oneLine.length;
                //generating random index for a number that has to be replaced
                int random_number = rand.nextInt(upperbound);
                if(oneLine[random_number] == ' '){
                    lettersChanged--;
                }else {
                    oneLine[random_number] =' ';
                }
                lettersChanged++;
            }
            //Printing the new image
            String string = new String(oneLine);
            System.out.println(string);

            lineNumber++;

        }
        System.out.println();
    }

    /**
     * Reads the user Input from console
     * @return User Input
     */
    public static String readUserInput() {
        String guess = "";
        System.out.print("> ");
        if ( readGuess.hasNext() ) {
            guess = readGuess.nextLine();
        }
        return guess;
    }

    /**
     * Starts the Picture game.
     * takes input from both the players
     * @param args : input from command line.
     */

    public static void start(String[] args){
        //Stores the values of the argument values
        player1Name = args[0];
        superManFileName = args[1];
        player2Name = args[2];
        batManFileName = args[3];

        // Converts program input of the word into lower case to ensure that the lower cases are compared.
        String wordOne = getWord(0).toLowerCase();
        String wordTwo = getWord(1).toLowerCase();

        //Converting the word of both the players in character array
        firstWord = wordOne.toCharArray();
        secondWord = wordTwo.toCharArray();

        //Initializing the storing capacity of player1's word
        storing = new char[firstWord.length];
        for(int i=0;i<firstWord.length;i++){
            storing[i]='_';
        }

        //Initializing the storing capacity of player2's word
        storing2 = new char[secondWord.length];
        for(int i=0;i<secondWord.length;i++){
            storing2[i]='_';
        }

        int indexOfInput = 0;

        while(!wordGuessed){
            //Taking alternate input from user and moving to player one and player two respectively
            if(indexOfInput%2==0){
                System.out.println(player1Name+" turn (........):");
                // Converts user input of the word into lower case.
                String userInput = readUserInput().toLowerCase().trim();
                compareWordsFromPlayerOne(wordOne,userInput);

            }else {
                System.out.println(player2Name+" turn (........):");
                // Converts user input of the word into lower case.
                String userInput = readUserInput().toLowerCase().trim();
                compareWordsFromPlayerTwo(wordTwo,userInput);

            }
            indexOfInput++;
        }
    }

    /**
     * Randomly selects the word from the given file and return the word.
     * @return the randomly selected word from file.
     */
    public static String getWord(int a) {
        return theWords[a];
    }

    public static void main( String [] args ) {
        wordFileName = args[5];
        readWordsFromFile(wordFileName);
        start(args);
    }
}