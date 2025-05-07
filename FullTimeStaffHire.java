
/**
 * Description of class FullTimeStaffHire.
 *
 * author aavash
 * @version vol.1.18.02.2025
 */
// Class definition for FullTimeStaffHire, which extends the StaffHire class
public class FullTimeStaffHire extends StaffHire 
{
    // Instance variables specific to full-time staff
    private double salary; // Salary of the full-time staff
    private int weeklyFractionalHours; // Weekly working hours in fractional format

    // Constructor for FullTimeStaffHire
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, 
    String joiningDate, String qualification, String appointedBy, 
    boolean joined, double salary, int weeklyFractionalHours) 
    {
        // Call the constructor of the superclass (StaffHire) to initialize common fields
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        this.salary = salary; // Set the salary
        this.weeklyFractionalHours = weeklyFractionalHours; // Set weekly fractional hours
    }

    // Accessor methods to retrieve private instance variables
    public double getSalary() { return salary; } // Get salary
    public int getWeeklyFractionalHours()
    { return weeklyFractionalHours; } // Get weekly fractional hours

    // Method to set the salary for the staff member
    public void setSalary(double salary)
    {
        if (isJoined()) { // Check if the staff is currently joined
            this.salary = salary; // Set the salary
        }
        else
        {
            System.out.println("No staff appointed to set the salary."); // Inform if not appointed
        }
    }

    // Method to set weekly fractional hours
    public void setWeeklyFractionalHours(int hours)
    {
        this.weeklyFractionalHours = hours; // Set the weekly fractional hours
    }

    // Override the display method to show full-time staff details
    @Override
    public void display() 
    {
        super.display(); // Call the display method of the superclass to show common details
        // Display specific details for full-time staff
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }

    @Override
    public String getDetailsAsString() {
        StringBuilder details = new StringBuilder(super.getDetailsAsString());
        details.append("Salary: ").append(getSalary()).append("\n");
        details.append("Weekly Fractional Hours: ").append(getWeeklyFractionalHours()).append("\n");
        return details.toString();
    }

}