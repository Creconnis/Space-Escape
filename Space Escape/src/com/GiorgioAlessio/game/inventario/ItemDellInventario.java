package com.GiorgioAlessio.game.inventario;

import com.GiorgioAlessio.game.Maneggiatore;
import com.GiorgioAlessio.game.items.Item;
import com.GiorgioAlessio.game.stati.Stato;
import com.GiorgioAlessio.game.stati.StatoVittoria;

public class ItemDellInventario
{
	private Item item;
	private int quantit�;
	private Maneggiatore maneggiatore;
	
	public ItemDellInventario(Maneggiatore maneggiatore, Item item, int quantit�)
	{
		this.maneggiatore = maneggiatore;
		this.item = item;
		this.quantit� = quantit�;
	}
	
	public boolean usaItem()
	{
		boolean usato = false;
		
		item.setTimer(item.getTimer() + System.currentTimeMillis() - item.getTimerUltimaVolta());
		item.setTimerUltimaVolta(System.currentTimeMillis());
		
		if(item.getTimer() < item.getAttesa())
		{
			return usato;
		}
		else
		{
			switch(item.getId())
			{
				case 0:
					if(maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() < 100)
					{
						int salutePrecedente = maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute();
						
						maneggiatore.getMondo().getManagerEntit�().getGiocatore().setSalute(
								maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() + 30);
						
						if(maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() > 100)
						{
							maneggiatore.getMondo().getManagerEntit�().getGiocatore().setSalute(100);
						}
						
						maneggiatore.getMondo().getManagerEntit�().getGiocatore().setDannoCurato(
								maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() - salutePrecedente);
						maneggiatore.getMondo().getManagerEntit�().getGiocatore().setCurato(true);
					}
					usato = true;
					break;
				case 1:
					if(maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() < 100)
					{
						int salutePrecedente = maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute();
						
						maneggiatore.getMondo().getManagerEntit�().getGiocatore().setSalute(
								maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() + 10);
						
						if(maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() > 100)
						{
							maneggiatore.getMondo().getManagerEntit�().getGiocatore().setSalute(100);
						}
						
						maneggiatore.getMondo().getManagerEntit�().getGiocatore().setDannoCurato(
								maneggiatore.getMondo().getManagerEntit�().getGiocatore().getSalute() - salutePrecedente);
						maneggiatore.getMondo().getManagerEntit�().getGiocatore().setCurato(true);
					}
					usato = true;
					break;
				case 2:
					usato = maneggiatore.getMondo().getManagerEntit�().ricarica();
					break;
				case 3:
					maneggiatore.getMondo().getManagerEntit�().getGiocatore().getInventario().setSePass(true);
					usato = true;
					break;
				case 4:
					maneggiatore.getGestoreMouse().setGestoreUi(null);
					maneggiatore.getGioco().resettaStati();
					maneggiatore.getGioco().setStatoVittoria(new StatoVittoria(maneggiatore));
					Stato.setStato(maneggiatore.getGioco().statoVittoria);
					break;
				default:
					break;
			}
		}
		
		item.setTimer(0);
		
		return usato;
	}

	public Item getItem()
	{
		return item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public int getQuantit�()
	{
		return quantit�;
	}

	public void setQuantit�(int quantit�)
	{
		this.quantit� = quantit�;
	}
}