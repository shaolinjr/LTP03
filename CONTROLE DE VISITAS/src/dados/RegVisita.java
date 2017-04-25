package dados;

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class RegVisita {
	private static int seq = 0;
	
	private int numRegistro;
	private String cpf;
	private GregorianCalendar regEntrada;
	private GregorianCalendar regSaida;
	private long tempoPermanencia;
	
	public RegVisita(String cpf) {
		numRegistro = ++seq;
		this.cpf = cpf;
		regEntrada = new GregorianCalendar();
	}

	public GregorianCalendar getRegSaida() {
		return regSaida;
	}

	public void setRegSaida(GregorianCalendar regSaida) {
		this.regSaida = regSaida;
	}

	public long getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(long tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}

	public int getNumRegistro() {
		return numRegistro;
	}

	public String getCpf() {
		return cpf;
	}

	public GregorianCalendar getRegEntrada() {
		return regEntrada;
	}
	
	public String toString() {
		return
				"Nº Registro: " + numRegistro + "\n" +
				"CPF: " + LtpUtil.formatarCPF(cpf) + "\n" +
				"Data e Hora Entrada: " + LtpUtil.formatarData(regEntrada, "dd/MM/yyyy HH:mm:ss") + "\n" +
				"Data e Hora Saida: " + (regSaida==null?"":LtpUtil.formatarData(regSaida, "dd/MM/yyyy HH:mm:ss")) + "\n" +
				"Tempo de Permanência: " + (tempoPermanencia==0?"":LtpUtil.formatarMilisegundos(tempoPermanencia)) + "\n";
				
	}
	
	
}
