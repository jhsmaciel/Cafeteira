import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.*;	
import java.text.DecimalFormat;

public class CafeteiraMetodos {
	DecimalFormat df = new DecimalFormat("#00");
	public double introduzMoney (double valor) throws IOException {
		double moedas;
		double valorMoedas=0;
		int acucar=0;
		int acucar1=0;
		int iff=0;
		int verifMoeda=0;
		try{
			do {
				acucar = Integer.parseInt(JOptionPane.showInputDialog("Adicionar açucar\n 1 - Sim\n 2 - Não"));
				if (acucar==1 || acucar==2){
					acucar1 = 1;
				}
			} while (acucar1!=1);
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Aceita apenas números" );
		}

		do {
			do {
				try{
					moedas = Double.parseDouble(JOptionPane.showInputDialog("Moedas de 5,10,25,50 e 100 centavos, digite apenas centavos").replace(",", "."));
				} catch (Exception e){
					System.out.println(e);
					//                 if(e.toString().contains("NullPointerException")){
					//                     int cancelar;
					//                     cancelar = Integer.parseInt(JOptionPane.showInputDialog("Cancelar? 1 - Sim / 2 - NÃ£o"));
					//                     switch(cancelar){
					//                         case 1: 
					//                             //devolver
					//                         case 2:
					//                             //
					//                     }
					//                 }
					moedas = 0;
				}

				if (moedas==5 || moedas==10){
					valorMoedas = (moedas/100)+valorMoedas;
					verifMoeda = 1;
				}
				else if (moedas==25 || moedas==50){
					valorMoedas = (moedas/100)+valorMoedas;
					verifMoeda = 1;
				}
				else if (moedas==100){
					valorMoedas = (moedas/100)+valorMoedas;
					verifMoeda = 1;
				}
				else {
					JOptionPane.showMessageDialog(null,"Valor de moeda inválido, digite novamente.");       
				}
				JOptionPane.showMessageDialog(null,"Valor acumulado: "+df.format(valorMoedas*100)+" centavos");
			} while (verifMoeda!=1);
			if (valorMoedas>=valor){
				iff=1;
			}
		} while (iff!=1);         
		return valorMoedas;
	}

	public double calculaTroco (double valor, double moedasCliente) throws IOException {
		double troco=0;
		if (valor<moedasCliente){
			troco = moedasCliente - valor;
		}
		JOptionPane.showMessageDialog(null,"O seu troco é de: "+df.format(troco*100)+" centavos");
		return troco;
	}

	public void calcularMoedas (double  troco ) throws IOException{
		double moedaCinco=0,moedaDez=0,moedaVinteC=0,moedaCinq=0,moedaCem=0;
		double resto;
		BigDecimal bd = new BigDecimal(troco).setScale(2, RoundingMode.HALF_EVEN);
		troco = bd.doubleValue();
		troco = troco*100;
		if (troco>99)
		{
			resto = troco%100;
			moedaCem = (troco-resto)/100;
			troco = troco - (moedaCem*100);
		}
		if (troco>49)
		{
			resto = troco%50;
			moedaCinq = (troco-resto)/50;
			troco = troco - (moedaCinq*50);
		}
		if (troco>24)
		{
			resto = troco%25;
			moedaVinteC = (troco-resto)/25;
			troco = troco - (moedaVinteC*25);
		}
		if (troco>9)
		{
			resto = troco%10;
			moedaDez = (troco-resto)/10;
			troco = troco - (moedaDez*10);
		}
		if (troco>4)
		{
			resto = troco%5;
			moedaCinco = (troco-resto)/5;
			troco = troco - (moedaCinco*5);
		}
		JOptionPane.showMessageDialog(null,df.format(moedaCinco)+" moedas de 5 \n "+df.format(moedaDez)+" moedas de 10\n "+df.format(moedaVinteC)+" moedas de 25\n "+df.format(moedaCinq)+" moedas de 50\n "+df.format(moedaCem)+" moedas de 100");
	}
}