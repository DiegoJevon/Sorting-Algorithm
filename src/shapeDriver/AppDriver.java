package shapeDriver;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import shapeException.*;


/**
 * 
 * @author Diego Maia, Dakota Chatt, Kevin Ung, Matt Jacyk
 * @version June 09, 2022
 *
 */
public class AppDriver {

	public static void main(String[] args) {

		if (args.length!=3) {
		System.err.print("Breakpoint must be followed by:\n\n-f: For the file path contain with all shapes\n-t: Defining which information should be "
					+ "compare\n-s: Which type of sorting should be used.");
		return;
		}
		String in = args[0]+" "+args[1]+" "+args[2];
		String input = in.toLowerCase().replaceAll("\"", "") + " ";

		try {
			FunctionsManagement runFile = new FunctionsManagement(input);

		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | SortingTypeException | ComparisonTypeException 
				| BreakpointTypeException | FileNotFoundException | InvocationTargetException e) {

		} 
	}

}
