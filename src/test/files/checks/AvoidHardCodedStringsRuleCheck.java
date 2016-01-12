/*class A {

  int foo() {}
  int foo(int a) {} // Noncompliant {{message}}
  int foo(int a, int b) {}

  Object foo(Object a){} // Noncompliant {{message}}
  String foo(String a){} // Noncompliant {{message}}
  String foo(Object a){}
}
*/

@Test
public void verify_no_issue() {
  JavaCheckVerifier.verifyNoIssue(FILENAME_NO_ISSUE, NO_EFFECT_VISITOR);
}