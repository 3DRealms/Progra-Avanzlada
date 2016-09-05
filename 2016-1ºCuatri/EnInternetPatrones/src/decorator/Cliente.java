package decorator;

public class Cliente{
    public static void main(String[] args){
            ComponenteConcreto c = new ComponenteConcreto();
            DecoradorConcretoA d1 = new DecoradorConcretoA(c);
            DecoradorConcretoB d2 = new DecoradorConcretoB(d1);
            d2.operacion();
    }
}