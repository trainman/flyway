/*-
 * ========================LICENSE_START=================================
 * flyway-nc-core
 * ========================================================================
 * Copyright (C) 2010 - 2025 Red Gate Software Ltd
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package org.flywaydb.nc.executors;

import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.experimental.ConnectionType;
import org.flywaydb.core.experimental.ExperimentalDatabase;
import org.flywaydb.core.extensibility.Plugin;

public interface Executor<T> extends Plugin {

    void execute(ExperimentalDatabase experimentalDatabase, T executionUnit, Configuration configuration);

    boolean canExecute(ConnectionType connectionType);

    void appendErrorMessage(T executionUnit, StringBuilder messageBuilder, boolean isDebugEnabled);

    void finishExecution(ExperimentalDatabase experimentalDatabase, Configuration configuration);
}

