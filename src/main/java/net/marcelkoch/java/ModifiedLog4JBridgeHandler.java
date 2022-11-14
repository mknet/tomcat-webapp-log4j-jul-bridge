package net.marcelkoch.java;

import java.util.logging.LogRecord;
import org.apache.logging.log4j.jul.Log4jBridgeHandler;

public class ModifiedLog4JBridgeHandler extends Log4jBridgeHandler {
  private boolean installAsLevelPropagator = false;

  boolean debugOutput;
  String suffixToAppend;


  public ModifiedLog4JBridgeHandler() {
    super();
  }

  public ModifiedLog4JBridgeHandler(boolean debugOutput, String suffixToAppend, boolean propagateLevels) {
    init(debugOutput, suffixToAppend, propagateLevels);
    this.debugOutput = debugOutput;
    this.suffixToAppend = suffixToAppend;
  }

  protected void init(boolean debugOutput, String suffixToAppend, boolean propagateLevels) {
    super.init(debugOutput, suffixToAppend, false);
    this.installAsLevelPropagator = propagateLevels;
  }

  @Override
  public void publish(LogRecord record) {
    if (this.installAsLevelPropagator) {
      // propagate the log levels after the handlers have been registered
      super.init(debugOutput, suffixToAppend, true);
      this.installAsLevelPropagator = false;
    }

    super.publish(record);
  }
}
