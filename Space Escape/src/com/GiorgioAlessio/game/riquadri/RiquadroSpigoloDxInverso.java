package com.GiorgioAlessio.game.riquadri;

import com.GiorgioAlessio.game.grafica.Risorse;

public class RiquadroSpigoloDxInverso extends Riquadro
{
	public RiquadroSpigoloDxInverso(int id)
	{
		super(Risorse.spigoloInverso[1], id);
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