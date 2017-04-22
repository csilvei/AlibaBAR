package persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Log {
	private String path;
	public Log(){
		this.path = System.getProperty("user.dir");
	}
		
	public void Escreve(String texto,Boolean tipo){
		
		File dir = new File(path);
		File arq = new File(dir, "log.txt");
		try {
			arq.createNewFile();
			FileWriter fileWriter = new FileWriter(arq, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			try{
				Date d = GregorianCalendar.getInstance().getTime();
				SimpleDateFormat format = new SimpleDateFormat();
				printWriter.println(format.format(d));
			}catch (Exception e) {
				printWriter.println("Ocorreu um erro!");
			}
			
			if (tipo == true){
				printWriter.println("Entrou no Bar");
			}else{
				printWriter.println("Saiu do Bar");
			}
			
			printWriter.println(texto);
			
			
			printWriter.flush();
			printWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
