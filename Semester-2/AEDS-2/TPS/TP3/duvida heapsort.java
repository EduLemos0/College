package sorting_methods;

import java.util.Scanner;

public class Heap_Sort {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		//supposing I have this array right here, let's turn it into a heap-max array
		
		int[] arr = {45, 567, 23 ,57 ,23 ,7 ,678 ,23 ,2,3 ,25, 68, 2,3,1};
		//int[] arr = {10, 20, 15, 30, 40};
		
		//so we wish to get this heap and generate a maxHeap from it
		SortHeap heap = new SortHeap(arr);
		
		heap.build();
		//heap.sort();
		heap.show();
		
		
	}
}


//create a class that will transform our unordered array into a heap structure
class SortHeap {
	
	private int arr[]; 
	
	//class constructor
	SortHeap(int[] arr) {this.arr = arr;} 
	
	//starting from 1st position, build the heap 
	
	void build() {
		for(int i = 1;i < arr.length; i++) build(i);
	}

	 void build(int i) {
		
		for(int j = i; j > 0 && arr[j] > arr[j/2]; j /= 2) {
			
			//swap variables
			int tmp = arr[j];
			arr[j] = arr[j/2];
			arr[j/2] = tmp;
		}
		
	}
	
	
	//HeapSort itself comes now
	void sort() {
		
		int size = arr.length;
		
		while(size > 0) {
			
			//reduce size
			size--;
			
			//swap last space with root element
			int tmp = arr[0];
			arr[0] = arr[size];
			arr[size] = tmp;
			
			rebuild(size);
		}
	}
	
	
	private void rebuild(int size) {
		
		//start at index 0 
		int i = 0;
		
		//while i value is less then size/2(mid)
		while(i < size/2) {
			
			//get high value child
			int child = getHighestChild(i,size);
			
			if(arr[i] < arr[child]) {
				
				int tmp = arr[i];
				arr[i] = arr[child];
				arr[child] = tmp;
				
				i = child;
				
			}else i = size;  //code to break while loop
		}
	}

	private int getHighestChild(int i, int size) {
		return (2*i+1 == size || arr[2*i + 1] > arr[2*i + 2]) ? 2*i + 1 : 2*i + 2;
	}

	//print method
	void show() {
		
			for (int i = 0; i < this.arr.length; i++) System.out.println(this.arr[i]);
		}	
	
	}
 
