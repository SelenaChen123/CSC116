import java.util.*;
import java.io.*;

/**
 * Examine average female and male salaries for a variety of jobs based on 2015 salary data
 *
 * @author Selena Chen
 */
public class PayGap {
    /**
     * Starts the program
     *
     * @param filename command line filename arguments
     */
    public static void main(String[] filename) {
        if(filename.length != 1) {
            System.out.println("Usage: java -cp bin PayGap filename");
            System.exit(1);
        }
        
        File file = new File(filename[0]);
        if(!file.exists()) {
            System.out.println("Unable to access input file: " + filename[0]);
            System.exit(1);
        }
        
        Scanner console = new Scanner(System.in);
        
        String option = "";
        
        do {
            System.out.println("Gender Pay Gap Information - Please enter an option below.");
            System.out.println();
            System.out.println("D - Display all jobs");
            System.out.println("J - Search by job");
            System.out.println("S - Search by salary range");
            System.out.println("P - Search by percentage");
            System.out.println("Q - Quit the program");
            System.out.println();
            System.out.print("Option: ");
            option = console.next().toUpperCase();
            console.nextLine();
            
            if(option.equals("Q")) {
                System.out.println();
                System.out.println("Goodbye!");
                System.exit(1);
            }
            
            while(!option.equals("D") && !option.equals("J") && !option.equals("S")
                    && !option.equals("P")) {
                System.out.println("Invalid option");
                System.out.println();
                System.out.println("Gender Pay Gap Information - Please enter an option below.");
                System.out.println();
                System.out.println("D - Display all jobs");
                System.out.println("J - Search by job");
                System.out.println("S - Search by salary range");
                System.out.println("P - Search by percentage");
                System.out.println("Q - Quit the program");
                System.out.println();
                System.out.print("Option: ");
                option = console.next().toUpperCase();
                console.nextLine();
            }
            
            if(option.equals("D")) {
                System.out.printf("%84s", "Female    Male");
                System.out.println();
                System.out.printf("%35s", "Job Description");
                System.out.printf("%50s", "Salary   Salary");
                System.out.println();
                System.out.printf("%35s", "---------------");
                System.out.printf("%50s", "------   ------");
                System.out.println();
                System.out.println();
                System.out.print(getAllJobs(getJobList(filename[0])));
                System.out.println();
                System.out.println();
            } else if(option.equals("J")) {
                System.out.print("Job (contains/is): ");
                String job = console.nextLine();
                System.out.printf("%84s", "Female    Male");
                System.out.println();
                System.out.printf("%35s", "Job Description");
                System.out.printf("%50s", "Salary   Salary");
                System.out.println();
                System.out.printf("%35s", "---------------");
                System.out.printf("%50s", "------   ------");
                System.out.println();
                System.out.println();
                System.out.print(searchByJob(job, getJobList(filename[0])));
                System.out.println();
                System.out.println();
            } else if(option.equals("S")) {
                int min = 0;
                int max = 0;
                try {
                    System.out.print("Minimum salary: ");
                    min = console.nextInt();
                } catch (InputMismatchException e) {
                    console.next();
                    min = -1;
                }
                if(min < 0) {
                    System.out.println("Invalid value");
                    System.out.println();
                } else {
                    try {
                        System.out.print("Maximum salary: ");
                        max = console.nextInt();
                    } catch (InputMismatchException e) {
                        console.next();
                        max = -1;
                    }
                }
                if(min >= 0 && (min > max || max < min)) {
                    System.out.println("Invalid value");
                    System.out.println();
                }
                if(min >= 0 && max >= 0 && min <= max) {
                    System.out.printf("%84s", "Female    Male");
                    System.out.println();
                    System.out.printf("%35s", "Job Description");
                    System.out.printf("%50s", "Salary   Salary");
                    System.out.println();
                    System.out.printf("%35s", "---------------");
                    System.out.printf("%50s", "------   ------");
                    System.out.println();
                    System.out.println();
                    System.out.print(searchBySalaryRange(min, max, getJobList(filename[0])));
                    System.out.println();
                    System.out.println();
                }
            } else if(option.equals("P")) {
                int percentage = 0;
                try {
                    System.out.print("Percentage (1-100): ");
                    percentage = console.nextInt();
                } catch (InputMismatchException e) {
                    console.next();
                }
                if(percentage < 1 || percentage > 100) {
                    System.out.println("Invalid value");
                    System.out.println();
                }
                if(percentage >= 1 && percentage <= 100) {
                    System.out.printf("%84s", "Female    Male");
                    System.out.println();
                    System.out.printf("%35s", "Job Description");
                    System.out.printf("%50s", "Salary   Salary");
                    System.out.println();
                    System.out.printf("%35s", "---------------");
                    System.out.printf("%50s", "------   ------");
                    System.out.println();
                    System.out.println();
                    System.out.print(searchByPercentage(percentage, getJobList(filename[0])));
                    System.out.println();
                    System.out.println();
                }
            }
            
        } while (!option.equals("Q"));
    }

    /**
     * Counts the number of jobs in a file and reads the information for each job,
     * storing it in the Job array
     *
     * @param filename user-inputted file being scanned
     * @return job array
     */
    public static Job[] getJobList(String filename) {
        Scanner file = null;
        try {
            file = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }
        int jobCount = 0;
        while(file.hasNextLine()) {
            file.nextLine();
            jobCount++;
        }
        Job[] jobs = new Job[jobCount];
        try {
            file = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }
        for(int i = 0; i < jobs.length; i++) {
            Scanner lineScan = new Scanner(file.nextLine());
            lineScan.useDelimiter(",");
            while(lineScan.hasNext()) {
                String job = lineScan.next();
                int femaleSalary = lineScan.nextInt();
                int maleSalary = lineScan.nextInt();
                jobs[i] = new Job(job, femaleSalary, maleSalary);
            }
        }
        return jobs;
    }
    
    /**
     * Returns a String with the name, female salary, and male salary for each job
     *
     * @param jobs array of jobs
     * @return allJobs string with name and salaries
     */
    public static String getAllJobs(Job[] jobs) {
        String allJobs = "";
        for(int i = 0; i < jobs.length; i++) {
            allJobs += jobs[i].toString();
            if(i != jobs.length) {
                allJobs += "\n";
            }
        }
        return allJobs;
    }
    
    /**
     * Returns a String with the name, female salary, and male salary for each job
     * that contains or is the same as the given String, disregarding case
     *
     * @param job job being searched for
     * @param jobs array of jobs
     * @return string with name and salaries
     */
    public static String searchByJob(String job, Job[] jobs) {
        String matchingJobs = "";
        for(int i = 0; i < jobs.length; i++) {
            if(jobs[i].getJob().toString().contains(job.toUpperCase())
                || jobs[i].getJob().toString().contains(job.toLowerCase())
                || jobs[i].getJob().toString().contains(job.substring(0, 1).toUpperCase() +
                                                        job.substring(1).toLowerCase())) {
                matchingJobs += jobs[i].toString();
                if(i != jobs.length) {
                    matchingJobs += "\n";
                }
            }
        }
        return matchingJobs;
    }
    
    /**
     * Returns a String with the name, female salary, and male salary for each job
     * whose female and male salaries are greater than or equal to the minimum value and
     * less than or equal to the maximum value
     *
     * @param min minimum salary
     * @param max maximum salary
     * @param jobs array of jobs
     * @return string with name and salaries
     */
    public static String searchBySalaryRange(int min, int max, Job[] jobs) {
        if(min < 0 || max < 0 || max < min) {
            throw new IllegalArgumentException("Invalid min/max value");
        }
        String matchingRanges = "";
        for(int i = 0; i < jobs.length; i++) {
            if(jobs[i].getFemaleSalary() >= min && jobs[i].getFemaleSalary() <= max
                && jobs[i].getMaleSalary() >= min && jobs[i].getMaleSalary() <= max) {
                matchingRanges += jobs[i].toString();
                if(i != jobs.length) {
                    matchingRanges += "\n";
                }
            }
        }
        return matchingRanges;
    }
    
    /**
     * Returns a String with the name, female salary, and male salary for each job
     * whose female salary is less than the given percentage of the male salary
     *
     * @param percentage given percentage being searched for
     * @param jobs array of jobs
     * @return string with name and salaries
     */
    public static String searchByPercentage(int percentage, Job[] jobs) {
        if(percentage < 1 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage value");
        }
        String matchingPercentages = "";
        for(int i = 0; i < jobs.length; i++) {
            if(jobs[i].getFemaleSalary() < (percentage * jobs[i].getMaleSalary() / 100)) {
                matchingPercentages += jobs[i].toString();
                if(i != jobs.length) {
                    matchingPercentages += "\n";
                }
            }
        }
        return matchingPercentages;
    }
}