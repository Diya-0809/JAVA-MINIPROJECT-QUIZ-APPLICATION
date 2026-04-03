/**
 * =====================================================
 * QUIZ APPLICATION - SIMPLEQUIZ CLASS
 * =====================================================
 * Console-based quiz engine with scoring and grading
 * 
 * @author Student Developer
 * @version 1.0
 * @since 2024
 */
import java.util.Scanner;

public class SimpleQuiz {
    private Question[] questions;
    private int score;
    private int total;
    
    public SimpleQuiz(Question[] q) {
        this.questions = q.clone();
        this.score = 0;
        this.total = 0;
        for (Question question : questions) {
            this.total += question.getMarks();
        }
    }
    
    public void start() {
        System.out.println("\n🎯 QUIZ STARTED!");
        System.out.println("Total: " + total + " marks\n");
        
        Scanner sc = new Scanner(System.in);
        score = 0;
        
        try {
            for (int i = 0; i < questions.length; i++) {
                Question q = questions[i];
                displayQuestion(i + 1, q);
                
                System.out.print("Your answer (A/B/C/D): ");
                String ans = sc.nextLine().trim().toUpperCase();
                
                if (q.isCorrect(ans)) {
                    score += q.getMarks();
                    System.out.println("✅ Correct! (+ " + q.getMarks() + " marks)\n");
                } else {
                    System.out.println("❌ Wrong! Correct answer: " + q.getCorrectAnswer() + "\n");
                }
            }
        } finally {
            sc.close();
        }
        
        showResult();
    }
    
    private void displayQuestion(int number, Question q) {
        System.out.println(number + ". " + q.getQuestion());
        System.out.print(q.displayQuestion());
        System.out.println();
    }
    
    private void showResult() {
        System.out.println("\n🏆 FINAL RESULT:");
        System.out.println("Score: " + score + " / " + total);
        double pct = (double) score / total * 100;
        System.out.printf("Percentage: %.1f%%\n", pct);
        
        String grade = getGrade(pct);
        System.out.println("Grade: " + grade);
        
        if (pct >= 90) System.out.println("🎉 Excellent!");
        else if (pct >= 70) System.out.println("👍 Good job!");
        else if (pct >= 50) System.out.println("📚 Keep studying!");
        else System.out.println("💪 Try again!");
    }
    
    private String getGrade(double percentage) {
        if (percentage >= 90) return "A+ ✅";
        else if (percentage >= 80) return "A ✅";
        else if (percentage >= 70) return "B ✅";
        else if (percentage >= 60) return "C PASS ✅";
        else if (percentage >= 50) return "D PASS ✅";
        else return "F FAIL ❌";
    }
}