import java.io.IOException;

import javax.swing.JOptionPane;
public class Cafeteira {
	public static void main (String args[]) throws IOException{
		int opc=0;
		double valor;
		double moedasCliente;
		double troco;
		CafeteiraMetodos m = new CafeteiraMetodos();        
		while (opc!=9){
			try{
				opc = Integer.parseInt(JOptionPane.showInputDialog("Bem Vindo    \n 1 - Café Curto R$ 0,70\n 2 - Café Longo R$ 0,65\n 3 - Café C/ Leite R$ 0,80\n 4 - Capuccinno R$ 0,80\n 5 - Mocaccinno R$ 0,90\n 6 - Chocolate Quente R$ 0,75\n 7 - Chá R$ 0,55\n Com/Sem Açucar\n 9 - Sair"));
				switch (opc){
				case 1: 
					valor = 0.70 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;
				case 2: 
					valor = 0.65 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;
				case 3:
					valor = 0.80 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;
				case 4:
					valor = 0.80 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;
				case 5: 
					valor = 0.90 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;
				case 6: 
					valor = 0.75 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;
				case 7: 
					valor = 0.55 ;
					moedasCliente = m.introduzMoney(valor);
					troco = m.calculaTroco(valor,moedasCliente);
					m.calcularMoedas(troco);
					break;         
				case 9: JOptionPane.showMessageDialog(null,"Até a próxima");
						System.exit(0);
				break;
				default: JOptionPane.showMessageDialog(null,"Opção inválida"); 
				}
			} catch(NumberFormatException e){
				opc = 0;
			}
		}
	}
}
