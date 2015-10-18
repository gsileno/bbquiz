# bbquiz

*quiz importer for BlackBoard Learn* 

(still quite a prototype)

BlackBoard (http://blackboard.uva.nl) is the online didactic environment in use at the UvA (University of Amsterdam, http://uva.nl) and the VU (Vrij Universiteit, http://vu.nl), and plausibly in other universities as well. In order to fasten the creation of new quizzes for automatized evaluation, BlackBoard allows to upload them offline. Unfortunately, the batch file format is not easy to be handled by humans (see doc/bbguidelines.txt for further details).

Therefore, I made this script to work with a much simpler template!

## Usage 

* You need Java to be installed on your machine, and available at the command line.
* Download the *bbquiz.jar* file, https://github.com/s1l3n0/bbquiz/blob/master/bbquiz.jar?raw=true
* Convert your quiz file. For instance, executing this command you create ./examples/test.2bb:
```
> java -jar bbquiz.jar ./examples/test.bbquiz
```
* Upload it. Go on BlackBoard, and then *Control Panel > Course Tools > Tests, Surveys and Pools > Tests*.
Click on *Import Test* and select your .2bb file.

## The *.bbquiz* template

* A *.bbquiz* file consists of *multiple answers* (MA), *multiple choice* (MC), and *essay* (ESS) questions.  
* MA and MC are composed by a question and answers. The first line counts as the question; the following lines as the answers. An empty line means that the quiz has finished. The correct answers end with *<tab> + X* (pay attention: there is a tabulation, not empty spaces! The distinction between MA and MC is made automatically by the script. 
* ESS questions consist of a line with a text with the request, and *some empty space* in the following line.

example: ./examples/test.bbquiz
```
Multiple answer question?
This is a wrong response.
This is correct.	X

Multiple choice question?
This is a wrong response.
This is correct.	X
This is not correct as well.
This is correct, too.   X

Please write an essay.
 

Another question?
No, it is enough.   X
Yes, please.
```

output: ./examples/test.2bb
```
MC	Multiple answer question?	This is a wrong response.	incorrect	This is correct.	correct
MC	Multiple choice question?	This is a wrong response.	incorrect	This is correct.	correct	This is not correct as well.	incorrect	This is correct, too.   X	incorrect
ESS	Please write an essay.
MC	Another question?	No, it is enough.   X	incorrect	Yes, please.	incorrect
```
