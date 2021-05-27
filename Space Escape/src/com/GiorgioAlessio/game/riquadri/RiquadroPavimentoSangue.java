package com.GiorgioAlessio.game.riquadri;

import com.GiorgioAlessio.game.grafica.Risorse;

/*Definizione di un riquadro di terra.*/
public class RiquadroPavimentoSangue extends Riquadro
{
	public RiquadroPavimentoSangue(int id)
	{
		super(Risorse.pavimentoSangue, id);
	}

	@Override
	public boolean �Solido()
	{
		return false;
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