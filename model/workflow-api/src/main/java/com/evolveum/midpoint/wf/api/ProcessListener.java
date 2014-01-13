/*
 * Copyright (c) 2010-2013 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.evolveum.midpoint.wf.api;

import com.evolveum.midpoint.schema.result.OperationResult;

import java.util.Map;

/**
 * An interface through which external observers can be notified about wf process related events.
 *
 * EXPERIMENTAL. This interface will probably change in near future.
 *
 * @author mederly
 */
public interface ProcessListener {

    /**
     * This method is called by wf module when a process instance successfully starts.
     *
     * @param instanceName name of the process instance that was started
     * @param variables process instance variables (todo fixme this is quite a hack because implementor needs to know internal structure of these variables)
     * @param result implementor should report its result here
     */
    void onProcessInstanceStart(String instanceName, Map<String, Object> variables, OperationResult result);

    /**
     * This method is called by wf module when a process instance ends.
     *
     * @param instanceName name of the process instance that was finished
     * @param variables process instance variables (todo fixme this is quite a hack because implementor needs to know internal structure of these variables)
     * @param decision the final decision (the value of WF_ANSWER process variable, which may or may not be present)
     * @param result implementor should report its result here
     */
    void onProcessInstanceEnd(String instanceName, Map<String, Object> variables, String decision, OperationResult result);
}
