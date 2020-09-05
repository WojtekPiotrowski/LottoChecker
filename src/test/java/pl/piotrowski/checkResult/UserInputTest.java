package pl.piotrowski.checkResult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.MockitoAnnotations.openMocks;

public class UserInputTest {

    @Mock
    InputSource inputSource;

    private UserInput sut;


    @Before
    public void setUp() {
        openMocks(this);

        sut = new UserInput(inputSource);
    }

    @Test
    public void should_return_empty_array_when_input_is_null() {
        Mockito.when(inputSource.getInput()).thenReturn(null);

        int[] result = sut.getSortedNumbers();

        Assert.assertNotNull(result);
        Assert.assertEquals(result.length, 0);
    }

    @Test
    public void should_return_empty_array_when_input_empty_string() {
        Mockito.when(inputSource.getInput()).thenReturn("");

        int[] result = sut.getSortedNumbers();

        Assert.assertNotNull(result);
        Assert.assertEquals(result.length, 0);
    }



    @Test
    public void should_return_4_element_array_in_order() {
        Mockito.when(inputSource.getInput()).thenReturn("4,3,2,1");

        int[] result = sut.getSortedNumbers();

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    public void should_return_6_element_array_in_order_with_white_chars() {
        Mockito.when(inputSource.getInput()).thenReturn("-100, 100, 1, 2, 19, 20");

        int[] result = sut.getSortedNumbers();

        Assert.assertArrayEquals(new int[]{-100, 1, 2, 19, 20, 100}, result);
    }

    @Test
    public void should_return_6_element_array_in_order_with_string_instead_of_numbers() {
        Mockito.when(inputSource.getInput()).thenReturn("-100, 100, hihihi, 2, 19, 20");

        int[] result = sut.getSortedNumbers();

        Assert.assertArrayEquals(new int[]{-100, 0, 2, 19, 20, 100}, result);
    }
}