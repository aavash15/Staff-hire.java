/**
 * Description of staffHireGUI.
 * A system that stores details of vacancy and hired staff details in the list.
 * The class will contain a main method and will be tested using the command prompt. 
 *------------------------------------------------------------------------------------------------------------------------------------------------
 * GUI contain all required components,  
 *The Recruitment class should store type StaffHire to hold the FullTimeStaffHire and PartTimeStaffHire.
 *--------------------------------------------------------------------------------------------------------------------------------------------------
 * 
 * @author aavash
 * @version vol.1.18.02.2025
 */


import javax.swing.*; // Importing Swing components for GUI
import java.awt.*; // Importing AWT classes for layout management
import java.awt.event.ActionEvent; // Importing ActionEvent for handling button actions
import java.awt.event.ActionListener; // Importing ActionListener interface for event handling
import java.util.ArrayList; // Importing ArrayList for dynamic array functionality

public class StaffHireGUI extends JFrame // Class definition for StaffHireGUI, which extends JFrame to create a window
 {
    private ArrayList<StaffHire> staffList = new ArrayList<>(); //array 
    
    // Input fields for the required field
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField, 
                       joiningDateField, qualificationField, appointedByField, 
                       salaryField, weeklyHoursField, workingHoursField, wagesPerHourField, shiftsField;
                       
    private JCheckBox joinedCheckbox; // Changed from JTextField to JCheckBox for joined status with proper color styling

   
        // Constructor for StaffHireGUI
    public StaffHireGUI() 
    {
        // Set the title of the window
        setTitle("Staff Hire Management");
        // Set the size of the window (width x height)
        setSize(400, 600);
        // Set the default close operation to exit the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the layout manager to a grid layout with 2 columns
        setLayout(new GridLayout(0, 2));

        // Initialize input fields for user input
        vacancyNumberField = new JTextField(); // Field for vacancy number
        designationField = new JTextField(); // Field for job designation
        jobTypeField = new JTextField(); // Field for job type (e.g., full-time, part-time)
        staffNameField = new JTextField(); // Field for staff member's name
        joiningDateField = new JTextField(); // Field for joining date
        qualificationField = new JTextField(); // Field for staff member's qualifications
        appointedByField = new JTextField(); // Field for who appointed the staff member
        salaryField = new JTextField(); // Field for salary
        weeklyHoursField = new JTextField(); // Field for weekly working hours
        workingHoursField = new JTextField(); // Field for daily working hours
        wagesPerHourField = new JTextField(); // Field for wages per hour
        shiftsField = new JTextField(); // Field for shifts (e.g., morning, evening)

        joinedCheckbox = new JCheckBox("Joined"); // Checkbox for joined status
        joinedCheckbox.setBackground(new Color(173, 216, 230)); // Light blue background for visibility
        joinedCheckbox.setForeground(Color.BLACK); // Set text color to black
        joinedCheckbox.setOpaque(true); // ensure background color shows

        // Add labels and input fields to the frame
        add(new JLabel("Vacancy Number:")); // Label for vacancy number
        add(vacancyNumberField); // Input field for vacancy number
        add(new JLabel("Designation:")); // Label for designation
        add(designationField); // Input field for designation
        add(new JLabel("Job Type:")); // Label for job type
        add(jobTypeField); // Input field for job type
        add(new JLabel("Staff Name:")); // Label for staff name
        add(staffNameField); // Input field for staff name
        add(new JLabel("Joining Date:")); // Label for joining date
        add(joiningDateField); // Input field for joining date
        add(new JLabel("Qualification:")); // Label for qualification
        add(qualificationField); // Input field for qualification
        add(new JLabel("Appointed By:")); // Label for appointed by
        add(appointedByField); // Input field for appointed by

        // Replace "Joined (true/false):" label and textfield with just the checkbox
        add(new JLabel("Joined:")); // Label for joined status
        add(joinedCheckbox); // Checkbox for joined status with style

        add(new JLabel("Salary:")); // Label for salary
        add(salaryField); // Input field for salary
        add(new JLabel("Weekly Hours:")); // Label for weekly hours
        add(weeklyHoursField); // Input field for weekly hours
        add(new JLabel("Working Hours:")); // Label for working hours
        add(workingHoursField); // Input field for working hours
        add(new JLabel("Wages Per Hour:")); // Label for wages per hour
         // Add input fields for wages per hour and shifts to the frame
        add(wagesPerHourField); // Input field for wages per hour
        add(new JLabel("Shifts:")); // Label for shifts
        add(shiftsField); // Input field for shifts

        // Add buttons to the frame with associated actions
        addButton("Add Full Time Staff", e -> addFullTimeStaff()); // Button to add full-time staff
        addButton("Add Part Time Staff", e -> addPartTimeStaff()); // Button to add part-time staff
        addButton("Set Salary - Full Time Staff", e -> setSalary()); // Button to set salary for full-time staff
        addButton("Set Working Shifts - Part Time Staff", e -> setWorkingShifts()); // Button to set shifts for part-time staff
        addButton("Terminate Staff", e -> terminatePartTimeStaff()); // Button to terminate part-time staff
        addButton("Display Number", e -> displayStaff()); // Button to display staff details
        addButton("Clear", e -> clearFields()); // Button to clear input fields

        // Make the GUI visible
        setVisible(true); // Show the GUI window
    }

    // Method to create and add a button to the frame
    private void addButton(String text, ActionListener action) 
    {
        JButton button = new JButton(text); // Create a new button with the specified text
        button.addActionListener(action); // Add the action listener to the button
        add(button); // Add the button to the frame
    }

    // Method to add a full-time staff member
    private void addFullTimeStaff() 
    {
        try
        {
            // Retrieve and parse input values from the text fields
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText()); // Get vacancy number
            String designation = designationField.getText(); // Get designation
            String jobType = jobTypeField.getText(); // Get job type
            String staffName = staffNameField.getText(); // Get staff name
            String joiningDate = joiningDateField.getText(); // Get joining date
            String qualification = qualificationField.getText(); // Get qualification
            String appointedBy = appointedByField.getText(); // Get who appointed the staff
            boolean joined = joinedCheckbox.isSelected(); // Get joined status from checkbox
            double salary = Double.parseDouble(salaryField.getText()); // Get salary
            int weeklyHours = Integer.parseInt(weeklyHoursField.getText()); // Get weekly working hours

            // Create a new FullTimeStaffHire object with the collected data
            FullTimeStaffHire staff = new FullTimeStaffHire(vacancyNumber, designation, jobType, staffName, 
                                                             joiningDate, qualification, appointedBy, 
                                                             joined, salary, weeklyHours);
            // Add the new staff member to the staff list
            staffList.add(staff);
            // Show a success message to the user
            JOptionPane.showMessageDialog(this, "Full Time Staff Added Successfully!");
        } 
        catch (Exception e) // Catch any exceptions that occur during the process
        {
            // Show an error message if adding staff fails
            JOptionPane.showMessageDialog(this, "Error adding Full Time Staff: " + e.getMessage());
        }
    }

    // Method to add a part-time staff member
    private void addPartTimeStaff() 
    {
        try
        {
            // Retrieve input values from the text fields
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            String joiningDate = joiningDateField.getText();
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedCheckbox.isSelected(); // Get joined status from checkbox
            int workingHours = Integer.parseInt(workingHoursField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            String shifts = shiftsField.getText();

            // Create a new PartTimeStaffHire object and add it to the staff list
            PartTimeStaffHire staff = new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName, 
                                                             joiningDate, qualification, appointedBy, 
                                                             joined, workingHours, wagesPerHour, shifts);
            staffList.add(staff);
            // Show success message
            JOptionPane.showMessageDialog(this, "Part Time Staff Added Successfully!");
        } 
        catch (Exception e) 
        {
            // Show error message if adding staff fails
            JOptionPane.showMessageDialog(this, "Error adding Part Time Staff: " + e.getMessage());
        }
    }

    // Method to set the salary for a full-time staff member
    private void setSalary() 
    {
        try
        {
            // Retrieve input values for vacancy number and staff name
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String staffName = staffNameField.getText();
            double salary = Double.parseDouble(salaryField.getText());

            // Search for the staff member in the list and set the salary
            for (StaffHire staff : staffList) 
            {
                if (staff instanceof FullTimeStaffHire && staff.getVacancyNumber() == vacancyNumber && staff.getStaffName().equals(staffName)) {
                    ((FullTimeStaffHire) staff).setSalary(salary);
                    JOptionPane.showMessageDialog(this, "Salary Set Successfully!");
                    return;
                }
            }
            // Show message if staff not found
            JOptionPane.showMessageDialog(this, "Staff not found!");
        }
        catch (Exception e)
        {
            // Show error message if setting salary fails
            JOptionPane.showMessageDialog(this, "Error setting salary: " + e.getMessage());
        }
    }

    // Method to set working shifts for a part-time staff member
    private void setWorkingShifts()
    {
        try
        {
            // Retrieve input values for vacancy number and staff name
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String staffName = staffNameField.getText();
            String shifts = shiftsField.getText();

            // Search for the staff member in the list and set the shifts
            for (StaffHire staff : staffList)
            {
                if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancyNumber && staff.getStaffName().equals(staffName)) {
                    ((PartTimeStaffHire) staff).setShifts(shifts);
                    JOptionPane.showMessageDialog(this, "Shifts Set Successfully!");
                    return;
                }
            }
            // Show message if staff not found
            JOptionPane.showMessageDialog(this, "Staff not found!");
        } catch (Exception e)
        {
            // Show error message if setting shifts fails
            JOptionPane.showMessageDialog(this, "Error setting shifts: " + e.getMessage());
        }
    }

    // Method to terminate a part-time staff member
    
    private void terminatePartTimeStaff()
    {
        try {
            // Retrieve input value for vacancy number
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());

            // Search for the staff member in the list and terminate them
            for (StaffHire staff : staffList) 
            {
                if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancyNumber) {
                    ((PartTimeStaffHire) staff).terminate();
                    JOptionPane.showMessageDialog(this, "Part Time Staff Terminated Successfully!");
                    return;
                }
            }
            // Show message if staff not found
            JOptionPane.showMessageDialog(this, "Staff not found!");
        } catch (Exception e)
        {
            // Show error message if termination fails
            JOptionPane.showMessageDialog(this, "Error terminating staff: " + e.getMessage());
        }
    }
        // Method to display details of a staff member based on the vacancy number
    private void displayStaff() {
    try {
        int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
        
        for (StaffHire staff : staffList) {
            if (staff.getVacancyNumber() == vacancyNumber) {
                // Get details as string
                String details = staff.getDetailsAsString(); // Use the method from the previous example
                
                // Create a JTextArea for better formatting
                JTextArea textArea = new JTextArea(details);
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
                textArea.setBackground(new Color(240, 240, 240)); // Light gray background
                
                // Create a scroll pane in case there's a lot of text
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 300));
                
                // Show the dialog with the scroll pane
                JOptionPane.showMessageDialog(this, scrollPane, "Staff Details", JOptionPane.INFORMATION_MESSAGE);
                
                // Also call the original display method if you still want console output
                staff.display();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Staff not found!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error displaying staff: " + e.getMessage());
    }
}

    // Method to clear all input fields in the GUI
    private void clearFields()
    {
        // Set the text of each input field to an empty string
        vacancyNumberField.setText(""); // Clear vacancy number
        designationField.setText(""); // Clear designation
        jobTypeField.setText(""); // Clear job type
        staffNameField.setText(""); // Clear staff name
        joiningDateField.setText(""); // Clear joining date
        qualificationField.setText(""); // Clear qualification
        appointedByField.setText(""); // Clear appointed by
        joinedCheckbox.setSelected(false); // Clear checkbox for joined status
        salaryField.setText(""); // Clear salary
        weeklyHoursField.setText(""); // Clear weekly hours
        workingHoursField.setText(""); // Clear working hours
        wagesPerHourField.setText(""); // Clear wages per hour
        shiftsField.setText(""); // Clear shifts
    }

    // Main method to run the application
    public static void main(String[] args) 
    {
        // Use SwingUtilities to ensure that the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(StaffHireGUI::new);
    }
}
