
/**
 * Write a description of class PartTimeStaffHire.
 *
 *
  ------------------------------------------------------------------------
 *                           Type of the variable                         |                           
 *------------------------------------------------------------------------
 * workingHour                        | a whole number                    |
 * wagesPerHour                       | a double number                   |
 * shifts                             | string                            |
 * terminated                         | Boolean                           |
 * ------------------------------------------------------------------------
 * 
 * The constructor accepts 11 parameters, which are the vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy and joined, working hours (hours per day), 
 * wages per hour, and shifts (morning, day or evening working shifts). A call is made to the superclass constructor with 8 parameters, the vacancyNumber, designation, jobType, staffName, 
 * joiningDate, qualification, appointedBy and joined. 
 * The working hours, wages per hour and shifts attributes are assigned the corresponding parameter values. Additionally, in the constructor, assign terminated status is assigned to false. 
 * 
 * @author aavash
 * @version vol.1.18.02.2025
 */
// Class definition for PartTimeStaffHire, which extends the StaffHire class
public class PartTimeStaffHire extends StaffHire
 {
    // Instance variables specific to part-time staff
    private int workingHour; // Number of working hours
    private double wagesPerHour; // Wages per hour
    private String shifts; // Working shifts (e.g., morning, evening)
    private boolean terminated; // Status indicating if the staff is terminated

    // Constructor for PartTimeStaffHire
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, 
                             String joiningDate, String qualification, String appointedBy, 
                             boolean joined, int workingHour, double wagesPerHour, String shifts)
                             
    {
        // Call the constructor of the superclass (StaffHire) to initialize common fields
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.workingHour = workingHour; // Set working hours
        this.wagesPerHour = wagesPerHour; // Set wages per hour
        this.shifts = shifts; // Set working shifts
        this.terminated = false; // Default to not terminated
    }

    // Accessor methods to retrieve private instance variables
    public int getWorkingHour() { return workingHour; } // Get working hours
    public double getWagesPerHour() { return wagesPerHour; } // Get wages per hour
    public String getShifts() { return shifts; } // Get working shifts
    public boolean isTerminated() { return terminated; } // Check if staff is terminated

    // Method to set working shifts if the staff is joined
    public void setShifts(String shifts)
    {
        if (isJoined()) { // Check if the staff is currently joined
            this.shifts = shifts; // Set the shifts
        }
    }

    // Method to terminate the part-time staff
    public void terminate() 
    {
        if (!terminated)
        { // Check if the staff is not already terminated
            // Use the accessor method to set the joined status to false
            setJoined(false); // Mark the staff as not joined
            this.terminated = true; // Set the terminated status to true
        }
        else
        {
            System.out.println("Staff is already terminated."); // Inform if already terminated
        }
    }

    // Override the display method to show part-time staff details
    @Override
    public void display()
    {
        super.display(); // Call the display method of the superclass to show common details
        if (isJoined())
        { // Check if the staff is currently joined
            // Display specific details for part-time staff
            System.out.println("Working Hour: " + workingHour);
            System.out.println("Wages Per Hour: " + wagesPerHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + terminated);
            // Calculate and display income per day
            System.out.println("Income Per Day: " + (wagesPerHour * workingHour));
        }
    }
    @Override
public String getDetailsAsString() 
{
    StringBuilder details = new StringBuilder(super.getDetailsAsString());
    details.append("Working Hour: ").append(getWorkingHour()).append("\n");
    details.append("Wages Per Hour: ").append(getWagesPerHour()).append("\n");
    details.append("Shifts: ").append(getShifts()).append("\n");
    details.append("Terminated: ").append(isTerminated()).append("\n");
    details.append("Income Per Day: ").append(getWorkingHour() * getWagesPerHour()).append("\n");
    return details.toString();
}
}