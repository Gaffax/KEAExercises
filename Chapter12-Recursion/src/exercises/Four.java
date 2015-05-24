package exercises;

import java.math.BigDecimal;

public class Four {
	// 4. Write a recursive method called doubleDigits that
	// accepts an integer n as a parameter and returns the integer
	// obtained by replacing every digit of n with two of that digit.
	// For example, doubleDigits(348) should return
	// 334488. The call doubleDigits(0) should return 0. Calling doubleDigits
	// on a negative number should return
	// the negation of calling doubleDigits on the corresponding positive
	// number; for example, doubleDigits(–789)
	// should return –778899.
	
	public long doubleDigits(long amt) { //I am using long to be able to handle larger numbers
										 //Long min/max = (-)9,223,372,036,854,775,807
	    if (amt == 0) 
	    	return 0;     
	    return doubleDigits(amt / 10) * 100 + (amt % 10) * 10 + amt % 10;        
	}
}
