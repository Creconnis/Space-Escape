package com.GiorgioAlessio.game.riquadri;

import com.GiorgioAlessio.game.grafica.Risorse;

public class RiquadroSpigoloGi� extends Riquadro
{
	public RiquadroSpigoloGi�(int id)
	{
		super(Risorse.spigolo[2], id);
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