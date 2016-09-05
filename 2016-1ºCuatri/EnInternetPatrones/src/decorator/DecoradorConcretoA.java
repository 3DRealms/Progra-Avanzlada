package decorator;

public class DecoradorConcretoA extends Decorador{
    private String propiedadAñadida;

    public DecoradorConcretoA(Componente componente){
        super(componente);
    }

    public void operacion(){
            super.operacion();
            propiedadAñadida = "Nueva propiedad";
            System.out.println("DecoradorConcretoA.operacion()");
    }
}