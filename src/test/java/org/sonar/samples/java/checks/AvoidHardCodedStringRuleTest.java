package org.sonar.samples.java.checks;

import org.junit.Test;
//import org.sonar.samples.java.checks.*;
import org.sonar.java.checks.verifier.JavaCheckVerifier;


public class AvoidHardCodedStringRuleTest {
 @Test 
public void detected() {
	   
	    JavaCheckVerifier.verifyNoIssue("src/test/files/checks/AvoidHardcodedStringsRuleCheck.java",new AvoidHardCodedStringRule());
	  }
	
}
