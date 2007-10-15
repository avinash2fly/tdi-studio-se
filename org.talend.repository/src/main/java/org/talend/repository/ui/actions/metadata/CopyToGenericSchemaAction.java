// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006-2007 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.repository.ui.actions.metadata;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.image.EImage;
import org.talend.commons.ui.image.ImageProvider;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.ProxyRepositoryFactory;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNode.EProperties;
import org.talend.repository.ui.actions.AContextualAction;

/**
 * Administrator class global comment. Detailed comment <br/>
 * 
 */
public class CopyToGenericSchemaAction extends AContextualAction {

    protected static final String LABEL = "Copy to Generic schema"; //$NON-NLS-1$

    private boolean isAllowedRepositoryElement = false;

    private RepositoryNode sourceNode;

    private TreeViewer viewer;

    public CopyToGenericSchemaAction() {
        super();
        this.setText(LABEL);
        this.setToolTipText(LABEL);
        this.setImageDescriptor(ImageProvider.getImageDesc(EImage.COPY_ICON));
    }

    public void init(final TreeViewer viewer, final IStructuredSelection selection) {
        this.viewer = viewer;
        setEnabled(false);
        Object o = selection.getFirstElement();
        if (selection.isEmpty() || selection.size() != 1 || o == null || !(o instanceof RepositoryNode)) {
            return;
        }
        init((RepositoryNode) o);
        if (ProxyRepositoryFactory.getInstance().isUserReadOnlyOnCurrentProject()) {
            // setEnabled(false);
        }
    }

    /**
     * Administrator Comment method "init".
     * 
     * @param node
     */
    protected void init(RepositoryNode node) {
        ERepositoryObjectType nodeType = (ERepositoryObjectType) node.getProperties(EProperties.CONTENT_TYPE);

        if (nodeType == null) {
            return;
        }

        switch (nodeType) {
        case METADATA_CON_TABLE:
        case METADATA_CON_VIEW:
        case METADATA_CON_SYNONYM:
        case METADATA_FILE_DELIMITED:
        case METADATA_FILE_POSITIONAL:
        case METADATA_FILE_REGEXP:
        case METADATA_FILE_XML:
        case METADATA_LDAP_SCHEMA:
        case METADATA_FILE_LDIF:
            break;
        default:
            return;
        }

        switch (node.getType()) {
        case REPOSITORY_ELEMENT:
            isAllowedRepositoryElement = true;
            this.sourceNode = node;
            break;
        default:
            return;
        }
        setEnabled(true);
    }

    @Override
    public void run() {
        if (isAllowedRepositoryElement) {
            IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
            try {
                CopyToGenericSchemaHelper.copyToGenericSchema(factory, this.sourceNode.getObject());
                refresh();
            } catch (PersistenceException e) {
                e.printStackTrace();
            }
        }
    }
}
