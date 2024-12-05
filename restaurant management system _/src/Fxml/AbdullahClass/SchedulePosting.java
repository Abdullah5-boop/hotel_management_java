package Fxml.AbdullahClass;

import java.io.Serializable;
import java.time.LocalDate;

public class SchedulePosting implements Serializable {
    float mtime,ntime;
    int Mid,Nid;
    LocalDate date;

    public SchedulePosting(float mtime, float ntime, int Mid, int Nid) {
        this.mtime = mtime;
        this.ntime = ntime;
        this.Mid = Mid;
        this.Nid = Nid;
    }
    
      public SchedulePosting() {
       
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
      
      

    public void setMtime(float mtime) {
        this.mtime = mtime;
    }

    public void setNtime(float ntime) {
        this.ntime = ntime;
    }

    public void setMid(int Mid) {
        this.Mid = Mid;
    }

    public void setNid(int Nid) {
        this.Nid = Nid;
    }

    public float getMtime() {
        return mtime;
    }

    public float getNtime() {
        return ntime;
    }

    public int getMid() {
        return Mid;
    }

    public int getNid() {
        return Nid;
    }

    @Override
    public String toString() {
        return "mtime=" + mtime + ", ntime=" + ntime + ", Mid=" + Mid + ", Nid=" + Nid + ", date=" + date + '\n';
    }

 

  
}
