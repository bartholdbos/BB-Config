package tk.bartbart333.config;

import java.io.File;
import java.io.IOException;

public class Config {
	
	private File file;
	
	public Config(String config){
		file = new File(config + ".config");
		
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}