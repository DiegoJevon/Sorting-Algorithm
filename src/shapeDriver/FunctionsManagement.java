package shapeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import shapeDomain.Shape;
import shapeException.BreakpointTypeException;
import shapeException.ComparisonTypeException;
import shapeException.SortingTypeException;
import shapeSupport.Sorting;


/** This class is responsible to handle with all background interaction as: read the file, create array, select comparison method and define sort method.
 * 
 * 
 *
 */
public class FunctionsManagement {

	/**
	 * Main method calling all classes and methods involved in get the user's information and be able to sort defined shapes.
	 * 
	 * @param filePath String from the path of file defined by user.
	 * @throws ClassNotFoundException thrown when an the class is not founded.
	 * @throws NoSuchMethodException thrown when an the method is not founded.
	 * @throws InstantiationException thrown when an the the class had a problem to instance.
	 * @throws IllegalAccessException thrown when has some problem to reflect the class.
	 * @throws IllegalArgumentException thrown when an illegal argument is trying to be used into a method. 
	 * @throws ComparisonTypeException thrown when the comparison criteria is not founded. 
	 * @throws SortingTypeException thrown when the sorting type is not founded. 
	 * @throws BreakpointTypeException thrown when the breakpoint criteria is not founded. 
	 * @throws FileNotFoundException thrown when the file is not founded.
	 */
	public FunctionsManagement(String filePath) throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException, IllegalAccessException,
			InvocationTargetException, ComparisonTypeException, SortingTypeException, BreakpointTypeException, FileNotFoundException {
		
		//defining arguments
		String txtFile = "";
		String comparisonCriteria = "";
		String sortingCriteria = "";
		int count = 0;
		int startChar = 0;
		int endChar = startChar + 1;
		String[] checkBreakpointType = { "t", "f", "s" }; //array with predefined breakpoints 
		boolean checkBreakpointTypeBoolean = false;
		int countingBreakpoint=0;		
		int length;
		Shape[] shape;
		int index = 0;
		Class reflected = null;
		Object o = null;
		String method = "";
		Method m = null;
				
		String[] test = filePath.split(" ");
		int hyphenCount=0;
		//checking if there are three breakpoints
		for (int i=0; i<test.length; i++) {
			if (test[i].charAt(0) == '-'){
				hyphenCount++;
			}
			if (test[i].length() <3 && hyphenCount <2) {
				throw new BreakpointTypeException("Breakpoint must be followed by:\n\n-f: For the file path contain with all shapes\n-t: Defining which information should be "
						+ "compare\n-s: Which type of sorting should be used.");
	
			}
		}
		
		
		String breakpoint = filePath.substring(filePath.indexOf('-', startChar) + 1, startChar + 2); //
		

		while (startChar + 1 < filePath.length() - 1) {

			switch (breakpoint) {
			case "f":
				endChar = filePath.indexOf(" ", startChar + 1);
				txtFile = filePath.substring(filePath.indexOf('-', startChar) + 2, endChar);
				startChar = endChar;
				count++;
				if (count == 3)
					break;
				breakpoint = filePath.substring(filePath.indexOf('-', startChar) + 1, startChar + 3);
				break;

			case "t":
				endChar = filePath.indexOf(' ', startChar + 1);
				comparisonCriteria = filePath.substring(filePath.indexOf('-', startChar) + 2, endChar);
				startChar = endChar;
				count++;
				if (count == 3)
					break;
				breakpoint = filePath.substring(filePath.indexOf('-', startChar) + 1, startChar + 3);
				break;

			case "s":
				endChar = filePath.indexOf(' ', startChar + 1);
				sortingCriteria = filePath.substring(filePath.indexOf('-', startChar) + 2, endChar);
				startChar = endChar;
				count++;
				if (count == 3)
					break;
				breakpoint = filePath.substring(filePath.indexOf('-', startChar) + 1, startChar + 3);
				break;
			}
			
			//for loop in case counting how many breakpoints were used
			for (int i = 0; i < checkBreakpointType.length; i++) {
				if (breakpoint.equals(checkBreakpointType[i])) {
					checkBreakpointTypeBoolean = true;
					countingBreakpoint++;
				}
					
			}
			//in case of problem with breakpoints, an exception must be thrown
			if (!checkBreakpointTypeBoolean && countingBreakpoint != 3) {
				throw new BreakpointTypeException("Breakpoint must be followed by:\n\n-f: For the file path contain with all shapes\n-t: Defining which information should be "
						+ "compare\n-s: Which type of sorting should be used.");
			}

		}

		
		File file = new File(txtFile);
		
		//in case of file was is founded, an exception must be thrown
		if (!file.exists()) {
			System.err.print("File has not been found! Please check the filepath.");
			System.exit(0);
		}
				
		
		Scanner reader = new Scanner(file).useDelimiter(" ");
		length = Integer.parseInt(reader.next());
		shape = (Shape[]) Array.newInstance(Shape.class, length);

		while (reader.hasNext()) {
			String className = "shapeDomain." + reader.next();
			reflected = Class.forName(className);

			Class paramTypes[] = new Class[2];
			paramTypes[0] = Double.TYPE;
			paramTypes[1] = Double.TYPE;

			Constructor ct = reflected.getConstructor(paramTypes);

			Object argList[] = new Object[2];
			argList[0] = new Double(Double.parseDouble(reader.next()));
			argList[1] = new Double(Double.parseDouble(reader.next()));

			o = ct.newInstance(argList);
			shape[index] = (Shape) o;
			index++;
		}
		reader.close();

		String[] comparisonType = { "a", "v", "h" };
		boolean comparisonTypeCheck = false;
		for (int i = 0; i < comparisonType.length; i++) {
			if (comparisonCriteria.equals(comparisonType[i]))
				comparisonTypeCheck = true;
		}
		//in case of comparison type is not founded, an exception must be thrown
		if (!comparisonTypeCheck) {
			throw new ComparisonTypeException("Comparison type must be:\n\na: Base Area\nv: Volume\nh: Height");

		}
		String selectedCriteria = "";

		switch (comparisonCriteria) {
		case "a":
			selectedCriteria = "Base Area";
			break;
		case "v":
			selectedCriteria = "Volume";
			break;
		default:
			selectedCriteria = "Height";
			break;
		}

		String[] sortingType = { "b", "s", "i", "m", "q", "z" };
		boolean sortingTypeCheck = false;
		for (int i = 0; i < sortingType.length; i++) {
			if (sortingCriteria.equals(sortingType[i]))
				sortingTypeCheck = true;
		}
		
		//in case of selected sort type is not founded, an exception must be thrown
		if (!sortingTypeCheck) {
			throw new SortingTypeException(
					"Sorting type must be:\n\nb: Bubble Sort\ns:Selection Sort\ni: Insertion Sort\nm: Merge Sort\nq: Quick Sort\nz: Shell Sort");
		}

		
		//calling the sort method with the comparison criteria
		sorting(shape, sortingCriteria, comparisonCriteria, selectedCriteria);
	}
	
	/**
	 * 
	 * @param shape Array containing shapes information.
	 * @param sortingCriteria Sorting criteria defined by user.
	 * @param comparisionCriteria Comparison criteria defined by user.
	 * @param selectedCriteria Text including the comparison criteria select by user.
	 * @throws IllegalAccessException thrown when has some problem to reflect the class.
	 * @throws InvocationTargetException checks if some exception was thrown when invokes method or constructor.
	 * @throws ComparisonTypeException thrown when the comparison criteria is not founded. 
	 */
	public static void sorting(Shape[] shape, String sortingCriteria, String comparisionCriteria, String selectedCriteria)
			throws IllegalAccessException,  InvocationTargetException, ComparisonTypeException {
		long start;
		long end;
		long result;
		Object object = null;
		Method sortingMethod;

		
		System.out.println("Criteria selected: "+selectedCriteria);
		start = System.currentTimeMillis();
		switch (sortingCriteria) {

		case "b":
			System.out.print("Bubble Sorting: ");
			Sorting.bubbleSort(shape, comparisionCriteria);
			break;
		case "s":
			System.out.print("Selection Sorting: ");
			Sorting.selectionSort(shape, comparisionCriteria);
			break;
		case "i":
			System.out.print("Insertion Sorting: ");
			Sorting.insertionSort(shape, comparisionCriteria);
			break;
		case "m":
			System.out.print("Merge Sorting: ");
			Sorting.mergeSort(shape, comparisionCriteria, 0, shape.length - 1);
			break;
		case "q":
			System.out.print("Quick Sorting: ");
			Sorting.quickSort(shape, comparisionCriteria, 0, shape.length - 1);
			break;
		case "z":
			System.out.print("Shell Sorting: ");
			Sorting.shellSort(shape, comparisionCriteria);
			break;

		}
		end = System.currentTimeMillis();
		result = end - start;
		System.out.println("Total running time of "+result + "msec.\nRunning a total of "+shape.length+" shapes.");
		System.out.printf("%-20s%-15d %s%n", "Element position: ",1,shape[0]);
		for (int i = 999; i < shape.length - 2; i += 1000) {
			System.out.printf("%-20s%-15d %s%n", "Element position: ",i+1,shape[i]);
		}
		System.out.printf("%-20s%-15d %s%n", "Element position: ",shape.length,shape[shape.length-1]);
		
		
		
	}	
	
}
