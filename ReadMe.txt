Title: Sorting Out Sorting

What does this program do?
This program consists of a Shape abstract class which is inherited by various shapes such as Cone, Cylinder, Prism etc. There are six sorting algorithms implemented: Bubble Sort, Selection Sort, Insertion Sort, Merge Sort, Quick Sort, and Shell Sort. The algorithm accepts an array of different shapes and can sort them down in descending order using either the height of the shape as a comparable measure or volume or base area as a comparator measure. It will also print every thousandth element as well as the first and last sorted values. In the event that the command line arguments were entered incorrectly, a message will be displayed to assist the user in preventing future errors.

Date: June 10, 2022

Authors: Diego Maia, Dakota Chatt, Kevin Ung, Matthew Jacyk

How to run the program?
1. Open command line in the folder where the Sort.jar file is located.
2. It takes 3 arguments, one for File (-f or -F), one for comparison type (-t or -T) and one for Sorting algorithm(-s or -S). Valid inputs for this program can be:

java -jar sort.jar -fpolyfor1.txt -Tv -Sb
java -jar sort.jar -ta -sQ -fpolyfor3.txt
java -jar sort.jar -tH -Fpolyfor5.txt –sB

where -f can be followed by the file name stored in data folder. -t can be followed by v for volume comparison, h for height comparison, a for base area comparison. -s can be followed by b for bubble sort, s for selection sort, i for insertion sort, m for merge sort, q for quick sort, and z for shell sort. All the arguments are case insensitive.

3. After reading the file in, the program should sort the array of shapes in descending order as well as measuring the time taken to sort the array in milliseconds.
