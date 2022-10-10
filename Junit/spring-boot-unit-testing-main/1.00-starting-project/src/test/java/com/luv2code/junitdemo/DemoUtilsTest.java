package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)



class DemoUtilsTest {

    DemoUtils demoUtils;
    @Test
    @DisplayName("Equals and not Equals")
    @Order(1)
     void testEqualsAndNotEquals(){

         assertEquals(6,demoUtils.add(2,4),"2+4 mustbe 6");
         assertNotEquals(6,demoUtils.add(1,9),"1+9 must not be six");
     }

     @Test
     @DisplayName("null and not null")
    void testNullAndNotNull(){

         String str1 = null;
         String str2 = "swathi";
         assertNull(demoUtils.checkNull(str1),"object should be null");
         assertNotNull(demoUtils.checkNull(str2),"object should not be null");

    }
    @Test
    @DisplayName("same and not same")
    @Order(0)
    void testSameAndNotSame(){
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(),demoUtils.getAcademyDuplicate(),"objects should be same");
        assertNotSame(str,demoUtils.getAcademy(),"objects should not be same");
    }

    @Test
    @DisplayName("true and false")
    void testTrueFalse(){

        int num1 = 10;
        int num2 = 5;
        assertTrue(demoUtils.isGreater(num1,num2),"this should be true");
        assertFalse(demoUtils.isGreater(num2,num1),"this should be false");
    }

    @DisplayName("Array Equals")
    @Test
    @Order(-2 )
    void testArrayEquals(){

        String[] array = {"A","B","C"};
        assertArrayEquals(array,demoUtils.getFirstThreeLettersOfAlphabet(),"Arrays should be same");

    }

    @DisplayName("Multiply")
    @Test
    void testMultiply(){
        assertEquals(12,demoUtils.multiply(4,3),"should return 12");
    }
    @Test
    @DisplayName("Iterable equals ")
    void testIterableEquals(){
        List<String> theList = List.of("luv","2","code");
        assertIterableEquals(theList,demoUtils.getAcademyInList(),"expected list should be same");
    }

    @Test
    @DisplayName("lines match")
    void testLinesMatch(){

        List<String> theList = List.of("luv","2","code");
        assertIterableEquals(theList,demoUtils.getAcademyInList(),"lines should be same");
    }

    @Test
    @DisplayName("throws and does not throws")
    void testThrowsAndDoesNOtThrow(){

        assertThrows(Exception.class,()->{demoUtils.throwException(-1);},"should throw the exception");
        assertDoesNotThrow(()->{demoUtils.throwException(5);},"should not throw the exception");
    }

    @Test
    @DisplayName("timeout")
    void testTimeOut(){

        assertTimeoutPreemptively(Duration.ofSeconds(3),()->{demoUtils.checkTimeout();},"method should excute in 3 seconds");
    }
    @BeforeEach
    void  setupBeforeEach(){
        demoUtils = new DemoUtils();
    }
//    @AfterEach
//    void  setupAfterEach(){
//        demoUtils = new DemoUtils();
//        System.out.println("@After each exicutes");
//    }
//
//    @BeforeAll
//    static void  setupBeforeAll(){
//        System.out.println("@before All exicutes");
//    }
//    @AfterAll
//    static void  setupAfterAll(){
//        System.out.println("@After All exicutes");
//    }
}
