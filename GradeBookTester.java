import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Junit class to test the methods of GradeBook
 * @author Paul Dacey
 *
 */
class GradeBookTester {

	GradeBook book1;
	GradeBook book2;
	@BeforeEach
	void setUp() throws Exception 
	{
		book1 = new GradeBook(5);
		book2 = new GradeBook(5);
		
		book1.addScore(88.5);
		book1.addScore(98.5);
		book1.addScore(60.8);
		book1.addScore(12.3);
		book1.addScore(45.6);
		
		book2.addScore(99.9);
		book2.addScore(95.1);
		book2.addScore(82.3);
		book2.addScore(79.9);
		book2.addScore(71.2);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		book1=book2=null;
	}
	
	@Test
	void testAddScore() 
	{
		System.out.print(book1.toString());
		assertTrue(book1.toString().equals("88.5 98.5 60.8 12.3 45.6 "));
		assertTrue(book2.toString().equals("99.9 95.1 82.3 79.9 71.2 "));
	} 

	@Test
	void testSum() 
	{
		assertEquals(305.7, book1.sum(), .0001);
		assertEquals(428.4, book2.sum(), .0001);
	}

	@Test
	void testMinimum() 
	{
		GradeBook empty = new GradeBook(1);
		assertEquals(12.3, book1.minimum(), .001);
		assertEquals(71.2, book2.minimum(), .001);
		assertEquals(0, empty.minimum());
	}

	@Test
	void testFinalScore() 
	{
		assertEquals(293.4, book1.finalScore(), .0001);
		assertEquals(357.2, book2.finalScore(), .0001);
	}

	@Test
	void testGetScoreSize() 
	{
		assertEquals(5, book1.getScoreSize());
		assertEquals(5, book2.getScoreSize());
	}


}
