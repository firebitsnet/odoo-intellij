/*
 * Copyright 2017 The Chromium Authors. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package net.firebits.odoo.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.GenericProgramRunner;
import com.intellij.execution.ui.RunContentDescriptor;
import com.jetbrains.python.run.PythonRunner;
import org.jetbrains.annotations.NotNull;

public class OdooRunner extends PythonRunner {

  @NotNull
  @Override
  public String getRunnerId() {
    return "OdooRunner";
  }

  @Override
  public boolean canRun(@NotNull String s, @NotNull RunProfile runProfile) {


    return false;
  }

}
