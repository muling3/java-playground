import java.util.Scanner;

/**
 *     2. Create a new program that implements a simple mobile phone with the following capabilities.
 *         ◦ Able to store, modify, remove and query contact names.
 *         ◦ You will want to create a separate class for contacts (name and phone number)
 *         ◦ Create a master class (mobilePhone) that holds the ArrayList of the contacts The MobilePhone class has the functionality listed above
 * Add a menu of options that are available
 * Options: Quit, print a list of contacts, add a new contact, update an existing contact, remove a contact, and search/find a contact
 * When adding or updating be sure to check if the contact already exists (for that use
 * ‘name’)
 * Be sure not to expose the inner workings of the ArrayList to MobilePhone e.g no ints, no
 * .get(i), etc
 * MobilePhone should do everything with contact object only
 */
public class AssignmentOne {

    public AssignmentOne(){}

    public static void main(String[] args) {

        //getting integers
        int[] array = getIntegers();

        //sorting the integerArray
        int[] sortedArray = sortArray(array);

        // printing the sorted array
        printArray(sortedArray);
    }

    public static int[] getIntegers(){
        Scanner keyboard = new Scanner(System.in);

        int[] entereredNumbers = new int[]{};

        String enteredCommaSeparatedNumbers;

        // prompt user to enter the numbers, comma separated or enter number individually
        System.out.println("How would you like to enter the array values?");
        System.out.println("\t1. Comma separated");
        System.out.println("\t2. Enter values individually");
        System.out.println("\t3. Exit");

        int choice = keyboard.nextInt();

        switch (choice){
            case 1:
                // clear the existing new line from the keyboard buffer
                keyboard.nextLine();

                System.out.println("Enter the array values (comma separated)");
                enteredCommaSeparatedNumbers = keyboard.nextLine();

                // split the numbers string to get individual numbers
                String[] nums = enteredCommaSeparatedNumbers.split(",");

                entereredNumbers = new int[nums.length];

                //loop through each num and push to the enteredNumbers array
                for (int i = 0; i < nums.length; i++) {
                    var value = Integer.parseInt(nums[i]);
                    entereredNumbers[i] = value;
                }
                break;
            case 2:
                entereredNumbers = getArrayValues();
                break;
            case 3:
                // exit from the application
                System.exit(0);
                break;
            default:
                // exit the application
                System.exit(0);
        }
       return entereredNumbers;
    }

    private static int[] getArrayValues(){
        Scanner scanner = new Scanner(System.in);

        //ask the number of elements of the array
        System.out.print("Enter the size of the array ");
        int arraySize = scanner.nextInt();

        // initializing empty values array
        int[] values = new int[arraySize];

        int index = 1;

        // start and endless for loop
        while (index <= arraySize) {
            System.out.println("Enter array value " + index + " (Must be a number)");
           int value = scanner.nextInt();

            //add the input value into the array
            values[index - 1] = value;

            //increment index
            index++;
        }

        return values;
    }

    public static int[] sortArray(int[] enteredArray){
        int currentIndex, currentValue;
        for (int i = 0; i < enteredArray.length - 1; i++) {
            currentIndex = i;
            currentValue = enteredArray[i];

            for (int i1 = i + 1; i1 < enteredArray.length; i1++) {
               if(enteredArray[i1] > currentValue){
                   currentValue = enteredArray[i1];
                   currentIndex = i1;
               }
            }

            enteredArray[currentIndex] = enteredArray[i];
            enteredArray[i] = currentValue;
        }

        return enteredArray;
    }

    public static void printArray(int[] enteredArray){
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < enteredArray.length; i++) {
            if (stringBuffer.isEmpty()){
                stringBuffer.append(enteredArray[i]);
            }else{
                stringBuffer.append(", "+enteredArray[i]);
            }
        }

        System.out.println("Sorted array is ->  " + stringBuffer);
    }
}
