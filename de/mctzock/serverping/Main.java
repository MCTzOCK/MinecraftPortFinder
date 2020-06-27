package de.mctzock.serverping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.mctzock.serverping.util.Ping;
import me.dilley.MineStat;

public class Main {
	
	public static int port = 25565;
	public static String host = "craftions.net";
	
	public static void main(String[] args) {
		System.out.println("ServerPing v. 1.1 by MCTzOCK using https://github.com/fragland/minestat/");
		if(args.length < 5)
		{
			System.out.println("Not enough args!");
			System.out.println("java -jar [filename.jar] [host] [min] [max] [logOfflineServers] ./[save.txt]");
		}else
		{
			host = args[0];
			int min = Integer.parseInt(args[1]);
			int max = Integer.parseInt(args[2]);
			Boolean logOffline = Boolean.parseBoolean(args[3]);
			File f = new File(args[4]);
			for(int i = min; i < max; i++)
			{
				Ping.ping(host, i, logOffline);
			}
			if(!f.exists())
			{
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				FileWriter w = new FileWriter(f);
				for(int i = 0; i < Ping.a.size(); i++)
				{
					w.write(Ping.a.get(i));
				}
				w.close();
			}catch (Exception ex) 
			{
				
			}
		}
	}
}
