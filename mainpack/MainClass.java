package mainpack;


import util.Utils;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		// afisare moment de timp in care incepe programul
		Utils.printOutMessagesWithTimestamp(" Start prelucrare imagine"); 
		String bmpInputFileName=null;
		int scale=0;
		String bmpOutputFileName=null;
		
		if (args.length != 2){
			System.out.println("Va rog introduceti parametri de intrare: fileName si scale!");
			System.exit(0);
		}else{
			bmpInputFileName = args[0];
			scale = new Integer(args[1]);
		}

		Scanner myObj = new Scanner(System.in);
		System.out.println("Introduceti numele fisierului de iesire <zzz.bmp>:");
	    String fileName = myObj.nextLine();  // Citire valoare introdusa de la tastatura
	    bmpOutputFileName =fileName;
	    

		BmpFile inputFile = new BmpFile();
		inputFile.setFileName(bmpInputFileName);
		
		ReadBmpFile b = new ReadBmpFile(inputFile);
		Producator p1 = new Producator("Producator",b,bmpInputFileName);
		Consumator c1 = new Consumator("Consumator",b,scale, bmpOutputFileName);
		p1.start();
		c1.start();
	}
}
