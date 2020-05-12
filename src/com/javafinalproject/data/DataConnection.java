package com.javafinalproject.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.javafinalproject.view.View;

import java.io.File;
import java.io.FileNotFoundException;

public class DataConnection {
	static Scanner scanner = new Scanner(System.in);

	public static void muestraContenido() throws FileNotFoundException, IOException {
		String line;
		FileReader f = new FileReader("C:\\javaDAM\\vocablos.txt");
		BufferedReader br = new BufferedReader(f);
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

	public static void writer() throws Exception {
		int choice = 1;
		while (choice == 1) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Introduzca cadena");
			String line = br.readLine();
			File file = new File("C:\\javaDAM\\vocablos.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.newLine();
			bw.write(line);
			bw.close();
			System.out.println("¿Quiere seguir escribiendo vocablos?");
			System.out.println("1. Si\n-1. No");
			choice = scanner.nextInt();
		} 
		if (choice != -1) {
			throw new Exception("El numero debe ser 1 o -1");
		} else {
			View.menu();
			int op = scanner.nextInt();
			View.exmenu(op);
		}
	}

	public static final String SPLIT = ";";

	public static void translator() throws Exception {
		HashMap<String, String> translator = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\javaDam\\vocablos.txt"));
		String line, key, value;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, SPLIT);
			key = st.nextToken();
			value = st.nextToken();
			translator.put(key, value);
		}
		br = new BufferedReader(new InputStreamReader(System.in));
		int choise=1;
		while (choise == 1) {
		System.out.println("Introduzca la palabra a traduccion");
		String word = br.readLine();
		System.out.println(translator.get(word));
		System.out.println("¿Quiere seguir traducciendo?");
		System.out.println("1. Si\n-1. No");
		choise = scanner.nextInt();
		}
		if (choise != -1) {
			throw new Exception("El numero debe ser 1 o -1");
		} else {
			View.menu();
			int op = scanner.nextInt();
			View.exmenu(op);
		}
	}
}
