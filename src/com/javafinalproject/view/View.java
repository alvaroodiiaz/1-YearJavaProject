package com.javafinalproject.view;

import java.util.Scanner;

import com.javafinalproject.data.DataConnection;

public class View {

	public static void main(String[] args) throws Exception {
		Scanner numero = new Scanner(System.in);
		menu();
		int op = numero.nextInt();
		exmenu(op);
	}

	public static void menu() {
		System.out.println("1. Traductor Español/Choni");
		System.out.println("2. Insertar vocablos al traductor");
		System.out.println("-1. Salir");
	}

	private static void exmenu(int op2) throws Exception {
		boolean ok = false;

		switch (op2) {
		case 1:
			DataConnection.traduccion();
			break;
		case 2:
			DataConnection.escribir();
			break;
		case -1:
			System.exit(0);
			break;
		default:
			break;
		}
	}
}