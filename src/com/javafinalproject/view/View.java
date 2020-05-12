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
		System.out.println("2. Insertar vocablos al traductor");
		System.out.println("-1. Salir");
	}

	public static void exmenu(int choise) throws Exception {
		boolean ok = false;

		switch (choise) {
		case 1:
			DataConnection.translator();
			break;
		case 2:
			DataConnection.writer();
			break;
		case -1:
			System.exit(0);
			break;
		default:
			throw new Exception("El numero debe ser 1, 2 o -1");
		}
		if (choise != -1) {
			System.out.println("Presiona intro para continuar");
			menu();
			choise = numero.nextInt();
			exmenu(choise);
		}
	}
}