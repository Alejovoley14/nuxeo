/*
 * (C) Copyright 2006-2011 Nuxeo SA (http://nuxeo.com/) and others.
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
 *
 * Contributors:
 *     bstefanescu
 */
package org.nuxeo.ecm.automation.core.test;

import org.nuxeo.ecm.automation.OperationContext;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.core.annotations.Param;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentRef;

/**
 * @author <a href="mailto:bs@nuxeo.com">Bogdan Stefanescu</a>
 */
@Operation(id = "o2")
public class Operation2 {

    @Param(name = "message", required = false)
    protected String message = "default message";

    @Context
    OperationContext ctx;

    @Context
    CoreSession session;

    @OperationMethod
    public DocumentModel printInfo1(DocumentModel doc) throws Exception {
        // System.out.println("O2:doc:doc: "+doc.getId()+". Session:
        // "+session+". message: "+message);
        Helper.updateContext(ctx, "O2:doc:doc", message, doc.getTitle());
        return doc;
    }

    @OperationMethod(priority = 1)
    public DocumentRef printInfo2(DocumentModel doc) throws Exception {
        // System.out.println("O2:doc:ref: "+doc.getId()+". Session:
        // "+session+". message: "+message);
        Helper.updateContext(ctx, "O2:doc:ref", message, doc.getTitle());
        return doc.getRef();
    }

}
