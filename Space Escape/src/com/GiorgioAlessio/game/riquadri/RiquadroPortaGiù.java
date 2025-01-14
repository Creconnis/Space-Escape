package com.GiorgioAlessio.game.riquadri;

import java.awt.Graphics;

import com.GiorgioAlessio.game.grafica.Animazione;
import com.GiorgioAlessio.game.grafica.Risorse;

public class RiquadroPortaGi� extends Riquadro
{
	private Animazione animazioneTile;
	private boolean aperta;
	private boolean aperturaPorta;
	
	public RiquadroPortaGi�(int id)
	{
		super(Risorse.porta[2], id);
		animazioneTile = new Animazione(150,Risorse.portaGi�);
		
		aperta = false;
		aperturaPorta = false;
	}
	
	@Override
	public boolean �Solido()
	{
		if(aperta)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public Riquadro getRiquadro()
	{
		return this;
	}

	@Override
	public boolean renderizzaSotto()
	{
		if(aperta)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void aggiornamento()
	{
		seGiocatoreConPass();
		
		if(aperturaPorta)
		{
			animazioneTile.aggiornamento();
			texture = animazioneTile.getFrameCorrente();
			
			if(texture.equals(Risorse.portaGi�[3]))
			{
				aperturaPorta = false;
				aperta = true;
			}
		}
		else if(aperta)
		{
			texture = Risorse.portaGi�[3];
		}
		else
		{
			texture = Risorse.porta[2];
		}
	}
	
	@Override
	public void renderizzazione(Graphics disegnatore, int x, int y)
	{
		disegnatore.drawImage(texture, x, y, LARGHEZZA_RIQUADRO, ALTEZZA_RIQUADRO, null);
	}
	
	public void seGiocatoreConPass()
	{
		if(maneggiatore.getMondo().getManagerEntit�().getGiocatore().getInventario().isSePass() && !aperta)
		{
			aperturaPorta = true;
		}
	}

	@Override
	public boolean isAperto()
	{
		return aperta;
	}

	public void setAperto(boolean aperta)
	{
		this.aperta = aperta;
	}
}