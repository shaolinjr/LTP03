package dados;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Visita {
	private static int contVisitas = 0;
	
	private int numVisita = 0;
	private String cpf;
	private GregorianCalendar entrada;
	private GregorianCalendar saida;
	private float tempoPermanencia = 0;
	
	public Visita (String cpf){
		this.cpf = cpf;
		entrada = new GregorianCalendar();
		numVisita = contVisitas++;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public GregorianCalendar getSaida() {
		return saida;
	}

	public void setSaida(GregorianCalendar saida) {
		this.saida = saida;
		// fazer calculo de permanencia
		GregorianCalendar entrada = getEntrada();
		this.tempoPermanencia = (saida.getTimeInMillis() - entrada.getTimeInMillis())/(1000*60);
	}

	public float getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(float tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}

	public static int getContVisitas() {
		return contVisitas;
	}

	public int getNumVisita() {
		return numVisita;
	}

	public GregorianCalendar getEntrada() {
		return entrada;
	}

	public String toString() {
		return "Nº Visita:         " + numVisita + 
			 "\nCPF:               " + cpf + 
			 "\nEntrada:           " + new SimpleDateFormat("EEEE - dd/MM/yyyy - HH:mm").format(entrada.getTime()) + 
			 "\nSaída:             " + (saida == null? "":new SimpleDateFormat("EEEE - dd/MM/yyyy - HH:mm").format(saida.getTime())) +
			 "\nTempo Permanencia: " + (tempoPermanencia == 0 ? "": tempoPermanencia) + "minuto(s)";
	}
	
	
	
}
