package test;
import JFree.DiscountManager;
import JFree.IDiscountCalculator;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import static org.junit.Assert.*;

public class DiscountManagerTest {

    // test case 1:
    // isDiscountSeason = false
    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsFalse() throws Exception {
        // Arrange
        boolean isDiscountsSeason = false;
        double originalPrice = 100.0;
        double expectedPrice = 100.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                // make sure that none of the functions are called
            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act


        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
        mockingContext.assertIsSatisfied();
        assertTrue(expectedPrice == actualPrice);

    }

    // test case 2: 
    // isDiscountSeason = true
    // discountCalculator.isTheSpecialWeek() = true
    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsTrue() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = 80.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                oneOf(mockedDependency).isTheSpecialWeek();
                will(returnValue(true));


            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act

        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);
        


        

        // Assert
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
        mockingContext.assertIsSatisfied();
        assertTrue(expectedPrice == actualPrice);
    }

    // test case 3:
    // isDiscountSeason = true
    // discountCalculator.isTheSpecialWeek() = false
    // currentWeek is even
    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsFalseAndCurrentWeekIsEven() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = 93.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                oneOf(mockedDependency).isTheSpecialWeek();
                will(returnValue(false));

                oneOf(mockedDependency).getDiscountPercentage();
                will(returnValue(7));


            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act

        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);

        // Assert
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
        mockingContext.assertIsSatisfied();
        assertTrue(expectedPrice == actualPrice);
    }

    // test case 4:
    // isDiscountSeason = true
    // discountCalculator.isTheSpecialWeek() = false
    // currentWeek is odd
    @Test
    public void testCalculatePriceWhenDiscountsSeasonIsTrueAndSpecialWeekIsFalseAndCurrentWeekIsOdd() throws Exception {

        // Arrange
        boolean isDiscountsSeason = true;
        double originalPrice = 100.0;
        double expectedPrice = 95.0;

        Mockery mockingContext = new Mockery();
        IDiscountCalculator mockedDependency = mockingContext.mock(IDiscountCalculator.class);
        mockingContext.checking(new Expectations(){
            {
                oneOf(mockedDependency).isTheSpecialWeek();
                will(returnValue(false));

                oneOf(mockedDependency).getDiscountPercentage();
                will(returnValue(5));


            }
        });
        DiscountManager discountManager = new DiscountManager(isDiscountsSeason, mockedDependency);
        // Act

        double actualPrice = discountManager.calculatePriceAfterDiscount(originalPrice);
        
        // Assert
        // make sure that mocking Expectations Is Satisfied
        // make sure that the actual value exactly equals the expected value
        mockingContext.assertIsSatisfied();
        assertTrue(expectedPrice == actualPrice);
    }
    
    
}

