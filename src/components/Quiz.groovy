package components

class Quiz {
    String question
    List<Answer> answers = []

    void addAnswer(Answer answer) {
        answers << answer;
    }

    QuizType type() {
        if (answers.size() == 0) return QuizType.OpenQuestion
        else {
            if (answers.findAll { it.correct }.size() > 1)
                return QuizType.MultipleAnswers
            else
                return QuizType.MultipleChoice
        }
    }

    String print() {
        String output = "# "

        switch (type()) {
            case QuizType.MultipleAnswers: output += "MA"; break;
            case QuizType.MultipleChoice: output += "MC"; break;
            case QuizType.OpenQuestion: output += "ESS"; break;
        }

        output += " # " + question + "\n"

        if (answers.size() > 0) {
            answers.each { answer ->
                output += answer.text
                if (answer.correct) {
                    output += "\tcorrect"
                } else output += "\tincorrect"
                output += "\n"
            }
        }
        output += "\n"
    }

    String bbprint() {
        String output = ""

        switch (type()) {
            case QuizType.MultipleAnswers: output = "MA"; break;
            case QuizType.MultipleChoice: output = "MC"; break;
            case QuizType.OpenQuestion: output = "ESS"; break;
        }

        output += "\t" + question
        if (answers.size() > 0) {
            answers.each { answer ->
                output += "\t"
                output += answer.text
                if (answer.correct) {
                    output += "\tcorrect"
                }
                else output += "\tincorrect"
            }
        }
        output += "\n"
    }

}

enum QuizType { MultipleAnswers, MultipleChoice, OpenQuestion }

class Answer {
    String text
    boolean correct
}
