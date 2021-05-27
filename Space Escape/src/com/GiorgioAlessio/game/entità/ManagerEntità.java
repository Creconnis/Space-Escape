package com.GiorgioAlessio.game.entit�;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.GiorgioAlessio.game.Maneggiatore;
import com.GiorgioAlessio.game.armi.Colpo;
import com.GiorgioAlessio.game.entit�.creatura.Giocatore;

public class ManagerEntit� {
	public static final int MUNIZIONI_MASSIME = 50;
	
	private Maneggiatore maneggiatore;
	private Giocatore giocatore;
	private ArrayList<Entit�> entit�;
	private ArrayList<Colpo> colpi;
	
	private boolean inventarioAttivo = false;
	private int nNemici;
	
	private Comparator<Entit�> selettoreRendering = new Comparator<Entit�>(){
		@Override
		public int compare(Entit� a, Entit� b)
		{
			if((a.getBordoCollisioni(0f,0f).y + a.getBordoCollisioni(0f,0f).height) < 
					(b.getBordoCollisioni(0f,0f).y + b.getBordoCollisioni(0f,0f).height))
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	};
	
	public ManagerEntit�(Maneggiatore maneggiatore, Giocatore giocatore)
	{
		this.maneggiatore = maneggiatore;
		this.giocatore = giocatore;
		entit� = new ArrayList<Entit�>();
		colpi = new ArrayList<Colpo>();
		aggiungiEntit�(giocatore);
		
		for(int i=0; i<MUNIZIONI_MASSIME; i++)
		{
			colpi.add(new Colpo(maneggiatore,0,0));
		}
	}
	
	public void aggiornamento() 
	{
		contaNemici();
		
		Iterator<Entit�> iteratore = entit�.iterator();
		
		while(iteratore.hasNext())
		{
			Entit� e = iteratore.next();
			e.aggiornamento();
			
			e.timerDanno = System.currentTimeMillis() - e.timerInizioDanno;
			
			if(e.isColpito() && (e.timerDanno >= e.attesaDanno))
			{
				e.setColpito(false);
			}
			
			if(!e.isAttivo())
			{
				iteratore.remove();
			}
		}
		
		Iterator<Colpo> iteratoreColpo = colpi.iterator();
		
		while(iteratoreColpo.hasNext())
		{
			Entit� e = iteratoreColpo.next();
			e.aggiornamento();
			
			e.timerDanno = System.currentTimeMillis() - e.timerInizioDanno;
			
			if(e.isColpito() && (e.timerDanno >= e.attesaDanno))
			{
				e.setColpito(false);
			}
			
			if(!e.isAttivo())
			{
				iteratoreColpo.remove();
			}
		}
		
		entit�.sort(selettoreRendering);
	}
	
	public void renderizzazione(Graphics disegnatore) 
	{
		for(Entit� e : entit�)
		{
			e.renderizzazione(disegnatore);
		}
		
		for(Colpo e : colpi)
		{
			e.renderizzazione(disegnatore);
		}
		
		for(Entit� e : entit�)
		{
			e.dopoRenderizzazione(disegnatore);
		}
	}
	
	public void aggiungiEntit�(Entit� e)
	{
		entit�.add(e);
	}
	
	//Metodi get/set

	public Maneggiatore getManeggiatore()
	{
		return maneggiatore;
	}

	public void setManeggiatore(Maneggiatore maneggiatore)
	{
		this.maneggiatore = maneggiatore;
	}

	public Giocatore getGiocatore()
	{
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore)
	{
		this.giocatore = giocatore;
	}

	public ArrayList<Entit�> getEntit�()
	{
		return entit�;
	}
	
	public Entit� getEntit�(int pos)
	{
		return entit�.get(pos);
	}

	public void setEntit�(ArrayList<Entit�> entit�)
	{
		this.entit� = entit�;
	}

	public ArrayList<Colpo> getColpi()
	{
		return colpi;
	}

	public void setColpi(ArrayList<Colpo> colpi)
	{
		this.colpi = colpi;
	}
	
	public boolean isInventarioAttivo() {
		return inventarioAttivo;
	}

	public void setInventarioAttivo(boolean inventarioAttivo) {
		this.inventarioAttivo = inventarioAttivo;
	}

	public int getNNemici()
	{
		return nNemici;
	}

	public void setNNemici(int nNemici)
	{
		this.nNemici = nNemici;
	}

	public void aggiungiColpi(int n)
	{
		for(int i=0; i<n; i++)
		{
			colpi.add(new Colpo(maneggiatore, 0, 0));
		}
	}
	
	public boolean ricarica()
	{
		boolean ricarica = false;
		
		for(int i = colpi.size(); i<MUNIZIONI_MASSIME; i++)
		{
			colpi.add(new Colpo(maneggiatore,0,0));
			ricarica = true;
		}
		
		return ricarica;
	}
	
	public void contaNemici()
	{
		int contaNemici = 0;
		
		for(Entit� e : entit�)
		{
			if(e.isSeNemico() && !e.isAnimMorente() && !e.isMorente())
			{
				contaNemici++;
			}
		}
		
		nNemici = contaNemici;
	}
}
