
package Fxml.AbdullahClass;

import java.io.Serializable;

public class Employee implements Serializable {
    String EmployeName;
    int EmployeId;
    int Employeeage;
    int salary;
    String LeaveApplication;

    public void setLeaveApplication(String LeaveApplication) {
        this.LeaveApplication = LeaveApplication;
    }

    public String getLeaveApplication() {
        return LeaveApplication;
    }
    

    public int getSalary() {
        return salary;
    }

    public void setEmployeeage(int Employeeage) {
        this.Employeeage = Employeeage;
    }

    public int getEmployeeage() {
        return Employeeage;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    

    public String getEmployeName() {
        return EmployeName;
    }

    public int getEmployeId() {
        return EmployeId;
    }

    public void setEmployeName(String EmployeName) {
        this.EmployeName = EmployeName;
    }

    public void setEmployeId(int EmployeId) {
        this.EmployeId = EmployeId;
    }

    @Override
    public String toString() {
        return  "EmployeName=" + EmployeName + ", EmployeId=" + EmployeId + ", Employeeage=" + Employeeage + ", salary=" + salary+"\n "+LeaveApplication+"\n";
    }
    
   


    
    
}