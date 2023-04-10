package shapeSupport;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import shapeDomain.Shape;

/**
 * Classes for bubbleSort, selectionSort, insertionSort, mergeSort, quickSort, and shellSort.
 *
 * @author Diego Maia, Dakota Chatt, Matthew Jacyk, Kevin Ung
 *
 */
public final class Sorting {

	/**
	 * Bubble sort method traverses from first to last element, if current element is smaller than next element, it is swapped.
	 *
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	public static <T> void bubbleSort(Comparable<T>[] array, String comp) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		boolean sorted = false;
		
			while (!sorted) {
				sorted = true;

				for (int i = 0; i < array.length-1; i++) {
					if (comparison(comp,array[i], array[i+1]) < 0) {
						swap(array, i, i+1);
						sorted = false;
					}
				}
			}		
	}
	
	/**
	 * Selection sort method searches for highest element and positions it at proper location, then swaps current element with the highest number. 
	 *
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	public static <T> void selectionSort(Comparable<T>[] array, String comp) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

			for (int i = 0; i < array.length - 1; i++) {
				int index = i;
				Comparable<T> max = array[i];
				for (int j = i + 1; j < array.length; j++) {
					if (comparison(comp, array[j],  array[index]) > 0) {
						index = j;
					}
				}
				if (comparison(comp, array[index], array[i]) > 0) {
					swap(array, i, index);
				}
			}
	}

	
	/**
	 * Insertion sort method compares elements side by side and then inserts elements at the correct position of sorted array. 
	 *
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	public static <T> void insertionSort(Comparable <T>[] array, String comp) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Comparable <T> temp;	
		
		for (int i = 1; i < array.length; i++) {
				temp = array[i];
				int j = i;
				
					while (j > 0 && comparison(comp,array[j-1], temp) < 0) {
						swap(array, j, j-1);
						j--;
					}
					array[j] = temp;		
				}
		
	}
	
	/**
	 * merge method determines the length of array and splits it into sub-arrays to be compared and merged together in a sorted array in Merge Sort method.
	 * 
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @param start Represents the index at the beginning of array.
	 * @param mid Represents the index at the middle of array.
	 * @param end Represents the index at the ending of array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	private static <T> void merge(Comparable <T>[] array, String comp, int start, int mid, int end) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int leftArrayLength = mid - start + 1;
		int rightArrayLength = end - mid;
		int indexLeft = 0;
		int indexRight = 0;		
		int index = start;			
		Comparable<T>[] tempLeft = new Comparable[leftArrayLength];
		Comparable<T>[] tempRight = new Comparable[rightArrayLength];
		
		for (int i =0; i < leftArrayLength; i++) {
			tempLeft[i] = (Comparable<T>) array[start + i];
		}
		
		for (int i =0; i < rightArrayLength; i++) {
			tempRight[i] = (Comparable<T>) array[mid+ 1 + i];
		}		
					
			while(indexLeft < leftArrayLength && indexRight < rightArrayLength ) {
				if (comparison(comp, tempLeft[indexLeft], tempRight[indexRight]) > 0) {
					array[index] = (Comparable<T>) tempLeft[indexLeft];
					indexLeft++;
				}else {
					array[index] = (Comparable<T>) tempRight[indexRight];
					indexRight++;
				}
				index++;
			}			
		while (indexLeft < leftArrayLength) {
			array[index] = (Comparable<T>) tempLeft[indexLeft];
			indexLeft++;
			index++;
		}
		while (indexRight < rightArrayLength) {
			array[index] = (Comparable<T>) tempRight[indexRight];
			indexRight++;
			index++;
		}
	
	}
	
	
	/**
	 * Merge sort method merges the sub-arrays into a sorted array. 
	 *
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	public static <T> void mergeSort(Comparable <T>[] array, String comp, int start, int end) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, comp, start, mid);
			mergeSort(array, comp, mid + 1, end);
			merge(array, comp, start, mid, end);
		}
	}
	
	/**
	 * Partition method picks an element as a pivot and partitions values around it later to be sorted in Quick Sort method.
	 * 
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @param start Represents the index at the beginning of array.
	 * @param end Represents the index at the ending of array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	private static <T> int partition(Comparable<T>[] array, String comp, int start, int end) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// highest element into array
		 Comparable<T> pivot = array[end];

		// index for the highest element
		int index = (start - 1);

		// traverse the element		
			for (int i = start; i < end; i++) {
				if (comparison(comp, array[i], pivot) >= 0) {

					// in case of find value greater than pivot
					index++;					
					swap(array, index, i);
				}
			}		
		// swapt the pivot element with greater element
		swap(array, index+1 ,end);
		return index + 1;
	}
	
	/**
	 * Quick Sort method sorts the partitioned values into the correct positions.
	 * 
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @param start Represents the index at the beginning of array.
	 * @param end Represents the index at the ending of array.
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 */
	public static <T> void quickSort(Comparable<T>[] array, String comp, int start, int end) throws SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (start < end) {
			int index = partition(array, comp, start, end);
			quickSort(array, comp, start, index - 1);
			quickSort(array, comp, index + 1, end);
		}
	}
	
	/**
	 * Shell Sort
	 * It's a variation of Insert Sort, but in this type of sorting should be started  comparing extremes of a pivot point (length/2)  and swap the elements.
	 * This sorting is always reducing by half as a base of comparison, as the lowest level remaning one element must be sorted and, in this case, similar of Insert Sort, 
	 * with previous levels already sorted.
	 * Time performance: Worst case O(n^2), average case O(n log n)
	 * @param <T> This describes the array type.
	 * @param array Array must be sorted
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array
	 * @throws SecurityException
	 * @throws IllegalAccessException Thrown when application tries to reflectively create an instance, or set/get a field in a class.
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> void shellSort (Comparable<T>[] array, String comp)  {
		int length = array.length;
		
		//setting the pivot, reducing by half every time.
		for (int pivot = length/2; pivot>0; pivot/=2) {
			
			//achieving the pointer, starting at 0 until pivot -1
			for (int i = pivot; i<length; i++) {
				
				//add a temp array to compare with the position of array[j] with further element
				Comparable<T> temp = array[i];
				
				
				int j = i;
				//swap the all elements from left side until right position
				while (j >= pivot && comparison(comp, temp, array[j-pivot]) > 0) {
					//assign the new element in the right position
					array[j] = array[j -pivot];
					
					//reducing reference of j with pivot
					j-= pivot;
					
					//assign the temp element in the right position
					array[j] = temp;
				}				
			}
		}
	}	
	
	/**
	 * Swap method which swaps the index positions of int i and j.
	 * 
	 * @param <T> This describes the array type.
	 * @param array This is the array being compared.
	 * @param i Element to be swapped with index of j.
	 * @param j Element to be swapped with index of i.
	 */
	private static <T> void swap( Comparable<T>[] array, int i, int j )	{
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * Comparison method casts shape object into a comparable array and temp to calculate the shapes base area, volume, and height.
	 * 
	 * @param <T> This describes the array type.
	 * @param comp Integer as a result of comparison of Area, Volume or Height between two elements of the array.
	 * @param array This is the array being compared.
	 * @param temp Temporary array to be compared with original array.
	 * @return returns the result of compared base area, volume, and height of shapes. 
	 */
	private static <T> int comparison (String comp, Comparable<T> array, Comparable<T> temp)  {
		Shape[] shape = new Shape[2];
		shape[0] = (Shape) array;
		shape[1] = (Shape) temp;
		
		
		switch(comp) {
		case "a": Comparator ac = new BaseAreaCompare();
			return ac.compare(array, temp);
		case "v": Comparator vc = new VolumeCompare();
			return vc.compare(array, temp);
		default:
			return shape[0].compareTo(shape[1]);
		}
		
	}

}
