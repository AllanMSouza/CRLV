/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import java.io.File;

/**
 *
 * @author ettore
 */
public class CRLFileFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getName().endsWith(".crl");
    }

    @Override
    public String getDescription() {
        return "Lista de Certificados Revogados";
    }

}
