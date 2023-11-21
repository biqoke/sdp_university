import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UserManager {
    Map<String, UserProfile> users;
    private String filePath = "user_data.txt";
    private Exercises exercises;
    private Scanner scanner;
    public UserManager() {
        users = new HashMap<>();
        loadUserData();
        exercises = new Exercises();
        UserProfile userProfile = new UserProfile();  // Use the default constructor
        exercises.registerObserver(userProfile); // Register UserProfile as an observer
        scanner = new Scanner(System.in);
    }

    public UserProfile getUser(String username) {
        return users.get(username);
    }

    public void registerUser(String username, String password) {
        if (!users.containsKey(username)) {
            UserProfile userProfile = new UserProfile(username, password);
            users.put(username, userProfile);
            saveUserData();

            System.out.println("Регистрация успешна!");
            loginUser(userProfile);
        } else {
            System.out.println("Пользователь с таким именем уже существует.");
        }
    }

    public void loginUser(UserProfile userProfile) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш логин:");
        String username = scanner.next();
        System.out.println("Введите ваш пароль:");
        String password = scanner.next();

        if (userProfile.getUsername().equals(username) && userProfile.getPassword().equals(password)) {
            System.out.println("Вход выполнен успешно! Добро пожаловать, " + userProfile.getUsername());
            loginUserOptions(userProfile);
        } else {
            System.out.println("Неверное имя пользователя или пароль. Пожалуйста, попробуйте снова.");
        }

        scanner.close();
    }

    private void loginUserOptions(UserProfile userProfile) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int userChoice;

        do {
            System.out.println("Выберите действие: ");
            System.out.println("1) Уровень языка");
            System.out.println("2) Упражнения");
            System.out.println("3) Словарь");
            System.out.println("4) Мой профиль");
            System.out.println("5) Выход");

            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Раздел Уровень языка");
                    Game g = new Game();
                    g.start();
                    userProfile.setLanguageLevel(g.languageLVL);
                    break;
                case 2:
                    System.out.println("Раздел Упражнения");
                    exercises.go();
                    userProfile.incrementLessonsCompleted();
                    break;
                case 3:
                    System.out.println("Раздел Словарь");
                    useDictionary();
                    break;
                case 4:
                    System.out.println("Раздел Мой профиль");
                    System.out.println("Имя пользователя: " + userProfile.getUsername());
                    System.out.println("Пароль: " + userProfile.getPassword());
                    System.out.println("Количество пройденных уроков: " + userProfile.getLessonsCompleted());
                    System.out.println("Выбранный язык: " + userProfile.getSelectedLanguage());
                    System.out.println("Уровень языка: " + userProfile.getLanguageLevel());
                    System.out.println("Хотите ли вы отредактировать свой профиль? (да-1/нет-2)");
                    String editChoice = scanner.next();

                    if (editChoice.equalsIgnoreCase("1")) {
                        editUserProfile(userProfile);
                    }
                    break;
                case 5:
                    System.out.println("Выход. До свидания, " + userProfile.getUsername() + "!");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                    break;
            }

        } while (userChoice != 5);

        scanner.close();
    }

    private void editUserProfile(UserProfile userProfile) {
        System.out.println("Введите новый пароль:");
        String newPassword = scanner.next();
        userProfile.setPassword(newPassword);
        saveUserData();

        System.out.println("Введите выбранный язык:");
        String selectedLanguage = scanner.next();
        userProfile.setSelectedLanguage(selectedLanguage);

        saveUserData();

        System.out.println("Изменения сохранены. Профиль обновлен.");
    }
    private void loadUserData() {

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.put(parts[0], new UserProfile(parts[0], parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл с данными пользователей. Создается новый файл.");
        }
    }

    private void saveUserData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (UserProfile userProfile : users.values()) {
                writer.println(userProfile.getUsername() + "," + userProfile.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void useDictionary() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:");
        System.out.println("1) Добавить слово в словарь");
        System.out.println("2) Перевести слово на русский");
        int choice = scanner.nextInt();

        DictionaryFactory dictionaryFactory = new EnglishRussianDictionaryFactory();
        Dictionary dictionary = dictionaryFactory.createDictionary();

        if (choice == 1) {
            System.out.println("Введите слово на английском:");
            String englishWord = scanner.next();
            System.out.println("Введите перевод на русский:");
            String russianTranslation = scanner.next();

            Word word = new EnglishRussianWord(englishWord, russianTranslation);
            dictionary.addWord(word);
            System.out.println("Слово добавлено в словарь.");

        } else if (choice == 2) {
            System.out.println("Введите слово на английском:");
            String inputWord = scanner.next();

            String translation = dictionary.translate(inputWord);

            if (translation.equals("Перевод невозможен")) {
                System.out.println("Перевод не найден.");
            } else {
                System.out.println("Перевод: " + translation);
            }

        } else {
            System.out.println("Неверный выбор.");
        }

    }
}