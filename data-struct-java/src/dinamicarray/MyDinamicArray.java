package dinamicarray;

public class MyDinamicArray <T> {
	private T[] elements; //internal array
	private int range; //array elements number
	
	//first constructor
	public MyDinamicArray() {
		this(10); //initial capacity = 10
	}
	
	//second constructor
	@SuppressWarnings("unchecked")
	public MyDinamicArray(int initialCapacity) {
		elements = (T[]) new Object[initialCapacity];
		range = 0;
	}
	
	//insert element on array final
	public void add(T element) {
		secureCapacity();
		elements[range++] = element;
	}
	
	//ensure capacity
	private void secureCapacity() {
		if(range == elements.length) {
			int newCapacity = elements.length * 2;
			T[] newArray = (T[]) new Object[newCapacity];
			System.arraycopy(elements, 0, newArray, 0, elements.length);
			elements = newArray;
		}
	}
	
	//get element by index
	public T get(int index) {
		if( index < 0 || index >= range ) {
			throw new IndexOutOfBoundsException("invalid index: " + index);
		}
		return elements[index];
	}
	
	//remove elements by index
	public void remove(int index) {
		if( index < 0 || index >= range ) {
			throw new IndexOutOfBoundsException("invalid index: " + index);
		}
		for(int i = index; i < range - 1; i++)
		{
			elements[i] = elements[i + 1];
		}
		elements[--range] = null; // no memory leak
	}
	
	//get range
	public int range() {
		return range;
	}
	
	//ordenation sort 
	public void order() {
		java.util.Arrays.sort(elements, 0, range);
	}
	
	//search index by element
	public int searchIndex(T element) {
		for(int i = 0; i < range; i++)
		{
			if(elements[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	//show for debug
	public void debugShow() {
		System.out.print("[ ");
		for(int i = 0; i < range; i++)
		{
			System.out.println(elements[i] + " ");
		}
		System.out.print(" ]");
	}
}
