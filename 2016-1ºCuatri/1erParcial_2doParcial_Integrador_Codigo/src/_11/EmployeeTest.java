package _11;

class person{
	String name="No name";
	public person(String nm){
	   name=nm;
	}
}
class Employee extends person{
	String empID="0000";
	public Employee(String id){
		empID=id;
	}
}
public class EmployeeTest{
	public static void main(String[] args){
		Employee e = new Employee("4321");
		System.out.println(e.empID);
	}
}

/*
A. 4321
B. 0000
C. An exception is thrown at runtime.
D. Compilation fails because of an error in line 11	[X]
*/