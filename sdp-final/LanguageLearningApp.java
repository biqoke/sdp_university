import java.util.Scanner;

public class LanguageLearningApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();
        System.out.println("EngBro - изучайте языки бесплатно, весело и эффективно!");
        System.out.println("Выберите действие: (1) Зарегистрироваться, (2) Войти");
        int actionChoice = scanner.nextInt();

        if (actionChoice == 1) {
            System.out.println("Введите имя пользователя:");
            String username = scanner.next();
            System.out.println("Введите пароль:");
            String password = scanner.next();

            userManager.registerUser(username, password);
        } else if (actionChoice == 2) {
            System.out.println("Введите ваше имя пользователя:");
            String username = scanner.next();

            UserProfile userProfile = userManager.users.get(username);
            if (userProfile != null) {
                userManager.loginUser(userProfile);
            } else {
                System.out.println("Пользователь с таким именем не найден. Пожалуйста, зарегистрируйтесь.");
            }
        } else {
            System.out.println("Неверный выбор действия");
        }

        scanner.close();
    }
}