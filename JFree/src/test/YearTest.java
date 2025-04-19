package test;

import org.jfree.data.time.Year;
import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class YearTest
{
    Year year;

    private void arrange()
    {
        year = new Year();
    }

    @Test
    public void testYearDefaultCtor()
    {
        arrange();
        Year year = new Year();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear, year.getYear());
    }


    @Test
    public void testGetYear() {
        Year year = new Year(2020);
        assertEquals(2020, year.getYear());
    }

    @Test
    public void testGetSerialIndex() {
        Year year = new Year(2023);
        assertEquals(2023, year.getSerialIndex());
    }

    @Test
    public void testCompareToYear1IsBeforeYear2() {
        Year year1 = new Year(2020);
        Year year2 = new Year(2025);
        assertTrue(year1.compareTo(year2) < 0);
    }
    
    @Test
    public void testCompareToYear1IsEqualYear2() {
        Year year1 = new Year(2020);
        Year year2 = new Year(2020);
        assertEquals(0, year1.compareTo(year2));
    }
    
    @Test
    public void testCompareToYear1IsAfterYear2() {
        Year year1 = new Year(2025);
        Year year2 = new Year(2020);
        assertTrue(year2.compareTo(year1) < 0);
    }


    @Test
    public void testEqualsYear1IsEqualToYear2SameType() {
        Year y1 = new Year(2022);
        Year y2 = new Year(2022);
        assertTrue(y1.equals(y2));
    }

    @Test
    public void testEqualsYear1IsBeforeYear2SameType() {
        Year y1 = new Year(2022);
        Year y2 = new Year(2023);
        assertFalse(y1.equals(y2));
    }

    @Test
    public void testEqualsYear1IsAfterYear2SameType() {
        Year y1 = new Year(2022);
        Year y2 = new Year(2020);
        assertFalse(y1.equals(y2));
    }

    @Test
    public void testEqualsYear1IsEqualYear2DifferentTypes() {
        Year y1 = new Year(2022);
        java.time.Year y2 = java.time.Year.of(2022);
        assertFalse(y1.equals(y2));  // different object type
    }

    @Test
    public void testEqualsYear2IsNotAYear() {
        Year y1 = new Year(2022);
        String y2 = "2022";
        assertFalse(y1.equals(y2));  // different object type
    }
    @Test
    public void testEqualsYear2IsNull() {
        Year y1 = new Year(2022);
        Year y2 = null;
        assertFalse(y1.equals(y2));  // different object type
    }


    
    @Test
    public void testNextBeforeBoundry() {
        Year year = new Year(2024);
        assertEquals(new Year(2025), year.next());
    }
    @Test
    public void testNextAtBountry() {
        Year year = new Year(9999);
        assertNull(year.next());
    }
    @Test
    public void testPreviousAfterBoundry() {
        Year year = new Year(2024);
        assertEquals(new Year(2023), year.previous());
    }
    @Test
    public void testPreviousAtBoundry() {
        Year year = new Year(1900);
        assertNull(year.previous());
    }

    @Test
    public void testPreviousBeforeBoundry() {
        Year year = new Year(1800);
        assertNull(year.previous());
    }


    @Test
    public void testToString() {
        Year year = new Year(2024);
        assertEquals("2024", year.toString());
    }
    @Test
    public void testHashCodeConsistency() {
        Year y1 = new Year(2021);
        Year y2 = new Year(2021);
        assertEquals(y1.hashCode(), y2.hashCode());
    }
    @Test
    public void testParseYear() {
        Year year = Year.parseYear("2025");
        assertEquals(new Year(2025), year);
    }
    @Test
    public void testFirstAndLastMillisecond() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        Year year = new Year(2020);

        assertEquals(1577836800000L, year.getFirstMillisecond(cal));
        assertEquals(1609459199999L, year.getLastMillisecond(cal));
    }





}
