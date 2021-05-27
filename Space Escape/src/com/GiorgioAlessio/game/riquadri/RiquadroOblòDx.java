package com.GiorgioAlessio.game.riquadri;

import com.GiorgioAlessio.game.grafica.Animazione;
import com.GiorgioAlessio.game.grafica.Risorse;

public class RiquadroObl�Dx extends Riquadro
{
	private Animazione animazioneTile;
	
	public RiquadroObl�Dx(int id)
	{
		super(Risorse.obl�Dx[0], id);
		animazioneTile = new Animazione(500,Risorse.obl�Dx);
	}
	
	@Override
	public boolean �Solido()
	{
		return true;
	}

	@Override
	public boolean renderizzaSotto()
	{
		return false;
	}

	@Override
	public Riquadro getRiquadro()
	{
		return this;
	}
	
	@Override
	public void aggiornamento()
	{
		animazioneTile.aggiornamento();
		texture = animazioneTile.getFrameCorrente();
	}

	@Override
	public boolean isAperto()
	{
		return �Solido();
	}
}