/*
 * Copyright (c) 2016 Evolveum
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
package com.evolveum.midpoint.web.component.objectdetails;

import com.evolveum.midpoint.gui.api.model.LoadableModel;
import com.evolveum.midpoint.gui.api.page.PageBase;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.prism.query.ObjectQuery;
import com.evolveum.midpoint.schema.result.OperationResult;
import com.evolveum.midpoint.task.api.Task;
import com.evolveum.midpoint.util.exception.*;
import com.evolveum.midpoint.util.logging.LoggingUtils;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;
import com.evolveum.midpoint.web.component.assignment.*;
import com.evolveum.midpoint.web.component.data.ObjectDataProvider;
import com.evolveum.midpoint.web.component.form.Form;
import com.evolveum.midpoint.web.component.prism.ObjectWrapper;
import com.evolveum.midpoint.web.component.util.ListDataProvider;
import com.evolveum.midpoint.web.component.util.SelectableBean;
import com.evolveum.midpoint.web.page.admin.home.dto.MyPasswordsDto;
import com.evolveum.midpoint.web.page.admin.users.dto.UserDtoStatus;
import com.evolveum.midpoint.web.security.SecurityUtils;
import com.evolveum.midpoint.xml.ns._public.common.common_3.*;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.ISortState;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.model.IModel;
import org.springframework.expression.spel.ast.Assign;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kate Honchar
 */
public class RequestAssignmentTabPanel<F extends FocusType> extends AbstractObjectTabPanel<F> {
    private static final long serialVersionUID = 1L;

    private static final String DOT_CLASS = RequestAssignmentTabPanel.class.getName();
    private static final Trace LOGGER = TraceManager.getTrace(RequestAssignmentTabPanel.class);
    private static final String ID_MAIN_PANEL = "mainPanel";

    private LoadableModel<List<AssignmentEditorDto>> assignmentsModel;

    public RequestAssignmentTabPanel(String id, Form mainForm, LoadableModel<ObjectWrapper<F>> focusWrapperModel,
                                    LoadableModel<List<AssignmentEditorDto>> assignmentsModel, PageBase page) {
        super(id, mainForm, focusWrapperModel, page);
        this.assignmentsModel = assignmentsModel;
        initLayout(focusWrapperModel);
    }

    private void initLayout(LoadableModel<ObjectWrapper<F>> focusWrapperModel) {
    	Class targetFocusClass = getObjectWrapper().getObject().getCompileTimeClass();
        MultipleAssignmentSelectorPanel<F, UserType, RoleType> panel = new MultipleAssignmentSelectorPanel<F, UserType, RoleType>(ID_MAIN_PANEL,
                assignmentsModel, focusWrapperModel.getObject().getObject(), targetFocusClass, RoleType.class);
        add(panel);
    }

}