package de.mctzock.serverping.util;

import java.io.File;
import java.util.ArrayList;

import me.dilley.MineStat;

public class Ping {
	
	public static ArrayList<String> a = new ArrayList<String>();
	
	public static void ping(String host, int port, boolean logOffline) {
		MineStat ms = new MineStat(host, port);
		if(ms.isServerUp())
		{
			System.out.println("Host: " + host + ", Port: " + port + ", Online: true, Players online: " + ms.getCurrentPlayers() + "/" + ms.getMaximumPlayers() + ", Protocol version: " + ms.getVersion());
			a.add("Host: " + host + ", Port: " + port + ", Online: true, Players online: " + ms.getCurrentPlayers() + "/" + ms.getMaximumPlayers() + ", Protocol version: " + ms.getVersion());
		}else
		{
			if(logOffline)
			{
				System.out.println("Host: " + host + ", Port: " + port + ", Online: false");
				a.add("Host: " + host + ", Port: " + port + ", Online: false");
			}
		}
	}
}
