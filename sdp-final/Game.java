import java.util.*;

public class Game {
    private ArrayList<Question> questionSet;

    String languageLVL = "";
    public Game() {
        questionSet = new ArrayList<Question>();

        // Question 1
        String q1 = "Что из этого является одной из форм времени в английском языке?";
        String[] a1 = {"Present", "Short", "Natural", "Continuous"};
        questionSet.add(new Question(q1, a1, "Continuous"));

        // Question 2
        String q2 = "'Timmy's dog was running after me' В каком времени написано данное предложение?";
        String[] a2 = {"Present Simple", "Past Continuous", "Future Perfect", "Past Perfect"};
        questionSet.add(new Question(q2, a2, "Past Continuous"));

        // Question 3
        String q3 = "Слово 'водить' на английском языке в разном времени 'drive, drove, driven'";
        String[] a3 = {"Правда", "Ложь"};
        questionSet.add(new Question(q3, a3, "Правда"));

        // Question 4
        String q4 = "Какой глагол используется для выражения будущего времени в английском языке?";
        String[] a4 = {"Will", "Was", "Have", "Did"};
        questionSet.add(new Question(q4, a4, "Will"));

        // Question 5
        String q5 = "Какой артикль используется перед словом 'university'?";
        String[] a5 = {"A", "An", "The", "No article"};
        questionSet.add(new Question(q5, a5, "A"));

        // Question 6
        String q6 = "Как правильно написать вторую форму глагола 'go'?";
        String[] a6 = {"Go", "Went", "Gone", "Going"};
        questionSet.add(new Question(q6, a6, "Went"));

        // Question 7
        String q7 = "Как перевести на английский язык фразу 'Я часто хожу в кино'?";
        String[] a7 = {"I often go to the cinema.", "I go often to the cinema.", "I go cinema often.", "Often I go to the cinema."};
        questionSet.add(new Question(q7, a7, "I often go to the cinema."));

        // Question 8
        String q8 = "Какой предлог используется для выражения местоположения?";
        String[] a8 = {"In", "On", "At", "By"};
        questionSet.add(new Question(q8, a8, "In"));

        // Question 9
        String q9 = "Как правильно написать вторую форму глагола 'eat'?";
        String[] a9 = {"Eat", "Eaten", "Ate", "Eating"};
        questionSet.add(new Question(q9, a9, "Ate"));

        // Question 10
        String q10 = "Как перевести на английский язык фразу 'Я учусь в университете'?";
        String[] a10 = {"I study at the university.", "I studying university.", "I study in the university.", "I learn at university."};
        questionSet.add(new Question(q10, a10, "I study at the university."));

        // Question 11
        String q11 = "Какой артикль используется перед словом 'hour'?";
        String[] a11 = {"A", "An", "The", "No article"};
        questionSet.add(new Question(q11, a11, "An"));

        // Question 12
        String q12 = "Как правильно написать третью форму глагола 'write'?";
        String[] a12 = {"Write", "Writed", "Wrote", "Written"};
        questionSet.add(new Question(q12, a12, "Written"));

        // Question 13
        String q13 = "Как перевести на английский язык фразу 'Он всегда делает свою работу'?";
        String[] a13 = {"He always does his work.", "He always making his work.", "He always do his work.", "He always done his work."};
        questionSet.add(new Question(q13, a13, "He always does his work."));

        // Question 14
        String q14 = "Какой глагол используется для выражения совершенного времени?";
        String[] a14 = {"Have", "Has", "Had", "Having"};
        questionSet.add(new Question(q14, a14, "Had"));

        // Question 15
        String q15 = "Как перевести на английский язык фразу 'Она читает книгу каждый день'?";
        String[] a15 = {"She reads a book every day.", "She read a book every day.", "She reading a book every day.", "She has read a book every day."};
        questionSet.add(new Question(q15, a15, "She reads a book every day."));

        // Shuffle the questions
        Collections.shuffle(questionSet, new Random());
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int numCorrect = 0;
        for (int question = 0; question < questionSet.size(); question++) {
            System.out.println(questionSet.get(question).getQuestion());
            int numChoices = questionSet.get(question).getChoices().size();
            for (int choice = 0; choice < numChoices; choice++) {
                System.out.println((choice + 1) + ": " + 
                questionSet.get(question).getChoices().get(choice));
            }
            int playerAnswer = scan.nextInt();
            ArrayList<String> choiceSet = questionSet.get(question).getChoices();
            String correctAnswer = questionSet.get(question).getAnswer();
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);
            if (playerAnswer == correctAnswerIndex + 1) {
                numCorrect++;
            }
        }
        System.out.println("Правильные ответы: " + numCorrect);

        if(numCorrect >= 14){
            System.out.println("Уровень языка: C1");
            languageLVL = "C1";
        }
        else if (numCorrect < 14 && numCorrect > 11){
            System.out.println("Уровень языка: B2");
            languageLVL = "B2";
        }
        else if (numCorrect < 12 && numCorrect > 7){
            System.out.println("Уровень языка: B1");
            languageLVL = "B1";
        }
        else if (numCorrect < 8 && numCorrect > 4){
            System.out.println("Уровень языка: A2");
            languageLVL = "A2";
        }
        else if (numCorrect < 5){
            System.out.println("Уровень языка: A1");
            languageLVL = "A1";
        }

    }
}
