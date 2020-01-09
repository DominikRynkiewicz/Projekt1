import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class MovieList {

    ArrayList<String> movies = new ArrayList();

    public MovieList(String pathname) throws Exception {
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            movies.add(scanner.nextLine());
        }
    }

    public String randomMovie() {

        int movieIndex = (int) (Math.random() * movies.size()) + 1;
        return movies.get(movieIndex);
    }
}

public class Game {

    private String movieToGuess;
    private String rightLetters;
    private String wrongLetters;
    private int lostPoints;
    private boolean hasWon;


    public Game(String pathname) throws Exception {
        MovieList movieList = new MovieList(pathname);
        movieToGuess = movieList.randomMovie();
        rightLetters = "";
        wrongLetters = "";
        lostPoints = 0;
        hasWon = false;
    }

    public String movieTitle() {

        return movieToGuess;
    }

    public String hiddenMovieTitle() {
        if(rightLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        }
        else{
            return movieToGuess.replaceAll("[a-zA-Z&& [^" + rightLetters +"]]", "_");
        }
    }

    public String inputtedWrongLetters() {

        return wrongLetters;
    }

    public boolean gameWon() {

        return hasWon;
    }

    public boolean gameEnded() {
        if (lostPoints >= 10) {
            return true;
        }

        if(!hiddenMovieTitle().contains("_")) {
            hasWon = true;
            return true;
        }
        else
            return false;
    }

    private String inputLetter(){

        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if(!letter.matches("[a-z]")){
            System.out.println("This is not a letter.");
            return inputLetter();
        }
        else if(wrongLetters.contains(letter) || rightLetters.contains(letter)){
            System.out.println("You have already guessed that letter.");
            return inputLetter();
        }
        else{
            return letter;
        }
    }

    public void guessLetter() {

        String guessedLetter = inputLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter;
        }
        else {
            lostPoints++;
            wrongLetters += guessedLetter;
        }
    }
}