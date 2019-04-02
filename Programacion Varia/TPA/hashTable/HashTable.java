package hashTable;

import java.util.Arrays;

public class HashTable {
	
	public int[] table = new int[7];
	int modTableSize = table.length-1;
	int elements;
	
	public HashTable() {
		Arrays.fill(table, -1);
		elements = 0;
	}
	
	public int hashFunc(int data) {
		int index = data % modTableSize;
		
		return index;
	}
	
	public void insert(int data) {
		if(isFull())
			migrate();
		
		int index = hashFunc(data);
		
		if(table[index] == -1)
			table[index] = data;
		else
			quadraticInsert(data, index);
		
	}
	
	public int get(int data) {
		int index = hashFunc(data);
		
		if(table[index] == data)
			return table[index];
		
		return quadraticGet(data, index);
	}
	
	private boolean isFull() {
		double fraction = elements / table.length;
		
		if(fraction * 100 > 75) {
			return true;
		}
		
		return false;
	}
	
	private void changeHash(int newTableLength) {
		
	}
	
	private void migrate() {
		if(!isFull())
			return;
		
		
	}
	
	private int nextPrime(int currSize) {
		int counter;
		currSize++;   
		while(true){
		    counter = 0;
		    for(int i = 2; i <= Math.sqrt(currSize); i ++)
		    	if(currSize % i == 0)  counter++;
		    
		    if(counter == 0)
		    	return currSize;
		    else {
		    	currSize++;
		    	continue;
		    }
		 }
	}
	
	private void quadraticInsert(int data, int initIndex) {
		boolean inserted = false;
		int counter = 1;
		
		while(!inserted) {
			int nextIndex = initIndex + (int)Math.pow(counter, 2);
			
			if(nextIndex >= table.length)
				nextIndex = table.length - nextIndex;
			
			if(table[nextIndex] == -1) {
				table[nextIndex] = data;
				inserted = true;
			} else {
				counter++;
			}
		}
	}
	
	private int quadraticGet(int data, int initIndex) {
		int counter = 1;
		
		while(counter < 7) {
			int nextIndex = initIndex + (int)Math.pow(counter, 2);
			
			if(nextIndex >= table.length)
				nextIndex = table.length - nextIndex;
			
			if(table[nextIndex] == data)
				return table[nextIndex];
			
			counter++;	
		}
		
		return -1;
	}
	
	

}
