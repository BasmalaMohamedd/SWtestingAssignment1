package test;

import JFree.DiscountCalculator;
import org.jfree.data.time.Week;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
public class DiscountCalculatorTest
{

    // Test missing cases ( JUNE, 23 is a date in week 26 )
    /********************************************************************************************/
    @Test(expected = NullPointerException.class)
    public void testNullWeekInput()
    {
        DiscountCalculator discountCalculator ;
        discountCalculator = new DiscountCalculator(null);
        discountCalculator.isTheSpecialWeek();
    }
    /**************************************************************************************************/
    @Test
    public void testIsTheSpecialWeekWhenFalse() throws Exception
    {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.MARCH, 22);  // March 22, 2025
        Date date = calendar.getTime();
        Week week = new Week(date);
        DiscountCalculator discountCalculator = new DiscountCalculator(week);
        assertFalse(discountCalculator.isTheSpecialWeek());
    }
    /**************************************************************************************************/
    @Test
    public void testIsTheSpecialWeekWhenTrue() throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, 23);
        Date date = calendar.getTime();
        Week week = new Week(date);
        DiscountCalculator discountCalculator = new DiscountCalculator(week);
        assertTrue(discountCalculator.isTheSpecialWeek());
    }
    /**************************************************************************************************/
    //unexpected case
    @Test
    public void testIsTheSpecialWeekWhenisnegativeTrue() throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, -29);
        Date date = calendar.getTime();
        Week week = new Week(date);
        DiscountCalculator discountCalculator = new DiscountCalculator(week);
        assertTrue(discountCalculator.isTheSpecialWeek());
    }
    /**************************************************************************************************/
    //unexpected case
    @Test
    public void testIsTheSpecialWeekWhenisnegativeFalse() throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, -8);
        Date date = calendar.getTime();
        Week week = new Week(date);
        DiscountCalculator discountCalculator = new DiscountCalculator(week);
        assertFalse(discountCalculator.isTheSpecialWeek());
    }
    /**************************************************************************************************/
    @Test
    public void getDiscountForEvenWeeksTest() throws Exception
   {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JUNE, 23);
        Date date = calendar.getTime();
        Week week = new Week(date);
       DiscountCalculator discountCalculator = new DiscountCalculator(week);
        int Result=discountCalculator.getDiscountPercentage();
       int expected = (week.getWeek() % 2 == 0) ? 7 : 5;
        assertEquals(expected, Result);
        assertTrue(week.getWeek() % 2 == 0);
   }
    /**************************************************************************************************/
    @Test
    public void getDiscountForOddWeeksTest() throws Exception
   {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JANUARY, 1);
        Date date = calendar.getTime();
        Week week = new Week(date);
       DiscountCalculator discountCalculator = new DiscountCalculator(week);
        int Result=discountCalculator.getDiscountPercentage();
       int expected = (week.getWeek() % 2 == 0) ? 7 : 5;
        assertEquals(expected, Result);
       assertTrue(week.getWeek() % 2 != 0);
   }
    /**************************************************************************************************/
    //this case not realistic but can process it
    @Test
    public void getDiscountforNegativeEvenWeeksTest()throws Exception
   {
       Calendar calendar = Calendar.getInstance();
       calendar.set(2025, Calendar.JANUARY, -8);
       Date date = calendar.getTime();
       Week week = new Week(date);
       DiscountCalculator discountCalculator = new DiscountCalculator(week);
       int Result=discountCalculator.getDiscountPercentage();
       int expected = (week.getWeek() % 2 == 0) ? 7 : 5;
       assertEquals(expected, Result);
   }
/**************************************************************************************************/
   //this case not realistic but can process it
   @Test
   public void getDiscountforNegativeOddWeeksTest()throws Exception
   {
       Calendar calendar = Calendar.getInstance();
       calendar.set(2025, Calendar.JANUARY, -1);
       Date date = calendar.getTime();
       Week week = new Week(date);
       DiscountCalculator discountCalculator = new DiscountCalculator(week);
       int Result=discountCalculator.getDiscountPercentage();
       int expected = (week.getWeek() % 2 == 0) ? 7 : 5;
       assertEquals(expected, Result);
   }
/****************************************************************************************************/
@Test
public void testWeekJustBeforeSpecialWeekTest()  throws Exception {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2025, Calendar.JUNE, 21);
    Week week = new Week(calendar.getTime());
    DiscountCalculator dc = new DiscountCalculator(week);
    assertFalse(dc.isTheSpecialWeek());
}
/********************************************************************************************************/
    @Test
    public void testWeekJustAfterSpecialWeek()  throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2025, Calendar.JULY, 1);
        Week week = new Week(calendar.getTime());
        DiscountCalculator dc = new DiscountCalculator(week);
        assertFalse(dc.isTheSpecialWeek());
    }

}
