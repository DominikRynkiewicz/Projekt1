public class Main {

    public static void main(String[] args) throws Exception{
        Game game = new Game("movies.txt");

        System.out.println("Welcome to our game: Guess the Movie!");
        System.out.println("The rules are simple, the computer randomly picks a movie title, and shows you how many letters it's made up of.");
        System.out.println("Your goal is to try to figure out the movie by guessing one letter at a time.");
        System.out.println("If a letter is indeed in the title the computer will reveal its correct position in the word, if not, you lose a point");
        System.out.println("If you lose 10 points, game over!");
        System.out.println("But the more correct letters you guess the more obvious the movie becomes and at a certain point you should be able to figure it out.");
        System.out.println("Do you want to try...?\n");
        System.out.println("The movie title has " + game.movieTitle().length() + " characters (including letters, spaces and punctuation marks).");

        while(!game.gameEnded()){
            System.out.println("You are guessing:" + game.hiddenMovieTitle());
            System.out.println("You have guessed " + game.inputtedWrongLetters().length() + " wrong letters:"
                    + game.inputtedWrongLetters());
            game.guessLetter();
        }
        if(game.gameWon()){
            System.out.println("You have won!");
            System.out.println("You have guessed '" + game.movieTitle() + "' correctly.");
        }
        else{
            System.out.println("You have guessed (" + game.inputtedWrongLetters().length() + ") wrong letters:" +
                    game.inputtedWrongLetters());
            System.out.println("You have lost!");
            System.out.println("The movie title is '" + game.movieTitle() + "'");
            System.out.println("You should try one more time!");
        }
    }
}


