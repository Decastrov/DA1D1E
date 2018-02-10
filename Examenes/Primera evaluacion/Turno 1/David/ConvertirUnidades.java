import java.util.Scanner;
public class ConvertirUnidades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		final double RATIO = 2.5; //defino el ratio de conversion: 1 pulgada = 2.5 cm 
		double total = 0;
		String strUser = "", limpia = "", extension = "";
		String trozos[];
		boolean formato = true, punto = false;
		System.out.println("Por favor, introduce dato");
		strUser = teclado.nextLine();
		teclado.close();
		
		if (strUser.indexOf(".") >= 0) punto = true; //compruebo si tiene un punto para saber como tratar el input
		if (strUser.endsWith("cm") || strUser.endsWith("in")){
			//limpio el string introducido para dejar solo el numero y me guardo la extension
			if (strUser.endsWith("cm")) {
				extension = "cm";
				limpia = strUser.replaceAll("cm", "");
			}
			else {
				extension = "in";
				limpia = strUser.replaceAll("in", "");
			}
			
			if (punto){ //si el string tiene punto compruebo que tanto la parte entera como la decimal la forman solo enteros
				trozos = limpia.split("\\.");
				for (int i = 0; i < trozos[0].length(); i++){
					if (!Character.isDigit(trozos[0].charAt(i))) {
						formato = false;
						break;
					}
				}
				for (int i = 0; i < trozos[1].length(); i++){
					if (!Character.isDigit(trozos[1].charAt(i))) {
						formato = false;
						break;
					}
				}
			} else {
				for (int i = 0; i < limpia.length(); i++){
					if (!Character.isDigit(limpia.charAt(i))) {
						formato = false;
						break;
					}
				}
			}
		} else {
			formato = false;
		}
		//si la cadena cumple las restricciones del formato se hace la conversion, si no se muestra mensaje de error
		if (formato){
			if (extension.equals("cm")){
				// convertir de centimetros  a pulgadas
				total = Double.parseDouble(limpia) / RATIO;
				System.out.println(limpia + " centimetros equivalen a " + total + " pulgadas.");
			} else {
				//convertir de pulgadas a centimetros
				total = Double.parseDouble(limpia) * RATIO;
				System.out.println(limpia + " pulgadas equivalen a " + total + " centimetros.");
			}
		} else System.out.println("La cadena no tiene un formato correcto.");
	}

}
