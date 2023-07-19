public class Patterns {
    public static void main(String[] args) {
        diamondPattern(4);
        pyramidPattern(6);
    }

    public static void diamondPattern(int height){
        for (int i = 0; i <= height; i++) {
            for (int j = 1; j <= 2 * height - 1 ; j++) {
                if (j >= height - (i - 1) && j <= height + (i - 1)) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = height; i >= 1; i--) {
            for (int j = 2 * height - 1; j >= 1; j--) {
                if (j >= height - (i - 1) && j <= height + (i - 1)) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void pyramidPattern(int height) {
        for (int i = 0; i <= height; i++) {
            for (int j = 1; j <= 2 * height - 1; j++) {
                if (j >= height - (i - 1) && j <= height + (i - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
