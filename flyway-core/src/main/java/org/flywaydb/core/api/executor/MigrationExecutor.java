/*-
 * ========================LICENSE_START=================================
 * flyway-core
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
package org.flywaydb.core.api.executor;

import java.sql.SQLException;
import java.util.List;
import org.flywaydb.core.internal.jdbc.Results;

/**
 * Executes a migration.
 */
public interface MigrationExecutor {
    /**
     * Executes the migration this executor is associated with.
     *
     * @param context The context to use to execute the migration against the DB.
     * @throws SQLException when the execution of a statement failed.
     */
    List<Results> execute(Context context) throws SQLException;

    /**
     * Whether the execution can take place inside a transaction. Almost all implementation should return {@code true}.
     * This however makes it possible to execute certain migrations outside a transaction. This is useful for databases
     * like PostgreSQL and SQL Server where certain statement can only execute outside a transaction.
     *
     * @return {@code true} if a transaction should be used (highly recommended), or {@code false} if not.
     */
    boolean canExecuteInTransaction();

    /**
     * Whether the migration associated with this executor should be executed or not.
     *
     * @return {@code true} if the migration should be executed, or {@code false} if not.
     */
    boolean shouldExecute();

    /**
     *  Optionally, an executor may provide an expression string describing the conditions under which {@code shouldExecute}
     *  may return {@code true}. The {@code shouldExecute} function itself is the source of truth for whether a script
     *  may execute, this function is provided for providing additional information rather than direct evaluation.
     *
     * @return A string expression for the shouldExecute function, or {@code null}
     */
    default String shouldExecuteExpression() { return null; }
}
