package decorator;

public class DecoradorConcretoB extends Decorador{
    public DecoradorConcretoB(Componente componente){
        super(componente);
    }
 
        public void operacion(){
                super.operacion();
                comportamientoAñadido();
                System.out.println("DecoradorConcretoB.operacion()");
        }
 
        public void comportamientoAñadido(){
                System.out.println("Comportamiento B añadido");
        }
 }