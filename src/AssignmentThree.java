import java.util.Scanner;

/**
 * KCAU CAFE Express provide fresh food, recipes, nutrition plans and fitness plans direct to your door. They offer a subscription model, with a range of different subscriptions available depending on family size, main goals of the customer (e.g. healthy eating or sport-specific nutrition requirements) and cater for various kinds of diets (e.g. gluten free and vegetarian). All customers must choose which type of nutrition plan they wish to follow, from the following
 * list:
 *
 *     • Regular healthy eating plan
 *     • Weightlifter eating plan
 *     • Endurance trainer eating plan
 *     • Gluten free healthy eating plan
 *     • Gluten free weightlifter eating plan
 *     • Gluten free endurance trainer eating plan
 *     • Vegetarian healthy eating plan
 *     • Vegetarian weightlifter eating plan
 *     • Vegetarian endurance trainer eating plan
 *
 * All customers must choose the number of adults to be fed on the plan, from the following options:
 *         ◦ 1
 *         ◦ 2
 *         ◦ 3
 *         ◦ 4
 * All customers must choose the number of children to be fed on the plan, from the following options:
 *         ◦ 0
 *         ◦ 1
 *         ◦ 2
 *         ◦ 3
 *         ◦ 4
 * All meal plans come with recipes and nutrition plans.
 * The plan cannot be sold only for children. The program must therefore check that at least one adult is selected. In addition, children can only be added to the regular, gluten free or vegetarian healthy eating plans. Children cannot be included on a weightlifter or endurance training eating plan. If such a selection is made, the customer must be told to change their options.
 * Customers may optionally select from the following additional services:
 *         ◦ Muscle building fitness plan
 *         ◦ Endurance building fitness plan
 *         ◦ Balanced fitness plan
 * Once the choices have been completed, the monthly costs should be calculated, and a summary list of the chosen items and the monthly subscription cost should be displayed The customer should then be asked to enter their name and address details (house number,
 * street name, town, postcode) and their credit card number. Credit card numbers are 16 digits long and should be entered with no spaces between numbers.
 * Once the name, address and card details have been accepted, a confirmation message should be displayed, detailing plan chosen, the number of adults and children it covers, and the monthly charge.
 * The costs for the eating plans are as follows:
 *         ◦ Regular healthy eating plan: £50 pcm for each adult, £35 pcm for each child
 *         ◦ Weightlifter eating plan: £80 pcm for each adult
 *         ◦ Endurance trainer eating plan: £70 pcm for each adult
 *         ◦ Gluten free healthy eating plan: £55 pcm for each adult, £40 pcm for each child
 *         ◦ Gluten free weightlifter eating plan: £85 pcm for each adult
 *         ◦ Gluten free endurance trainer eating plan: £75 pcm for each adult
 *         ◦ Vegetarian healthy eating plan: £50 pcm for each adult, £35 pcm for each child
 *         ◦ Vegetarian weightlifter eating plan: £80 pcm for each adult
 *         ◦ Vegetarian endurance trainer eating plan: £70 pcm for each adult
 *         ◦ The costs for the fitness plans are as follows:
 *         ◦ Muscle building fitness plan: £50 pcm
 *         ◦ Endurance building fitness plan: £40 pcm
 *         ◦ Balanced fitness plan: £45 pcm
 */

public class AssignmentThree {

    public int nutritionPlanChoice, optionalPlan, adults, kids;
    public Scanner keyboard;

    public AssignmentThree(){}

    public void startApp(){
        this.nutritionPlanApp();
    }

    private void nutritionPlanApp(){
        System.out.println("Welcome to KCAU Caffe.\nWe offer the following plans\n");
        System.out.println("\t1.Regular healthy eating plan\n\t2.Weightlifter eating plan\n\t3.Endurance trainer eating plan\n\t" +
                "4.Gluten free healthy eating plan\n\t5.Gluten free weightlifter eating plan\n\t6.Gluten free endurance trainer eating plan" +
                "\n\t7.Vegetarian healthy eating plan\n\t8.Vegetarian weightlifter eating plan\n\t15.Vegetarian endurance trainer eating plan\n");
        System.out.print("Choose your family nutrition plan: ");


        keyboard = new Scanner(System.in);
        // get the user choice on nutrition plan
        nutritionPlanChoice = keyboard.nextInt();

        System.out.print("\n\nHow many adults are to be fed on your plan? \n");
        System.out.print("\t1. 1\n\t2. 2\n\t3. 3\n\t4. 4\n\t");
        // get the user choice on adults to be fed
        adults = keyboard.nextInt();

        System.out.print("\n\nHow many children are to be fed on your plan? \n");
        System.out.print("\t1. 0\n\t2. 1\n\t3. 2\n\t4. 3\n\t5. 4\n\t");
        // get the user choice on children to be fed
        kids = keyboard.nextInt();

        //  check the eating plan and validate for children
        while(!isHealthyNutritionPlan() && kids != 0){
            System.out.println("\n"+getNutritionPlan(nutritionPlanChoice) + " is not viable for children." +
                    "\nKindly select any healthy eating plan below to include children");

            //display the options again
            healthyEatingPlanPrompt();
        }

        // ask optional nutrition plans
        System.out.println("\nBelow are optional nutrition plans. ");
        System.out.println("\t1. Muscle building fitness plan\n\t2. Endurance building fitness plan\n\t3. Balanced fitness plan\n\t" +
                "4. Ignore");
        System.out.print("Choose a healthy eating nutrition plan: ");

        // get the user choice on nutrition plan
        optionalPlan = keyboard.nextInt();

        // getting the totalCost
        int totalCost = getNutritionPlanCost();

        // display the summary
        System.out.println("\nYour nutrition plan summary is as follows \n\t1. "+
                getNutritionPlan(nutritionPlanChoice) + " -> " + " Monthly Cost: £" + (getAdultsTotalCost() + getKidsTotalCost()) +
                "\n\t2. " + getOptionalPlan() + " -> " + " Monthly cost: £" +getOptionalCost());

        // ask customer details
        System.out.println("\nEnter your details as listed below");

        // delete newline from the keyboard buffer
        keyboard.nextLine();

        // clear the newline from keyboard buffer
        System.out.print("\tName: ");
        String customerName = keyboard.nextLine();

        //address details
        System.out.println("\n\tYour Address details");
        System.out.print("\t\tHouse Number: ");
        String houseNumber = keyboard.nextLine();
        System.out.print("\t\tStreet Name: ");
        String streetName = keyboard.nextLine();
        System.out.print("\t\tTown: ");
        String town = keyboard.nextLine();
        System.out.print("\t\tPostcode: ");
        String postCode = keyboard.nextLine();

        System.out.println("\n\tYour Credit Card details");
        //get the credit card number
        System.out.print("\t\tCredit Card Number: ");
        String creditCard = keyboard.nextLine();

        while(creditCard.length() != 16){
            System.out.println("\nA valid credit card number must be 16 digits long");
            System.out.println("Kindly ensure you are entering it correctly");

            System.out.print("\n\t\tCredit Card Number: ");
            creditCard = keyboard.nextLine();
        }


        // detailed summary
        System.out.println("\nHi " + customerName+ ". The following is your nutrition plan details \n\t1. "+
                getNutritionPlan(nutritionPlanChoice) + " -> " + adults + " Adults, " + kids + " Children" + " Monthly Cost: £" + (getAdultsTotalCost() + getKidsTotalCost()) +
                "\n\t2. " + getOptionalPlan() + " -> " + " Monthly cost: £" +getOptionalCost());
        System.out.println("\n\tTotal Monthly Cost: £" + totalCost + " monthly");

        System.out.println("\n\tDo you confirm the above details?\n\t\t1.Yes\n\t\t2.No");
        int choice = keyboard.nextInt();
        if(choice == 1){
            System.out.println("\nWelcome again to KCAU Caffe!");
        } else if(choice == 2){
            System.out.println("\nWe are sorry. Kindly start the process again!");
        }else{
            System.out.println("\nThankyou for coming to our caffe!\n");
        }
        System.out.println("\n");
    }

    private String getNutritionPlan(int choice){
        String[] nutritionPlans = {"Regular healthy eating plan", "Weightlifter eating plan", "Endurance trainer eating plan",
                "4.Gluten free healthy eating plan", "Gluten free weightlifter eating plan", "Gluten free endurance trainer eating plan",
                "Vegetarian healthy eating plan", "Vegetarian weightlifter eating plan", "Vegetarian endurance trainer eating plan"};
        return nutritionPlans[choice - 1];
    }

    private String getOptionalPlan(){
        String[] optionalPlans = {"Muscle building fitness plan", "Endurance building fitness plan", "Balanced fitness plan", "No additional plan selected"};
        return optionalPlans[optionalPlan - 1];
    }

    public int getAdultsTotalCost() {
        int[] nutritionsAdultsCost = {50, 80, 70, 55, 85, 75, 50, 80, 70};
        int adultsCost = nutritionsAdultsCost[nutritionPlanChoice - 1] * adults;

        return adultsCost;
    }

    private int getKidsTotalCost() {
        int[] nutritionsKidsCost = {35, 0, 0, 40, 0, 0, 35, 0, 0};
        int kidsCost = nutritionsKidsCost[nutritionPlanChoice - 1] * kids;

        return kidsCost;
    }

    private int getOptionalCost() {
        int[] optionalsCost = {50, 40, 45, 0};
        int optionalCost = optionalsCost[optionalPlan - 1];

        return optionalCost;
    }
    private int getNutritionPlanCost(){
        return getAdultsTotalCost() + getKidsTotalCost() + getOptionalCost();
    }

    private void healthyEatingPlanPrompt(){
        System.out.println("\t1.Regular healthy eating plan\n\t2.Weightlifter eating plan\n\t3.Endurance trainer eating plan\n\t" +
                "4.Gluten free healthy eating plan\n\t5.Gluten free weightlifter eating plan\n\t6.Gluten free endurance trainer eating plan" +
                "\n\t7.Vegetarian healthy eating plan\n\t8.Vegetarian weightlifter eating plan\n\t15.Vegetarian endurance trainer eating plan\n");
        System.out.print("Choose a healthy eating nutrition plan: ");

        // get the user choice on nutrition plan
        nutritionPlanChoice = keyboard.nextInt();
    }

    private boolean isHealthyNutritionPlan(){
        return nutritionPlanChoice == 1 || nutritionPlanChoice == 4 || nutritionPlanChoice == 7;
    }
}
