
package org.sonar.samples.java;


import org.sonar.java.resolve.SemanticModel;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScannerContext;

public abstract class SubscriptionBaseVisitor extends IssuableSubscriptionVisitor {

  private SemanticModel semanticModel;

  @Override
  public void scanFile(JavaFileScannerContext context) {
    semanticModel = (SemanticModel) context.getSemanticModel();
    super.scanFile(context);
  }

  public SemanticModel getSemanticModel() {
    return semanticModel;
  }
}
