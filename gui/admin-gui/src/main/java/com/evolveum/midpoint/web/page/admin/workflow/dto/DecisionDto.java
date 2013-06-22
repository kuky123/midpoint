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

package com.evolveum.midpoint.web.page.admin.workflow.dto;

import com.evolveum.midpoint.web.component.util.Selectable;
import com.evolveum.midpoint.wf.processes.general.Decision;

import java.io.Serializable;

/**
 * @author lazyman
 */
public class DecisionDto<I extends Serializable> extends Selectable {

    public static final String F_USER = "user";
    public static final String F_RESULT = "result";
    public static final String F_COMMENT = "comment";
    public static final String F_TIME = "time";

    private Decision<I> decision;

    public DecisionDto(Decision<I> decision) {
        this.decision = decision;
    }

    public Decision<I> getDecision() {
        return decision;
    }

    public String getUser() {
        return decision.getApproverName();
    }

    public String getResult() {
        return decision.isApproved() ? "APPROVED" : "REJECTED";     // todo i18n
    }

    public String getTime() {
        return decision.getDate().toLocaleString();      // todo formatting
    }

    public String getComment() {
        return decision.getComment();
    }
}
