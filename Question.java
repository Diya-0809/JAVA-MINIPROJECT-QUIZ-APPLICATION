/**
 * =====================================================
 * QUIZ APPLICATION - QUESTION CLASS
 * =====================================================
 * Holds ONE question with options and answer
 */
public class Question {
    
    // Variables to store question details
    private String question;      
    private String[] options;     
    private String correctAnswer; 
    private int marks;            
    
    // Constructor
    public Question(String question, String[] options, String correctAnswer, int marks) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer.toUpperCase();
        this.marks = marks;
    }
    
    // Check if user's answer is correct
    public boolean isCorrect(String userAnswer) {
        return correctAnswer.equals(userAnswer.toUpperCase());
    }
    
    // Display question with options
    public String displayQuestion() {
        StringBuilder sb = new StringBuilder();
        sb.append(question).append("\n");
        for (int i = 0; i < options.length; i++) {
            sb.append("   ").append((char)('A' + i)).append(") ").append(options[i]).append("\n");
        }
        return sb.toString();
    }
    
    // Getters
    public String getQuestion() { return question; }
    public String[] getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
    public int getMarks() { return marks; }
}