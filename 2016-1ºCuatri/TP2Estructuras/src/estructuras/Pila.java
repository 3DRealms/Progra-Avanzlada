package estructuras;

public interface Pila {
	public boolean empty( ); // pila_vacia
	public void push(Object dato ) ; //poner_en_pila
	public Object pop( ); //sacar_de_pila
	public Object peek( ); //ver_el_tope
	public void vaciar( ); //vaciar_pila
}
