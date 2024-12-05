
package Fxml.AbdullahClass;

import java.time.LocalDate;
import java.util.Date;

public class PerDayTakeAttendence {
    CleaningSupervisor person;
    LocalDate presentdate;

    public PerDayTakeAttendence(CleaningSupervisor person, LocalDate presentdate) {
        this.person = person;
        this.presentdate = presentdate;
    }
    
       public PerDayTakeAttendence() {
       
    }

    public CleaningSupervisor getPerson() {
        return person;
    }

    public LocalDate getPresentdate() {
        return presentdate;
    }

    public void setPerson(CleaningSupervisor person) {
        this.person = person;
    }

    public void setPresentdate(LocalDate presentdate) {
        this.presentdate = presentdate;
    }

    @Override
    public String toString() {
        return "person=" + person + ", presentdate=" + presentdate ;
    }
    
}
