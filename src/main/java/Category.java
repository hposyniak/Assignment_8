//    Yuri Manna, i6316134
//    Helena Posyniak, i6303009
//    A new class, it has a name and a list of questions

import java.util.LinkedList;
public class Category {

    private String name;
    private LinkedList questions = new LinkedList();

    public int howManyQuestionsLeft(){

        return questions.size();
    }

    public Category(String name) {
        // constructor method
        this.name = name;
    }

    public String getName() {
        // name getter
        return name;
    }

    public void addQuestion(int i) {
        // adds a question to the list


        questions.addLast(getName() + " Question " + i);

    }
    public void removeQuestion(){
        // removes a question from the list

        System.out.println(questions.removeFirst());

    }
}