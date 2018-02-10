import java.util.Scanner;
public class ArrayLimites {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int longitud = 0, inferior = 0, superior = 0, dentro = 0, fuera = 0, sumaDentro = 0, sumaFuera = 0, cont = 0;
		int lista[];
		int listaFuera[]; //este array almacenara los elementos que esten fuera, la longitud sera como maximo la misma que lista
		//Peticion de datos al usuario
		System.out.println("Por favor, introduce la longitud de la lista de numeros: ");
		longitud = teclado.nextInt();
		System.out.println("Por favor, introduce el limite inferior: ");
		inferior = teclado.nextInt();
		System.out.println("Por favor, introduce limite superior: ");
		superior = teclado.nextInt();
		listaFuera = new int[longitud];
		lista = new int[longitud]; //creo el array lista con la longitud especificada por el usuario
		//le pido al usuario que rellene le array
		for (int i = 0; i < lista.length; i++) {
			System.out.println("Por favor introduce un numero entero.");
			lista[i] = teclado.nextInt();
		}
		teclado.close(); //cierro el objeto teclado porque no lo voy a volver a usar
		//bucle que recorre el array del usuario y va modificando las variables de acuerdo a las especificaciones del ejercicio
		for (int i = 0; i < lista.length; i++){
			if (lista[i] >= inferior && lista[i] <= superior){
				dentro++;
				sumaDentro += lista[i];
			} else {
				sumaFuera += lista[i];
				fuera++;
				listaFuera[cont] = lista[i];
				cont++; //uso un contador independiente para este array para que no queden huecos
			}
		}
		System.out.print("Dentro: " + dentro + " Suma dentro: " + sumaDentro + " Suma fuera: " + sumaFuera + " Array fuera: ");
		if (fuera != 0){ //compruebo si hay elemntos fuera del rango para saber que mostrar
			for (int i = 0; i < fuera; i++) {
				System.out.print(listaFuera[i] + " ");
			}
		} else System.out.print("No hay");
	}

}
