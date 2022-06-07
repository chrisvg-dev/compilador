
package com.itsav.analizador;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	private static final String EXTENSION = "sy";

	public static void main(String[] args) throws IOException {
		System.out.println("Interfaz gráfica");
		GraphicCompiler gr = new GraphicCompiler();
		gr.show();
	}

}
