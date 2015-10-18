import components.Quiz
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ANTLRInputStream
import parser.BBQuizLexer
import parser.BBQuizParser

// command line configuration

def cli = new CliBuilder(usage:'bbquiz <bbquizfile>')
cli.o(longOpt:'output', args:1, argName:'file', 'Set the output file')
def options = cli.parse(args)

// resolving options

List<String> inputFileNameList = options.arguments()
String outputFileName = options.o

// main script

println("bbquiz - converting a textfile with quizzes to a BlackBoard batch file")

if (options.arguments().size() == 0) {
    cli.usage()
} else {
    for (fileName in inputFileNameList) {
        boolean error = false
        println("reading from file " + fileName);

        if (!(new File(fileName)).exists()) {
            // the input source
            println("sorry, file " + fileName + " not found or not valid.");
            return
        }

        FileInputStream source = new FileInputStream(fileName);

        // create an instance of the lexer
        BBQuizLexer lexer = new BBQuizLexer(new ANTLRInputStream(source));

        // wrap a token-stream around the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create the parser
        BBQuizParser parser = new BBQuizParser(tokens);

        // invoke the entry point of our grammar
        def out = parser.file()

        List<Quiz> quizList = out.data


        println("bbquiz loaded")

        String output = ""

        if (outputFileName == 'false') outputLogFileName = fileName.replaceFirst(~/\.[^\.]+$/, '') + ".log"
        else outputLogFileName = outputFileName.replaceFirst(~/\.[^\.]+$/, '') + ".log"

        // log for check
        // pretty print + some final evaluation

        output = ""
        quizList.each() { quiz ->
            output += quiz.print()
        }
        File outputLogFile = new File(outputLogFileName)
        def w = outputLogFile.newWriter() // for rewriting
        w << output
        w.close()

        // final format
        output = ""
        quizList.each() { quiz ->
            output += quiz.bbprint()
        }
        if (outputFileName == 'false') outputFileName = fileName.replaceFirst(~/\.[^\.]+$/, '') + ".2bb"
        File outputBBFile = new File(outputFileName)
        w = outputBBFile.newWriter() // for rewriting
        w << output
        w.close()

        println("bbquiz exported to " + outputFileName +"\nready to be uploaded!")
    }
}


