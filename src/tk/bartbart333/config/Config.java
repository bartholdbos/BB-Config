package tk.bartbart333.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private File file;
	private Properties config = new Properties();
	
	public Config(String config){
		file = new File(config + ".config");
		
		if(!file.exists()){
			try{
				file.getParentFile().mkdirs();
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void load(){
		try{
			config.load(new FileInputStream(file));
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void store(){
		try{
			config.store(new FileOutputStream(file), null);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key){
		return config.getProperty(key);
	}
	
	public int getIntProperty(String key) throws NumberFormatException{
		return Integer.valueOf(config.getProperty(key));
	}
	
	public void setProperty(String key, String value){
		config.setProperty(key, value);
	}
}