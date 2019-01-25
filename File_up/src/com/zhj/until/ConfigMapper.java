package com.zhj.until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ConfigMapper {
	private static ConfigMapper config;
	  private Properties properties;
	  
	  
	  public ConfigMapper(){
		  String configFile="database.properties";
		  InputStream in=ConfigMapper.class.getClassLoader().getResourceAsStream(configFile);
		  properties =new Properties();
		  try {
			properties.load(in);
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	  }
	  
	  //提供给外界一个唯一的ConfigManager对象  使用static是静态方法  可以通过类名直接调用 synchronized让懒汉模式避免了线程不安全
	  public  static synchronized ConfigMapper getInstance(){
		  if(config==null){
			  config = new ConfigMapper();  
		  }
		return config;
	  }
	  
	  //根据属性文件中的键获得对应的值
	  public String getString(String key){
		  return properties.getProperty(key);
		  
	  }

}
