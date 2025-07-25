package kjavac;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import kjavac.ast.ParsedFile;
import kjavac.generated.KStarLexer;
import kjavac.generated.KStarParser;
import kjavac.generated.KStarParser.FileContext;
import kjavac.visitor.TreeVisitor;

public final class Kjavac {

	private Kjavac() {}
	
	public static void main(String[] args) throws IOException {
		String path_to_compile = "src\\test\\resources\\parsertest.ks";
		System.out.println("Compiling: " + System.getProperty("user.dir") + "src\\test\\resources\\helloworld.ks ...");
		CharStream in = CharStreams.fromPath(Path.of(path_to_compile), Charset.defaultCharset());
		KStarLexer lexer = new KStarLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        KStarParser parser = new KStarParser(tokens);
        FileContext tree = parser.file();
        ParsedFile f = new TreeVisitor().visitFile(tree);
		
	}

}
