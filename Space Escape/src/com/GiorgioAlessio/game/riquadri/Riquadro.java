package com.GiorgioAlessio.game.riquadri;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.GiorgioAlessio.game.Gioco;
import com.GiorgioAlessio.game.Maneggiatore;

/*Definizione della classe "Riquadro" che definisce le caratteristiche di un riquadro.*/
public abstract class Riquadro
{
	/*Attributi statici.*/
	public static ArrayList<Riquadro> riquadri = new ArrayList<Riquadro>();
	
	public static Riquadro riquadroVuoto = new RiquadroVuoto(0);
	public static Riquadro riquadroPavimento = new RiquadroPavimento(1);
	public static Riquadro riquadroPavimentoCavi = new RiquadroPavimentoCavi(2);
	public static Riquadro riquadroPavimentoCratere = new RiquadroPavimentoCratere(3);
	public static Riquadro riquadroPavimentoSangue = new RiquadroPavimentoSangue(4);
	public static Riquadro riquadroMuroSu = new RiquadroMuroSu(5);
	public static Riquadro riquadroMuroSx = new RiquadroMuroSx(6);
	public static Riquadro riquadroMuroGi� = new RiquadroMuroGi�(7);
	public static Riquadro riquadroMuroDx = new RiquadroMuroDx(8);
	public static Riquadro riquadroMuroGraffioSu = new RiquadroMuroGraffioSu(9);
	public static Riquadro riquadroMuroGraffioSx = new RiquadroMuroGraffioSx(10);
	public static Riquadro riquadroMuroGraffioGi� = new RiquadroMuroGraffioGi�(11);
	public static Riquadro riquadroMuroGraffioDx = new RiquadroMuroGraffioDx(12);
	public static Riquadro riquadroMuroCaviSu = new RiquadroMuroCaviSu(13);
	public static Riquadro riquadroMuroCaviSx = new RiquadroMuroCaviSx(14);
	public static Riquadro riquadroMuroCaviGi� = new RiquadroMuroCaviGi�(15);
	public static Riquadro riquadroMuroCaviDx = new RiquadroMuroCaviDx(16);
	public static Riquadro riquadroMuroCratereSu = new RiquadroMuroCratereSu(17);
	public static Riquadro riquadroMuroCratereSx = new RiquadroMuroCratereSx(18);
	public static Riquadro riquadroMuroCratereGi� = new RiquadroMuroCratereGi�(19);
	public static Riquadro riquadroMuroCratereDx = new RiquadroMuroCratereDx(20);
	public static Riquadro riquadroPortaSu = new RiquadroPortaSu(21);
	public static Riquadro riquadroPortaSx = new RiquadroPortaSx(22);
	public static Riquadro riquadroPortaGi� = new RiquadroPortaGi�(23);
	public static Riquadro riquadroPortaDx = new RiquadroPortaDx(24);
	public static Riquadro riquadroObl�Su = new RiquadroObl�Su(25);
	public static Riquadro riquadroObl�Sx = new RiquadroObl�Sx(26);
	public static Riquadro riquadroObl�Gi� = new RiquadroObl�Gi�(27);
	public static Riquadro riquadroObl�Dx = new RiquadroObl�Dx(28);
	public static Riquadro riquadroSpigoloSu = new RiquadroSpigoloSu(29);
	public static Riquadro riquadroSpigoloSx = new RiquadroSpigoloSx(30);
	public static Riquadro riquadroSpigoloGi� = new RiquadroSpigoloGi�(31);
	public static Riquadro riquadroSpigoloDx = new RiquadroSpigoloDx(32);
	public static Riquadro riquadroSpigoloSuInverso = new RiquadroSpigoloSuInverso(33);
	public static Riquadro riquadroSpigoloSxInverso = new RiquadroSpigoloSxInverso(34);
	public static Riquadro riquadroSpigoloGi�Inverso = new RiquadroSpigoloGi�Inverso(35);
	public static Riquadro riquadroSpigoloDxInverso = new RiquadroSpigoloDxInverso(36);
	
	/*Metodi e attributi di classe.*/
	public static final int LARGHEZZA_RIQUADRO = 64, ALTEZZA_RIQUADRO = 64;
	
	protected BufferedImage texture;
	
	protected final int id;
	
	protected Maneggiatore maneggiatore;

	public Riquadro(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		
		this.maneggiatore = Gioco.maneggiatore;
		
		riquadri.add(id, this);
	}
	
	public void aggiornamento()
	{
		
	}
	
	public void renderizzazione(Graphics disegnatore, int x, int y)
	{
		disegnatore.drawImage(texture, x, y, LARGHEZZA_RIQUADRO, ALTEZZA_RIQUADRO, null);
	}
	
	public abstract boolean �Solido();
	
	public abstract boolean isAperto();
	
	public abstract boolean renderizzaSotto();
	
	public abstract Riquadro getRiquadro();
	
	public int getId()
	{
		return id;
	}
	
	/*public static int nRiquadri()
	{
		return 
	}*/
}