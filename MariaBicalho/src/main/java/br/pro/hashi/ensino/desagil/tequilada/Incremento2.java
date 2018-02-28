package br.pro.hashi.ensino.desagil.tequilada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Arrays;
public class Incremento2 {
	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader("labirinto.txt");
	    BufferedReader br = new BufferedReader(in);
		String line = br.readLine();
		while (line!=null) {
			LinkedList<String> l = new LinkedList<String>();
			for(int i = 0; i < line.length(); i++){
				
				//System.out.println(line.charAt(i));
				
				if(line.charAt(i)== '#' ){
					l.add("x");
				
				}else{l.add(" ");
				}
			}
			System.out.println(l.toString());    
	        line = br.readLine();
	    }
		in.close();
	}
	



}
