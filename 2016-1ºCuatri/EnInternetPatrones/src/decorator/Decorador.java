package decorator;

public abstract class Decorador extends Componente{
    private Componente _componente;
 
        public Decorador(Componente componente){
                _componente = componente;
        }
 
        public void operacion(){
                _componente.operacion();
        }
 }