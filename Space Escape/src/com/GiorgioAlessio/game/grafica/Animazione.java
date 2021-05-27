package com.GiorgioAlessio.game.grafica;

import java.awt.image.BufferedImage;

public class Animazione
{
	private int velocit�,i;
	private BufferedImage[] frame;
	private long ultimaVolta,timer;
	
	public Animazione(int velocit�, BufferedImage[] frame)
	{
		this.velocit� = velocit�;
		this.frame = frame;
		i = 0;
		ultimaVolta = System.currentTimeMillis();
		timer = 0;
	}
	
	public void aggiornamento()
	{
		timer = timer + System.currentTimeMillis() - ultimaVolta;
		ultimaVolta = System.currentTimeMillis();
		
		if(timer > velocit�)
		{
			i++;
			timer = 0;
			
			if(i >= frame.length)
			{
				i = 0;
			}
		}
	}
	
	public BufferedImage getFrameCorrente()
	{
		return frame[i];
	}
}
