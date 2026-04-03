/**
 * =====================================================
 * QUIZ APPLICATION - MAIN CLASS
 * =====================================================
 * Entry point - Creates and runs quiz
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("📚 JAVA QUIZ APP");
        System.out.println("=".repeat(30));
        
        // Create 3 questions
        Question[] questions = {
            new Question("2+2=?", new String[]{"3","4","5","6"}, "B", 10),
            new Question("Capital of India?", new String[]{"Delhi","Mumbai","Kolkata","Chennai"}, "A", 10),
            new Question("Java starts with?", new String[]{"new","main","class","public"}, "C", 10)
        };
        
        // Start quiz
        SimpleQuiz quiz = new SimpleQuiz(questions);
        quiz.start();
    }
}