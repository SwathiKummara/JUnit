package com.luv2code.junitdemo;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTests {
    @Test
    @Disabled("Dont run until JIRA #123 is resolved")
    void basicTest(){

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testforlinuxonly(){

    }
    @Test
    @EnabledOnOs({OS.MAC,OS.AIX})
    void enableformacandaix(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8,max=JRE.JAVA_10)
    void testForJavarange(){}


    @Test
    @EnabledIfEnvironmentVariable(named = "luv2code",matches = "DEV")
    void testonlyforenvironmentvariable(){

    }

}
