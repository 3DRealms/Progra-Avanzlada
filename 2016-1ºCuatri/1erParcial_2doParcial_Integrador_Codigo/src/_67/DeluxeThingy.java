package _67;

/*
class Thingy {
	Meter m = new Meter();
}
 */
class Component { 
	void go() { 
		 System.out.print("c"); 
	}
}

class Meter extends Component {
	void go() {
		System.out.print("m");
	}
}
class DeluxeThingy extends Thingy {
	 public static void main(String[] args) {
		 DeluxeThingy dt = new DeluxeThingy();
		 dt.m.go();
		 Thingy t = new DeluxeThingy();
		 t.m.go();
	 }
 }


/*
Which two are true? (Choose two.)
A. The output is mm.					[X]
B. The output is mc.
C. Component is-a Meter.
D. Component has-a Meter.
E. DeluxeThingy is-a Component.
F. DeluxeThingy has-a Component.		[X]
*/