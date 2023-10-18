import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class arrayquest {
    
    public static void main(String[] args){
        
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        // put your questions here!
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");
        questions.add("");
        answers.add("");

    
        Collections.shuffle(questions);
        Collections.shuffle(answers);

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {

            System.out.println("Question " + (i + 1) + ": " + questions.get(i));
            String userAnswer = sc.nextLine();

            if (userAnswer.equalsIgnoreCase(answers.get(i))) {
                System.out.println("Correct answer!\n");
            } else {
                System.out.println("Wrong answer. The correct answer is: " + answers.get(i) + "\n");
            }
        }
        
    }
}
