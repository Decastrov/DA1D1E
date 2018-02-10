import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class Baraja {
	Stack<Carta> cartas;
	public void Barajar() {
		Collections.shuffle(cartas);
		/*
		Carta aux;		
		int pos;		
		// en cada pasada se escoge qué número va a ir a la posición i
		for(int i = 0; i < this.cartas.size() - 1; i++){
			// se escoge una posición aleatoria entre 0 y N - 1 - i
			pos = (int) (Math.random() * (this.cartas.size() -i)) + i;
			// se intercambia el número en esa posición con el de la posición i
			aux = this.cartas.get(i);
			this.cartas.set(i, this.cartas.get(pos));
			this.cartas.set(pos, aux);
		}*/
	}
	
	/**
	 * @return the cartas
	 */
	public Stack<Carta> getCartas() {
		return cartas;
	}
	public Baraja() {
		cartas = new Stack<Carta>();
		for(Palos p: Palos.values()) {
			for(Numeros n: Numeros.values()) {
				cartas.push(new Carta(p, n));
			}
		}
	}
	public Carta VerCarta() {
		return cartas.peek();
			
	}
	public Carta DarCarta() {
		Carta dada = cartas.pop();
		return dada;
	}
	public double Ordenador() {
		double contador = 0;
		while(contador<17) {
			System.out.println(cartas.peek());
			contador+= Baraja.this.VerCarta().getNumero().getCc();
			cartas.pop();
		}
		return contador;
	}
	public double CogerCarta() {
		double contador=0;
		System.out.println(cartas.peek());
		contador+= Baraja.this.VerCarta().getNumero().getCc();
		cartas.pop();
		return contador;
	}
	public Vector<Carta> siguientesCartas (int x) {
		Vector<Carta> sacadas = new Vector<Carta>();
		if(this.cartas.size()< x) {
			throw new IllegalArgumentException("No hay suficientes cartas");
		}
		for(int i=0; i<x; i++) {
			sacadas.add(cartas.pop());
		}
		return sacadas;
	}
	@SuppressWarnings("unchecked")
	public Vector[] repartirMano(int jugadores, int numCartas){
		Vector[] manos;
		if(this.cartas.size() < jugadores * numCartas) {
			 throw new IllegalArgumentException("No hay suficientes cartas");
		}
		//inicializar
		manos = new Vector[jugadores];
		for(int i = 0; i < jugadores; i++) {
			manos[i] = new Vector<Carta>();
		}
		for(int i = 0; i < numCartas; i++) {
			for(int j = 0; j < jugadores; j++) {
				manos[j].add(this.cartas.pop());
			}
		}			
		
		return manos;
	}
}