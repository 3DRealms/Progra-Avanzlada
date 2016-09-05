package gatitos;

public class Puma extends Felino {
	public Puma (){
		System.out.println("Puma");
	}
	void go(){
		tipo = "p";
		//Si es protected o public tipo, anda asignar al tipo indirectamente
		System.out.println(this.tipo + super.tipo);
		//entender que tipo es unico por lo que ya sea por protected o public si accedo el dato va a ser el mismo para Felino que apra Puma
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Puma().go();
	}
}


/*
a)Puma pp
b)Felino ff
c)Puma pf
d)Felino Puma pp		Correcta
e)Felino Puma pf
f)Puma Felino ff
g)Compilation fail
h)Exception
*/