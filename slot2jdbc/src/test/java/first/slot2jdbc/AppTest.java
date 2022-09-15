package first.slot2jdbc;

/* Here we check our java program in which we check our methods like add employee,remove employee,hiketoemployee
 *  @author PRIYANSHU */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppTest {
	
    hrDao emdao = new hrDao();                  // Here we create object for hrDAo
	hrEmployes emp = new hrEmployes();         // Here we create object for hrEmployee
	
	// Here we perform testing for add employee into database
	@Test
	void testaddEmployes() throws Exception {
		emdao.connect();
		emp.eName="Arun";
		emp.eDomain="c";
		emp.eLocation="mmknk";
		emp.ePhone ="9865785";
		emp.eSalary=10000;
                                   
		assertEquals(-1,emdao .addEmploye(emp));	// Here we check for existed employee
		
		emp.eName="Chaman";
		emp.eDomain="c++";
		emp.eLocation="Delhi";
		emp.ePhone ="654321987";
		emp.eSalary=20000;
		

		assertEquals(1,emdao .addEmploye(emp));	   // Here we check new employee in data 
	}
	
	// Here we perform testing for hike to employee salary
	@Test
	void testHikeSalary() throws Exception{
		emdao .connect();
		
		
		assertEquals(11000,emdao .hikeToEmploye(7,10));

		
		assertEquals(0,emdao .hikeToEmploye(111, 20));
		
	}
	
	// Here we perform testing for remove employee
	@Test
	void testRemoveEmployee() throws Exception{

		emdao .connect();
		
		// Testing to delete non existing employee
		assertEquals(0,emdao . removeEmploye(122));
		
		// Testing to delete existing employee
		assertEquals(1,emdao. removeEmploye(6));
	}

}