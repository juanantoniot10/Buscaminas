package control.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import modelo.Tablero;

public class TableroTest {

	Tablero tablero;
	
	@Test 
	public void testCalculaMinas(){
		tablero=new  Tablero((byte)5, (byte)5);
		tablero.colocarMina(2, 1);
		tablero.colocarMina(2, 3);
		//si el proceso calcularminas se ha hecho bien
		//el atributo alrededor de cada casilla debe coincidir con este resultado
		byte miResultado[][]={
				{0,0,0,0,0},
				{1,1,2,1,1},
				{1,0,2,0,1},
				{1,1,2,1,1},
				{0,0,0,0,0}};
		//cuando nos encontramos ante un metodo sin parametros ni retorno.
		//solo podemos comprobar que el efecto que este produce sobre las
		//propiedades de su clase es el correcto
		tablero.calcularMinasAlrededor();	
		for (int i = 0; i < miResultado.length; i++) {
			for (int j = 0; j < miResultado.length; j++) {
				assertEquals(miResultado[i][j], tablero.getCasillas()[i][j].getAlrededor());
			}
		}
	}
	@Ignore
	public void testDesvelarCasilla() {
			
		
	}

}
