import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

public class Exercises implements ExerciseSubject {
    private ArrayList<WordToGuess> wordsToGuess;
    private ArrayList<WordPair> wordPairs;
    private WordMaskingContext wordMaskingContext;
    private List<ExerciseObserver> observers;

    public Exercises() {
        observers = new ArrayList<>();
        wordsToGuess = new ArrayList<>();
        wordsToGuess.add(new WordToGuess("guitar"));
        wordsToGuess.add(new WordToGuess("river"));
        wordsToGuess.add(new WordToGuess("forest"));
        wordsToGuess.add(new WordToGuess("telephone"));
        wordsToGuess.add(new WordToGuess("moon"));
        wordsToGuess.add(new WordToGuess("star"));
        Collections.shuffle(wordsToGuess);

        wordPairs = new ArrayList<>();
        wordPairs.add(new WordPair("дом", "house"));
        wordPairs.add(new WordPair("кошка", "cat"));
        wordPairs.add(new WordPair("стол", "table"));
        wordPairs.add(new WordPair("машина", "car"));
        wordPairs.add(new WordPair("книга", "book"));
        wordPairs.add(new WordPair("солнце", "sun"));
        Collections.shuffle(wordPairs);

        wordMaskingContext = new WordMaskingContext(new DefaultWordMaskingStrategy());
    }

    public void go() {
        Scanner scanner = new Scanner(System.in);
        int exerciseChoice;

        System.out.println("Выберите действие: ");
        System.out.println("1) Игра 'Угадай слово'");
        System.out.println("2) Игра 'Найди пару'");

        exerciseChoice = scanner.nextInt();

        if (exerciseChoice == 1) {
            System.out.println("Вы выбрали 'Угадай слово'");
            playGuessWordGame(scanner);
        } else if (exerciseChoice == 2) {
            System.out.println("Вы выбрали 'Найди пару'");
            matchTranslations(wordPairs);
        } else {
            System.out.println("Неверный выбор действия");
        }
    }

    private void playGuessWordGame(Scanner scanner) {
        int numCorrect = 0;
    
        System.out.println("Выберите сложность:");
        System.out.println("1) Стандартная");
        System.out.println("2) Невозможная");
    
        int strategyChoice = scanner.nextInt();
    
        if (strategyChoice == 1) {
            wordMaskingContext.setStrategy(new DefaultWordMaskingStrategy());
        } else if (strategyChoice == 2) {
            wordMaskingContext.setStrategy(new AllLettersMaskingStrategy());
        } else {
            System.out.println("Неверный выбор стратегии");
            return;
        }
    
        System.out.println("Угадайте слово:");
    
        for (WordToGuess word : wordsToGuess) {
            String maskedWord = wordMaskingContext.maskWord(word.getEnglishWord());
            System.out.print(word.getRussianWord() + ": " + maskedWord + " ");
            String userGuess = scanner.next();
    
            if (userGuess.equalsIgnoreCase(word.getEnglishWord())) {
                System.out.println("Правильно!");
                numCorrect++;
            } else {
                System.out.println("Неверно. Правильный ответ: " + word.getEnglishWord());
            }
        }
    
        notifyObservers(numCorrect, wordsToGuess.size());
    }

    private void matchTranslations(ArrayList<WordPair> pairsToMatch) {
        Scanner scanner = new Scanner(System.in);
        int numCorrect = 0;

        System.out.println("Найдите соответствие для каждого русского слова:");

        for (WordPair pair : pairsToMatch) {
            System.out.print(pair.getRussianWord() + ": ");
            String userGuess = scanner.next();

            if (userGuess.equalsIgnoreCase(pair.getEnglishWord())) {
                System.out.println("Правильно!");
                numCorrect++;
            } else {
                System.out.println("Неверно. Правильный ответ: " + pair.getEnglishWord());
            }
        }

        notifyObservers(numCorrect, pairsToMatch.size());
    }

    private static class WordToGuess {
        private String russianWord;
        private String englishWord;

        public WordToGuess(String englishWord) {
            this.russianWord = "";
            this.englishWord = englishWord;
        }

        public String getRussianWord() {
            return russianWord;
        }

        public String getEnglishWord() {
            return englishWord;
        }
    }

    private static class WordPair {
        private String russianWord;
        private String englishWord;

        public WordPair(String russianWord, String englishWord) {
            this.russianWord = russianWord;
            this.englishWord = englishWord;
        }

        public String getRussianWord() {
            return russianWord;
        }

        public String getEnglishWord() {
            return englishWord;
        }
    }

    private interface WordMaskingStrategy {
        String maskWord(String word);
    }

    private static class DefaultWordMaskingStrategy implements WordMaskingStrategy {
        @Override
        public String maskWord(String word) {
            char[] maskedChars = new char[word.length()];
            for (int i = 1; i < word.length() - 1; i++) {
                maskedChars[i] = '_';
            }
            maskedChars[0] = word.charAt(0);
            maskedChars[word.length() - 1] = word.charAt(word.length() - 1);
            return new String(maskedChars);
        }
    }

    private static class WordMaskingContext {
        private WordMaskingStrategy strategy;

        public WordMaskingContext(WordMaskingStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(WordMaskingStrategy strategy) {
            this.strategy = strategy;
        }

        public String maskWord(String word) {
            return strategy.maskWord(word);
        }
    }

    private static class AllLettersMaskingStrategy implements WordMaskingStrategy {
        @Override
        public String maskWord(String word) {
            char[] maskedChars = new char[word.length()];
            for (int i = 0; i < word.length(); i++) {
                maskedChars[i] = '_';
            }
            return new String(maskedChars);
        }
    }
    
    @Override
    public void registerObserver(ExerciseObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ExerciseObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(int score, int totalWords) {
        for (ExerciseObserver observer : observers) {
            observer.update(score, totalWords);
        }
    }

}
