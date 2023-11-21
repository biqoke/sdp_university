public interface ExerciseSubject {
    void registerObserver(ExerciseObserver observer);
    void removeObserver(ExerciseObserver observer);
    void notifyObservers(int score, int totalWords);
}
