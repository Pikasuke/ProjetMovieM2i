package com.m2i.paris.util;

import java.util.regex.Pattern;

public class Controle {

		public static boolean nom(String nom) {
			Boolean b = new Boolean(false);
			if (b = Pattern.matches("[a-zA-Z]{0-5}", nom)) {
				b=true;
			}
			return b;
		}
		
		public static boolean prenom(String nom) {
		return nom.matches("[a-zA-Z]{1,5}");
		}
		
		public boolean note(String nom) {
			return nom.matches("\\d{1,10}+(\\.{0,1}(\\d{0,3}))?$");
			}
		
		public boolean image(String nom) {
			return nom.matches("[^\\s]+(\\.(?i)(jpg|png|gif|bmp))$");
		}
		public boolean email(String nom) {
			return nom.matches("^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+\r\n" + 
					"(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$");
		}
		
}
