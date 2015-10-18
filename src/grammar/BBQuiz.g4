grammar BBQuiz;

@header {import components.bbquiz.Quiz; import components.bbquiz.Answer; import components.bbquiz.QuizType;}

file returns [String header, List<Quiz> data]
@init {$data = new ArrayList<Quiz>();}
 : (quiz {$data.add($quiz.elem);})+ // list of quiz
   EOF
 ;

quiz returns [Quiz elem]
@init {$elem = new Quiz(); }
 : q=LineText {$elem.setQuestion($q.text.trim());} LineBreak
   ( a=LineText {Answer answer = new Answer(); answer.setText($a.text.trim()); $elem.addAnswer(answer); }
     ('\t' 'X' { answer.setCorrect(true); } )?
     (LineBreak)
   )+
   (LineBreak)*
 ;

LineBreak
 : '\r'? '\n'
 | '\r'
 ;

LineText
 : (~[\r\n\t])+
 ;

// necessary to remove trailing spaces
Spaces
: [ \u000B\t\r\n]
;


// INT : DIGIT+ ;

// fragment DIGIT : [0-9] ;
// fragment SPACE : [ \u000B\t] ;
// fragment LETTER : [a-zA-Z\u0080-\u00FF_] ;
// fragment LINEBREAK  : '\r'? '\n' | '\r' ;