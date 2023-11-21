public class UserProfile implements ExerciseObserver {
    private String username;
    private String password;
    private String selectedLanguage;
    private int lessonsCompleted;
    private String languageLevel;

    public UserProfile() {
    }

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
        this.lessonsCompleted = 0;
        this.selectedLanguage = "English";
        this.languageLevel = "-";
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public int getLessonsCompleted() {
        return lessonsCompleted;
    }

    public void incrementLessonsCompleted() {
        lessonsCompleted++;
    }
    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }
    @Override
    public void update(int score, int totalWords) {
        System.out.println("Уведомление: Вы получили " + score + " из " + totalWords + " баллов в упражнении.");
    }
}
