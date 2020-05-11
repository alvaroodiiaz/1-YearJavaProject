package com.javafinalproject.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileNotFoundException;

public class DataConnection {
	static Scanner numero = new Scanner(System.in);

	public static void muestraContenido() throws FileNotFoundException, IOException {
		String cadena;
		FileReader f = new FileReader("C:\\javaDAM\\vocablos.txt");
		BufferedReader b = new BufferedReader(f);
		while ((cadena = b.readLine()) != null) {
			System.out.println(cadena);
		}
		b.close();
	}

	public static void escribir() {
		System.out.println("Introduzca cadena");
		String cad = numero.nextLine();
		BufferedWriter bw;
		File Fichero = new File("C:\\javaDAM\\vocablos.txt");
		try {
			if (!Fichero.exists()) {
				Fichero.createNewFile();
			}

			bw = new BufferedWriter(new FileWriter(Fichero, true));
			bw.newLine();
			bw.write(cad);
			bw.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static final String SPLIT = ";";

	public static HashMap<String, String> traductor() throws IOException {
		HashMap<String, String> traductor = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\javaDam\\vocablos.txt"));
		String line, key, value;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, SPLIT);
			key = st.nextToken();
			value = st.nextToken();
			traductor.put(key, value);
		}
		return traductor;
	}

	public static void traduccion() throws IOException {
		System.out.println("Introduzca la key");
		String key = numero.nextLine();
		HashMap<String, String> traductor = traductor();
		System.out.println(traductor.get(key));
	}
}
