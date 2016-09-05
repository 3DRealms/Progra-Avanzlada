package metro;

public class ColaPrioridad {
		private Arista aristas[];
		private int ult;
		public ColaPrioridad(){
			aristas = new Arista[10];
			ult = 0;
		}		
		public boolean empty() {
			if(ult == 0)
				return true;
			return false;
		}
		public void offer(Arista data){
			ult ++;
			if(colaLlena())
				rezise();
			aristas[ult] = new Arista(data.getInicio(), data.getFin(), data.getCosto());
			int i = ult;
			Arista aux;
			while(i != 1 && aristas[i].getCosto() < aristas[i/2].getCosto()){
				aux = aristas[i];
				aristas[i] = aristas[i/2];
				aristas[i/2] = aux;
				i = i/2;
			}
		}		
		private void rezise() {
			Arista vec2[] =new Arista[aristas.length*2];
			for(int i=0; i < aristas.length; i++)
				vec2[i]=aristas[i];
			aristas=vec2;
		}
		public boolean colaLlena() {
			if(ult == aristas.length)
				return true;
			return false;
		}
		public void poll() {
			if(!empty()){
				if(ult == 1){
					aristas[ult] = null;
					ult = 0;
				}
				else{
					aristas[1] = aristas[ult];
					aristas[ult] = null;
					ult--;
					int i = 1;
					Arista aux;
					while( ( i*2 <=ult && aristas[i].getCosto() > aristas[i*2].getCosto() ) 
						|| (((i*2)+1) <= ult && aristas[i].getCosto() > aristas[(i*2)+1].getCosto() )){
						aux = aristas[i];
						if(( aristas[(i*2)+1] == null ) || ( aristas[i*2].getCosto() < aristas[(i*2)+1].getCosto() ) ){
							aristas[i] = aristas[i*2];
							aristas[i*2] = aux;
							i = i*2;
						}
						else{
							aristas[i] = aristas[(i*2)+1];
							aristas[(i*2)+1] = aux;
							i = (i*2)+1;
						}
					}
				}							
			}			
		}
		public Arista peek() {
			if(aristas[1] != null)
				return aristas[1];
			return null;
		}
}
