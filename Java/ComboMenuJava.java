import java.util.Scanner;

public class OrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalCost = 0.0;
        String allOrders = "";

        boolean doneOrdering = false;
        int orderNumber = 1;

        while (!doneOrdering) {
            boolean wantSandwich = false;
            String sandwichtype = "";
            boolean wantFries = false;
            String friesSize = "";
            boolean wantDrink = false;
            String drinkSize = "";
            String childsizeanswer = "";
            boolean wantKetchup = false;
            int amountofpackets = 0;
        
            System.out.print("Do you want a sandwich? (yes/no): ");
            String sandwichChoice = scanner.nextLine();
            if (sandwichChoice.equalsIgnoreCase("yes")) {
                wantSandwich = true;
                System.out.print("Choose sandwich size (tofu, chicken, beef): ");
                sandwichtype = scanner.nextLine();
                if (sandwichtype.equalsIgnoreCase("tofu")) {
                    totalCost += 5.75;
                } else if (sandwichtype.equalsIgnoreCase("chicken")) {
                    totalCost += 5.25;
                } else if (sandwichtype.equalsIgnoreCase("beef")) {
                    totalCost += 6.25;
                }
            }

            System.out.print("Do you want fries? (yes/no): ");
            String friesChoice = scanner.nextLine();
            if (friesChoice.equalsIgnoreCase("yes")) {
                wantFries = true;
                System.out.print("Choose fries size (small, medium, large): ");
                friesSize = scanner.nextLine();
                if (friesSize.equalsIgnoreCase("small")) {
                    totalCost += 1;
                } else if (friesSize.equalsIgnoreCase("medium")) {
                    totalCost += 1.75;
                } else if (friesSize.equalsIgnoreCase("large")) {
                    totalCost += 2.25;
                }
            }

            System.out.print("Do you want a drink? (yes/no): ");
            String drinkChoice = scanner.nextLine();
            if (drinkChoice.equalsIgnoreCase("yes")) {
                wantDrink = true;
                System.out.print("Choose drink size (small, medium, large): ");
                drinkSize = scanner.nextLine();
                if (drinkSize.equalsIgnoreCase("small")) {
                    totalCost += 1;
                } else if (drinkSize.equalsIgnoreCase("medium")) {
                    totalCost += 1.50;
                } else if (drinkSize.equalsIgnoreCase("large")) {
                    totalCost += 2.00;
                    System.out.print("Would you like to upgrade to a child size for $0.38 more?:  ");
                    childsizeanswer = scanner.nextLine();
                    if (childsizeanswer.equalsIgnoreCase("yes")) {
                        totalCost += 0.38;
                    }
                }
            }

            System.out.print("Do you want to add ketchup packets? (yes/no): ");
            String ketchupChoice = scanner.nextLine();
            if (ketchupChoice.equalsIgnoreCase("yes")) {
                System.out.print("How many ketchup packets do you want?:  ");
                amountofpackets = scanner.nextInt();
                totalCost += amountofpackets * 0.25;
            }
            else if (ketchupChoice.equalsIgnoreCase("no")) {
                    totalCost+=0;    
            }
            scanner.nextLine(); // Consume the newline character

            String orderSummary = "\nOrder Summary for Order " + orderNumber + ":";
            if (wantSandwich) {
                orderSummary += "\nSandwich (Size: " + sandwichtype + "): $" + getSandwichCost(sandwichtype);
            }
            if (wantFries) {
                orderSummary += "\nFries (Size: " + friesSize + "): $" + getFriesCost(friesSize);
            }
            if (wantDrink) {
                orderSummary += "\nDrink (Size: " + drinkSize + "): $" + getDrinkCost(drinkSize);
            }
            if (wantKetchup) {
                orderSummary += "\nKetchup Packets: $0.25 each";
            }
            orderSummary += "\nSubtotal: $" + totalCost;
            double totalCostPlusTax = (totalCost * 0.07);
            double totalTotal = (totalCostPlusTax + totalCost);
            orderSummary += "\nTotal After Tax: $" + totalTotal;

            allOrders += orderSummary + "\n";

            System.out.print("Do you want to place another order? (yes/no): ");
            String continueOrdering = scanner.nextLine();
            if (!continueOrdering.equalsIgnoreCase("yes")) {
                doneOrdering = true;
            }

            orderNumber++;
        }

        System.out.println("\nAll Orders:");
        System.out.println(allOrders);

        scanner.close();
    }

    private static double getSandwichCost(String size) {
        if (size.equalsIgnoreCase("tofu")) {
            return 5.75;
        } else if (size.equalsIgnoreCase("chicken")) {
            return 5.25;
        } else if (size.equalsIgnoreCase("beef")) {
            return 6.25;
        }
        return 0.0;
    }

    private static double getFriesCost(String size) {
        if (size.equalsIgnoreCase("small")) {
            return 1;
        } else if (size.equalsIgnoreCase("medium")) {
            return 1.75;
        } else if (size.equalsIgnoreCase("large")) {
            return 2.25;
        }
        return 0.0;
    }

    private static double getDrinkCost(String size) {
        if (size.equalsIgnoreCase("small")) {
            return 1;
        } else if (size.equalsIgnoreCase("medium")) {
            return 1.50;
        } else if (size.equalsIgnoreCase("large")) {
            return 2.00;
        }
        return 0.0;
    }
}
