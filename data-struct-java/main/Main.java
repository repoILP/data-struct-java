
import dinamicarray.MyDinamicArray;

public class Main {
	public static void main(String[] args) {
		System.out.println("---------------------Dinamica array test --------------------");
		MyDinamicArray<Integer> dinamicArray = new MyDinamicArray<Integer>();
		
		for(int i = 0; i <= 10; i++)
		{
			dinamicArray.add(i * 2);			
		}
		dinamicArray.add(4);
		dinamicArray.order();
		dinamicArray.debugShow();
		
	}
}
