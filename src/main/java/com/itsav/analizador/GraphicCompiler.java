package com.itsav.analizador;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class GraphicCompiler extends JFrame {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;
	
	private JTextArea txtCodigo;
	private JButton btnCompilar;
	private JLabel lblTitulo;
	
	public GraphicCompiler() {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Set the panel to add buttons
        JPanel panel = new JPanel();
         
        FlowLayout boxlayout = new FlowLayout();
        panel.setLayout(boxlayout);
        
		this.btnCompilar = new JButton("Compilar");
		this.lblTitulo = new JLabel("Compilador");
		this.lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		this.btnCompilar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Compilando...");
				try {
					String path = "test/code.sy";
					File archivo = new File(path);
					archivo.createNewFile();
					FileWriter fr = new FileWriter(archivo);
					fr.append( txtCodigo.getText() );
					fr.close();	
					
					compile(path);
					
				} catch (Exception e2) {
					System.out.println("ERROR AL GENERAR...");
				}
			}
		});
		this.btnCompilar.setFont(new Font("Arial", Font.BOLD, 20));
		
		this.txtCodigo = new JTextArea();
		this.txtCodigo.setFont(new Font("Arial", Font.ITALIC, 20));
		this.txtCodigo.setBorder(
				BorderFactory.createCompoundBorder(
				        txtCodigo.getBorder(), 
				        BorderFactory.createEmptyBorder(5, 5, 5, 5))
				);
		this.txtCodigo.setColumns(72);
		this.txtCodigo.setRows(23);
		
        panel.add(lblTitulo);
        panel.add(txtCodigo);    
        panel.add(btnCompilar);
        
		this.getContentPane().add(panel);
	}
	
	public void compile(String program) throws IOException {
		System.out.println("Interpreting file " + program);

		SyntaxLexer lexer = new SyntaxLexer(new ANTLRFileStream(program));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SyntaxParser parser = new SyntaxParser(tokens);

		SyntaxParser.StartContext tree = parser.start();

		SyntaxCustomVisitor visitor = new SyntaxCustomVisitor();
		visitor.visit(tree);

		System.out.println("Interpretation finished");
	}
	
}