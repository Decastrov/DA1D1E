import java.util.Scanner;

public class ComprobarMatricula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String strUser = "";
		boolean valida = true;
		System.out.println("Por favor, introduzca una matricula: ");
		strUser = teclado.nextLine();
		teclado.close();
		//compruebo que la longitud es 7 antes de comprobar que el string trenga el formato correcto
		if (strUser.length() == 7){
			//recorro la parte donde deberia haber numeros comprobando que efectivamente es asi, en otro caso la matricula no es valida
			for (int i = 0; i < 4; i++){
				if (!Character.isDigit(strUser.charAt(i))){
					valida = false; 
					break;
				}
			}
			//Aqui solo compruebo las letras si la parte correspondiente a los numeros esta correcta
			if (valida){
				//Recorro la parte donde deberia haber 3 consonantes mayusculas  comprobando que efectivamente es asi, en otro caso la matricula no es valida
				for (int i = 4; i < strUser.length(); i++){
					if (!Character.isAlphabetic(strUser.charAt(i)) || !Character.isUpperCase(strUser.charAt(i)) ||
							(strUser.charAt(i) == 'A' || strUser.charAt(i) == 'E' || strUser.charAt(i) == 'I' || strUser.charAt(i) == 'O' || strUser.charAt(i) == 'U')){
						valida = false;
						break;
					}
				}
			}
		} else valida = false;
		if (valida) System.out.println("Matricula valida");
		else System.out.println("Matricula no valida");
	}

}
