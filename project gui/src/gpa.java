
public class gpa 
{
	 double gradevalue = 0;
	 String gradeAllocation;
	 double gradevalueaverage ;
	 
	public double ScoreCalculator(double gv1, double gv2) 
	{
		double gradevalue1 = gv1;
		double gradevalue2 = gv2;
		
		double totalgradevalue;
		double credit1 = 3; //for 1st course
		double credit2 = 3; // for 2nd course
		
		double totalcredits = credit1 + credit2 ;
		totalgradevalue = (gradevalue1 * credit1) + (gradevalue2 * credit2) ;
		return gradevalueaverage = totalgradevalue / totalcredits;
		
		
	}
	
	public double Gpa(double score) {
		
		double marks = score;
		
		if(marks >= 95) {
			gradeAllocation =  "A+";
			return gradevalue =   4.33;
		}else if(marks >= 90) {
			gradeAllocation =  "A";
			return gradevalue = 4.00;
		}else if(marks >= 85 ) {
			gradeAllocation =  "A-";
			return gradevalue = 3.67;
		}else if(marks >= 80 ) {
			gradeAllocation =  "B+";
			return gradevalue = 3.33;
		}else if(marks >= 75 ) {
			gradeAllocation =  "B";
			return gradevalue = 3.00;
		}else if(marks >= 70 ) {
			gradeAllocation =  "B-";
			return gradevalue = 2.67;
		}else if(marks >= 65 ) {
			gradeAllocation =  "C+";
			return gradevalue = 2.33;
		}else if(marks >= 60 ) {
			gradeAllocation =  "C";
			return gradevalue = 2.00;
		}else if(marks >= 55 ) {
			gradeAllocation =  "C-";
			return gradevalue = 1.67;
		}else if(marks >= 50 ) {
			gradeAllocation =  "P";
			return gradevalue = 1;
		}else if(marks >= 0 ) {
			gradeAllocation =  "F";
			return gradevalue = 0;
		}else {
			gradeAllocation = "UN";
			return gradevalue = 0;
		}
			
	}
	
}
