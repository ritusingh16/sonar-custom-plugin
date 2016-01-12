package org.sonar.samples.java.checks;

import java.util.Collection;
import java.util.List;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.LiteralTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.samples.java.SubscriptionBaseVisitor;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

/**
 * This class is an example of how to implement your own rules.
 * The (stupid) rule raises a minor issue each time a method is encountered.
 * The @Rule annotation allows to specify metadata like rule key, name, description
 * or default severity.
 */
@Rule(key = "MethodDeclaration",
  name = "Avoid using Hardcode",
  description = "Avoid hardcoded values",
  tags = {"custom", "hardcoded"},
  
  // default severity (formerly "priority") when rule is enabled in Quality profile
  priority = Priority.MINOR)
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.INSTRUCTION_RELIABILITY)
@SqaleConstantRemediation("10min")

public class AvoidHardCodedStringRule extends BaseTreeVisitor implements JavaFileScanner{

private final Multimap<String, LiteralTree> occurrences = ArrayListMultimap.create();
private JavaFileScannerContext context;

@Override
 public void scanFile(JavaFileScannerContext context) {
	
	this.context = context;

    scan(context.getTree());

    System.out.println(PrinterVisitor.print(context.getTree()));
  }	
 
@Override
public void visitLiteral(LiteralTree tree){
   if (tree.is(Tree.Kind.STRING_LITERAL)) {
	   context.addIssue(tree, this, "Avoid hardcoded values");
   }
 }
}