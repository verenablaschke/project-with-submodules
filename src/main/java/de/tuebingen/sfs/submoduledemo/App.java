package de.tuebingen.sfs.submoduledemo;

import de.tuebingen.sfs.submodulefromroot.SubmoduleFromRoot;

public class App {
	public static void main(String args[]) {
		greet();
		SubmoduleFromRoot.greet();
	}
	
	public static void greet(){
		System.out.println("Running the main project");
	}
}
