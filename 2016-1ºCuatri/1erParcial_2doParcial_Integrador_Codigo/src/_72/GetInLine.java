package _72;
import java.util.*;
public class GetInLine {
	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<String>();
		pq.add("banana");
		pq.add("pear");
		pq.add("apple");
		System.out.println(pq.poll() + " " + pq.peek());
	}
}

/*
What is the result?
A. apple pear
B. banana pear
C. apple apple
D. apple banana			[X]
E. banana banana
*/