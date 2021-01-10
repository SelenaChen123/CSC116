import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Lab 13 code as class
 *
 * @author CSC116-002-f18
 */
public class Pets {

    /**
     * Starts the program
     * 
     * @param args array of command line arguments
     * @throws FileNotFoundException if input file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("test-files/pets2.txt"));
        dogCat(input);
    }

    /**
     * Outputs the number of dog names and cat names along with the difference between counts
     * 
     * @param input scanner for file
     */
    public static void dogCat(Scanner input) {
        int sumDogs = 0;
        int sumCats = 0;
        int countDogs = 0;
        int countCats = 0;
        boolean dog = true;
        
        while(input.hasNext()){
            input.next(); // read name and discard
            if (dog){ //if(countDogs == countCats){
                countDogs++;
                sumDogs += input.nextInt();
            } else {
                countCats++;
                sumCats += input.nextInt();        
            }
            dog = !dog;
        }
        
        input.close();
        
        System.out.println("Dogs: " + countDogs + ", Cats: " + countCats);
        System.out.println("Difference: " + Math.abs(sumDogs - sumCats));
    }
    
    
    
    
    
    
    


}
