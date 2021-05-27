package com.GiorgioAlessio.game.riquadri;

import com.GiorgioAlessio.game.grafica.Risorse;

public class RiquadroMuroSu extends Riquadro
{
	public RiquadroMuroSu(int id)
	{
		super(Risorse.muro[0], id);
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
	public boolean isAperto()
	{
		return �Solido();
	}
}