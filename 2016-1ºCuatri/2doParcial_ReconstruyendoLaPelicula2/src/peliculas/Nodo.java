package peliculas;



	public class Nodo{
		//Attributes
		private int color;
		private int grado;
		private String etiqueta;

		//Constructors
		public Nodo(){
			this(0,0, "");
		}
		public Nodo(int color, int grado, String etiqueta){
			this.color = color;
			this.grado = grado;
			this.etiqueta = etiqueta;
		}

		//Getters-Setters
		public void setColor(int color) {
			this.color = color;
		}
		public int getColor() {
			return color;
		}
		public int getGrado() {
			return grado;
		}
		public void setEtiqueta(String etiqueta) {
			this.etiqueta = etiqueta;
		}
		public String getEtiqueta() {
			return etiqueta;
		}

		//Public Methods
		public void incrementarGrado(){
			this.grado++;
		}
		public void decrementarGrado(){
			this.grado--;
		}
		
		public Nodo clone(){
			Nodo nuevo = new Nodo(this.color, this.grado, this.etiqueta);
			return nuevo;		
		}
		public String toString(){
			return this.etiqueta;
		}
	}



