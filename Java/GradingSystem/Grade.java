package GradingSystem;
import java.util.*;

public class Grade {

    public ArrayList<String> surname = new ArrayList<String>();
    ArrayList<Double> Prelim = new ArrayList<Double>();
    ArrayList<Double> Midterm = new ArrayList<Double>();
    ArrayList<Double> Prefinals = new ArrayList<Double>();
    ArrayList<Double> Finals = new ArrayList<Double>();

    Scanner sc = new Scanner(System.in);
    double grade;
    

    public void addGrade(String sn, double pl, double mt, double pf, double f)
    {
      
      double p = pl * 0.2;
      Prelim.add(p);
      double m = mt * 0.2;
      Midterm.add(m);
      double pef = pf * 0.2;
      Prefinals.add(pef);
      double ff =  f * 0.4;
      Finals.add(ff);

    }   

}
