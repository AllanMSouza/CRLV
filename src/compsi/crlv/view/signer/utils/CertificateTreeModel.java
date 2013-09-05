/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author ettore
 */
public class CertificateTreeModel extends DefaultTreeModel {

    public CertificateTreeModel(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }

    public CertificateTreeModel(TreeNode root) {
        super(root);
    }

}
