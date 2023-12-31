package kjavac;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import kjavac.components.Lexer;
import kjavac.syntax.Token;

public final class Kjavac {

	private Kjavac() {}
	
	public static void main(String[] args) throws IOException {
		/*
		if (args.length < 1) {
			System.out.println("Must include argument for file to be compiled!");
			System.exit(-1);
		}
		if (args.length > 1 && args[2].equals("-j")) {
			System.out.println("Not yet supported!");
			System.exit(0);
		}
		*/
		//String path = args[0];
		
		List<Token> l = Lexer.lexicalAnalysis(new Scanner("int main(){}"));
		
		l.forEach((t) -> System.out.println(t));
		
		
		
		
		
		
		
	}

}
