# bbquiz converter

*fast quiz importer for BlackBoard Learn* 

BlackBoard (http://blackboard.uva.nl) is the online didactic environment in use at the UvA (University of Amsterdam, http://uva.nl) and at the VU (Vrij Universiteit, http://vu.nl), and plausibly in other universities as well. In order to fasten the creation of new quizzes for automatized evaluation, BlackBoard allows to upload them offline. Unfortunately, the given batch file format is not so easy to be handled by humans (see doc/2bb.guidelines.txt for further details). Therefore, I made this simple parser to work with a more efficient template. 

## The *.bbquiz* template

example file: 'test.bbquiz'
```
Multiple answer question?
This is a wrong response.
This is correct.    X

Multiple choice question?
This is a wrong response.
This is correct.    X
This is not correct as well.
This is correct, too.   X

Please write an essay.


Another question?
No, it is enough.   X
Yes, please.

```

**Format specifications in brief**

* A *.bbquiz* file consists of *multiple answers* (MA), *multiple choice* (MC), and *essay* (ESS) quizzes.  
* MA and MC are composed by a question and answers. The first line counts as the question; the following lines as the answers. Empty lines separate the quizzes. **The correct answers end with '[tab]X'** (pay attention: there is a tabulation, not empty spaces!) The distinction between MA and MC is made automatically by the script. 
* ESS questions consist of a line with a text, and a following empty line. Note that you need another empty line to separate this quiz from the next one.

## Usage 

* If you don't need to modify the script, just download the *bbquiz.jar* file
* Write your .bbquiz file following the template given above.
* Convert it. For instance,
```
> java -jar bbquiz.jar test.bbquiz
```
This command creates the output, converted file 'test.2bb':
```
MC	Multiple answer question?	This is a wrong response.	incorrect	This is correct.	correct
MA	Multiple choice question?	This is a wrong response.	incorrect	This is correct.	correct	This is not correct as well.	incorrect	This is correct, too.	correct
ESS	Please write an essay.
MC	Another question?	No, it is enough.	correct	Yes, please.	incorrect
```
* Upload the converted file. Go on BlackBoard, open your course, and then *Control Panel > Course Tools > Tests, Surveys and Pools > Pools*. Click on *Build Pool*, and once created click on *Upload Questions* and select your .2bb file.

## Dependencies

* To run the script, you need only Java to be installed on your machine, and available from the command line.
* To hack it, you have to install Groovy, see http://www.groovy-lang.org. On Linux and Mac, you can easily install it via SDKMAN, http://sdkman.io/
* To compile the script, the following jars have to be added at compile time: groovy (*groovy-2.4.3*),  antlr4 (*antlr-4.5-complete*).

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create new Pull Request
