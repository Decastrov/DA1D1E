import java.util.Scanner;
public class SucesionNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int inicial = 0, incremento = 0, limite = 0, siguiente = 0;
		String resultado = "";
		boolean primera = true;
		//solicitud de datos al usuario
		System.out.println("Por favor, introduce un numero inicial");
		inicial = teclado.nextInt();
		System.out.println("Por favor, introduce el incremento");
		incremento = teclado.nextInt();
		System.out.println("Por favor, introduce un limite");
		limite = teclado.nextInt();
		teclado.close(); //cierro el objeto teclado por que no lo voy a usar mas
		//compruebo que los datos son correctos antes de operar
		if (inicial > limite || incremento <= 0 || limite <= 0) {
			System.out.println("Error.");
		} else {
			siguiente = inicial; //le doy a siguiente el valor inicial por la forma de operar dentro (para no hacer incremento + 0 en la primera vuelta)
			while(true){
				//compruebo si es la primera vuelta que doy en el bucle para imprimir solo esta vez el valor inicial
				if (primera){
					resultado += inicial + " ";
					primera = false;
				}
				siguiente += incremento;
				if (siguiente <= limite){
					resultado += siguiente + " ";
				} else break;
			}
			// quito el espacio del final y cambio todos los espacios por 'coma espacio' para ajustarme a las especificaciones del output
			resultado = resultado.trim();
			resultado = resultado.replaceAll(" ", ", ");
			System.out.println(resultado);
		}
	}

}
