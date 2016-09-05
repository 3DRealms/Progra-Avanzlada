package redEmpresarial;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		RedEmpresarial re;
		re = new RedEmpresarial(new File("empresa.in"), new File("empresa.out"));
		re.resolver();
	}
	
}
