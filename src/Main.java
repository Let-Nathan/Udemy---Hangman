import java.lang.reflect.Array;
import java.util.ArrayList;
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


    //TODO
    //  1. Fix the displayed codeWord.
    //  2. Split code main function.

    public static void main(String[] args) {

        String guessWord = words[randomNumber()];

        gameInit(guessWord);

        int error = 0;
        char userPick;

        ArrayList<Character> codeWord = codedWord(guessWord);
        StringBuilder wrongChar = new StringBuilder();

        while(error <= 6 ) {
            if(isWin(codeWord,guessWord) ) {
                System.out.println("You win !!");
                break;
            }
            if(error == 6 ) {
                System.out.println("You loose !");
                break;
            }
            userPick = userPick();

            if (isWrongPick(userPick, guessWord)) {
                wrongChar.append(userPick);
                error++;
            } else {
                codeWord.set(guessWordIndex(userPick, guessWord),userPick);
            }

            System.out.println("Guess: " + userPick + "\n");
            System.out.println(gallows[error]);

            System.out.println("Word: " + codeWord);
            System.out.println("Missies: " + wrongChar);

        }
    }

    /**
     * Function name: isWin
     * Inside function:
     *  1. Count if codeWord == guessWord.
     *  2. return true if it's same length, false otherwise.
     * @param codeWord ( ArrayList<Character> )
     * @param guessWord ( String )
     * @return boolean
     */
    public static boolean isWin (ArrayList<Character> codeWord, String guessWord) {
        boolean isWin = false;
        int count = 0;
        for(int i = 0; i < guessWord.length(); i++) {
            if(codeWord.get(i) == guessWord.charAt(i) ) {
                count++;
            }
            if (count == guessWord.length() ) {
                isWin = true;
                break;
            }
        }
        return isWin;
    }

    /**
     * Function name: gameInit
     * Inside function: Display the game for first time.
     * @param word ( String )
     *
     */
    public static void gameInit(String word){
        System.out.println("Welcome to the Hangman game !\nChoose a letter and good luck :)\n");
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
     * function name: guessWordIndex
     *
     * @param userPick ( char )
     * @param guessWord ( String )
     * @return index ( null || int) if there is a match return int.
     *
     */
    public static Integer guessWordIndex(char userPick, String guessWord) {
        int index = 0;
        for(int i = 0; i < guessWord.length(); i++) {
            if(guessWord.charAt(i) == userPick)  {
                index = i;
            }
        }
        return index;
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

        boolean isWrongPick = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == userPick) {
                isWrongPick = false;
                break;

            }
        }
        return isWrongPick;
    }

    /**
     * Function name: codedWord
     *  Inside function:
     *      1. Loop through word
     *      2. Encode char with underscore only if word do not contain userPick char
     * @param word ( String )
     * @return underscoreWord ( char[] ) with char replace by underscore.
     */
    public static ArrayList<Character> codedWord (String word) {
        ArrayList<Character> underscoreWord = new ArrayList<Character>();
        for(int i = 0; i < word.length(); i++) {
             {
                underscoreWord.add('_');
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
