package kjavac;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import kjavac.generated.KStarLexer;
import kjavac.generated.KStarParser;
import kjavac.generated.KStarParser.FileContext;

public final class Kjavac {

	private Kjavac() {}
	
	public static void main(String[] args) throws IOException {
		CharStream in = CharStreams.fromString("1+2");
		KStarLexer lexer = new KStarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KStarParser parser = new KStarParser(tokens);
        FileContext tree = parser.file();
		
	}

}
