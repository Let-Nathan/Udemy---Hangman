import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String[] words = {
            "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"
    };



    //          TODO
    // 1 - Pick a random word.
    // 2 - User need to guess ~
    //          Loose: if 6  mistake.
    //          Win: if guess the word.
    //
    // 3 - Display wrong char as "Misses :"
    // 4 - Display current guesses as "Word: _ _ _ _ " ( _ = nbr of character to guess).
    // 5 - Construct the hangman and display it

    // Function
    // checkChar
    //


    //Possible add :
    // -> Add / create a word
    // -> Init game function

    public static void main(String[] args) {

        String guessWord = words[randomNumber()];
        System.out.println("Welcome to the Hangman game !\nChoose a letter and good luck :)\n");
        gameInit(guessWord);
        int error = 0;
        char userPick;
        StringBuilder codeWord = codedWord(guessWord);
        StringBuilder wrongChar =  new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            userPick = userPick();

            if (isWrongPick(userPick, guessWord)) {
                error++;
            }
            System.out.println("Guess: " + userPick + "\n");
            System.out.println(gallows[error]);

            System.out.println("Word: " + codeWord);
            if (error > 0) {
                wrongChar.append(userPick);
                System.out.println("Missies: " + wrongChar);
            } else {

                System.out.println("Missies: ");
            }

        }




    }

    public static void gameInit(String word){
        System.out.println("Guess: ");
        System.out.println(gallows[0]);
        System.out.println(codedWord(word) );
        System.out.println("Missies :");

    }

    /**
     * Function name: randomNumber
     *
     * @return int range from 0 ~ 58.
     */
    public static int randomNumber () {
        int min = 0;
        int max = 58;
        return (int) Math.floor(Math.random() * (max - min + 1)+ min );
    }

    /**
     * Function name: userPick
     *
     * Inside function:
     *  1. Scan the user input.
     *  2. Check if it's letter from a-Z.
     *  3. Return char.
     *
     * @return userGuess ( char )
     */
    public static char userPick() {
        Scanner scan = new Scanner(System.in);
        char userGuess = scan.next().charAt(0);
        for (int i = 0; i < 1; i++) {
            if (!isValidLetter(userGuess)) {
                System.out.println("Please input a valid letter from a to z");
                userGuess = scan.next().charAt(0);
                i--;
            } else {
                i = 1;
            }
        }
        return userGuess;
    }

    /**
     * Function name: isValidLetter
     *
     * @param userGuess ( char )
     * @return bool
     */
    public static boolean isValidLetter(char userGuess) {
        return Character.isLetter(userGuess);
    }

    public static boolean isWrongPick (char userPick, String word) {
        for(int i = 0; i < words.length; i++) {
            if(word.charAt(i) != userPick) {
                return true;
            }

        }
        return false;
    }

    /**
     * Function name: codedWord
     *  Inside function:
     *      1. Loop through word
     *      2. Encode char with underscore only if word do not contain userPick char
     * @param word ( String )
     * @return underscoreWord ( char[] ) with char replace by underscore.
     */
    public static StringBuilder codedWord (String word) {
        StringBuilder underscoreWord = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
             {
                underscoreWord.append("_" + " ");
            }
        }
        return underscoreWord;
    }


    /**
     *
     */
    public static String[] gallows =
            {
                    "+---+\n" +
                            "|   |\n" +
                            "    |\n" +
                            "    |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n",

                    "+---+\n" +
                            "|   |\n" +
                            "O   |\n" +
                            "    |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n",

                    "+---+\n" +
                            "|   |\n" +
                            "O   |\n" +
                            "|   |\n" +
                            "    |\n" +
                            "    |\n" +
                            "=========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|   |\n" +
                            "     |\n" +
                            "     |\n" +
                            " =========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +
                            "     |\n" +
                            "     |\n" +
                            " =========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +
                            "/    |\n" +
                            "     |\n" +
                            " =========\n",

                    " +---+\n" +
                            " |   |\n" +
                            " O   |\n" +
                            "/|\\  |\n" +
                            "/ \\  |\n" +
                            "     |\n" +
                            " =========\n"
            };
}
