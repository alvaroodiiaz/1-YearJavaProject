package com.javafinalproject.view;

import java.util.Scanner;

import com.javafinalproject.data.DataConnection;

public class View {
	static Scanner numero = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		menu();
		int choise = numero.nextInt();
		exmenu(choise);
	}

	public static void menu() {
		System.out.println("1. Traductor Español/Choni");
		System.out.println("2. Traductor Choni/Español");
		System.out.println("3. Insertar vocablos al traductor");
		System.out.println("BONUS!!! 4. Visualizar .txt");
		System.out.println("-1. Salir");
	}

	public static void exmenu(int choise) throws Exception {
		boolean ok = false;

		switch (choise) {
		case 1:
			DataConnection.translatorSpaCan();
			break;
		case 2:
			DataConnection.translatorCanSpa();
			break;
		case 3:
			DataConnection.writer();
			break;
		case 4:
			DataConnection.showTxt();
			break;
		case -1:
			System.exit(0);
			break;
		default:
			throw new Exception("El numero debe ser 1, 2, 3, 4 o -1");
		}
	}
}