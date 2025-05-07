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

import org.flywaydb.core.api.FlywayException;
import org.flywaydb.core.api.configuration.Configuration;
import org.flywaydb.core.experimental.ConnectionType;
import org.flywaydb.core.experimental.ExperimentalDatabase;

public class ExecutorFactory {
    public static <T> Executor<T> getExecutor(final ExperimentalDatabase experimentalDatabase,
        final Configuration configuration) {
        final ConnectionType connectionType = experimentalDatabase.getDatabaseMetaData().connectionType();
        return configuration.getPluginRegister()
            .getLicensedPlugins(Executor.class, configuration)
            .stream()
            .filter(x -> x.canExecute(connectionType))
            .map(x -> (Executor<T>) x)
            .findFirst()
            .orElseThrow(() -> new FlywayException("No executor found for connection type: " + connectionType));
    }
}
