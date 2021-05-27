package com.GiorgioAlessio.game.riquadri;

import com.GiorgioAlessio.game.grafica.Risorse;

public class RiquadroMuroCaviGi� extends Riquadro
{
	public RiquadroMuroCaviGi�(int id)
	{
		super(Risorse.muroCavi[2], id);
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