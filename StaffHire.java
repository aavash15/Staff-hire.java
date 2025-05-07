import java.util.ArrayList;

/**
 * Description of class StaffHire.
 *Staffhire has 8 attributes
 *
 *atteibutes such as 
 *- [Vacancy number,Designation, Job Type (Job Type indicates permanent, contact, temporary job) 
 *staffName, joiningDate, qualification, appointedBy and joined ]
 *------------------------------------------------------------------------
 *                           Type of the variable                         |                           
 *------------------------------------------------------------------------
 * designation                        | string                            |
 * jobType                            | string                            |
 * staffName                          | string                            |
 * joiningDate                        | string                            |
 * qualification                      | string                            |
 * appointedBy                        | string                            |
 * ------------------------------------------------------------------------
 * vacancy number                     | whole number                      |
 * joined                             | Boolean                           |
 * ------------------------------------------------------------------------
 * 
 * The vacancyNumber, designation, jobType, staffName, joiningDate, qualification, 
 * appointedBy and joined are initialized in the constructor by being assigned values
 * of the constructor's parameters. Each attribute has a corresponding accessor method
 * (i.e. getter and setter methods for all attributes). A display method will output
 * (suitably annotated) the vacancy number, designation and job type, staff Name, 
 * join date, qualification, appointed by, joined. 
 * 
 * 
 * @author aavash
 * @version vol.1.18.02.2025
 */
// Class definition for StaffHire, representing a staff member's hiring details
public class StaffHire
{
    // Instance variables to store staff details
    private String designation; // Designation of the staff member
    private String jobType; // Type of job (e.g., full-time, part-time)
    private String staffName; // Name of the staff member
    private String joiningDate; // Date the staff member joined
    private String qualification; // Qualification of the staff member
    private String appointedBy; // Name of the person who appointed the staff member
    private int vacancyNumber; // Vacancy number associated with the staff member
    private Boolean joined; // Status indicating if the staff member has joined

    /**
     * Constructor for objects of class StaffHire
     * Initializes the staff member's details
     */
    public StaffHire(int vacancyNumber, String designation, String jobType, String staffName, 
    String joiningDate, String qualification, String appointedBy, boolean joined) 
    {
        this.vacancyNumber = vacancyNumber; // Set vacancy number
        this.designation = designation; // Set designation
        this.jobType = jobType; // Set job type
        this.staffName = staffName; // Set staff name
        this.joiningDate = joiningDate; // Set joining date
        this.qualification = qualification; // Set qualification
        this.appointedBy = appointedBy; // Set appointed by
        this.joined = joined; // Set joined status
    }

    // Accessor methods to retrieve and modify private instance variables
    public int getVacancyNumber() { return vacancyNumber; } // Get vacancy number
    public void setVacancyNumber(int vacancyNumber) { this.vacancyNumber = vacancyNumber; } // Set vacancy number

    public String getDesignation() { return designation; } // Get designation
    public void setDesignation(String designation) { this.designation = designation; } // Set designation

    public String getJobType() { return jobType; } // Get job type
    public void setJobType(String jobType) { this.jobType = jobType; } // Set job type

    public String getStaffName() { return staffName; } // Get staff name
    public void setStaffName(String staffName) { this.staffName = staffName; } // Set staff name

    public String getJoiningDate() { return joiningDate; } // Get joining date
    public void setJoiningDate(String joiningDate) { this.joiningDate = joiningDate; } // Set joining date

    public String getQualification() { return qualification; } // Get qualification
    public void setQualification(String qualification) { this.qualification = qualification; } // Set qualification

    public String getAppointedBy() { return appointedBy; } // Get appointed by
    public void setAppointedBy(String appointedBy) { this.appointedBy = appointedBy; } // Set appointed by

    public boolean isJoined() { return joined; } // Check if staff is joined
    public void setJoined(boolean joined) { this.joined = joined; } // Set joined status

    // Method to display staff member's details
    public void display()
    {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }

    // Method to amend the joined status of the staff member
    public void amendJoinedStatus(boolean status)
    {
        this.joined = status; // Update the joined status
    }

    public String getDetailsAsString() {
        StringBuilder details = new StringBuilder();
        details.append("Vacancy Number: ").append(getVacancyNumber()).append("\n");
        details.append("Designation: ").append(getDesignation()).append("\n");
        details.append("Job Type: ").append(getJobType()).append("\n");
        details.append("Staff Name: ").append(getStaffName()).append("\n");
        details.append("Joining Date: ").append(getJoiningDate()).append("\n");
        details.append("Qualification: ").append(getQualification()).append("\n");
        details.append("Appointed By: ").append(getAppointedBy()).append("\n");
        details.append("Joined: ").append(isJoined()).append("\n");
        return details.toString();
    }
}