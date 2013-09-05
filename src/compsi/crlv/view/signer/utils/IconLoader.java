/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import javax.swing.ImageIcon;

/**
 *
 * @author ettore
 */
public class IconLoader {

    private static final String iconFolder = "org/lsitec/signer/view/icons/";

    public static ImageIcon getErrorIcon() {
        return getIcon("error.png");
    }

    public static ImageIcon getErrorIcon(int size) {
        return getIcon("error.png", size);
    }

    public static ImageIcon getAlertIcon() {
        return getIcon("alert.png");
    }

    public static ImageIcon getAlertIcon(int size) {
        return getIcon("alert.png", size);
    }

    public static ImageIcon getSucessIcon() {
        return getIcon("sucess.png");
    }

    public static ImageIcon getSucessIcon(int size) {
        return getIcon("sucess.png", size);
    }

    public static ImageIcon getCertificateIcon() {
        return IconLoader.getIcon("cert.png");
    }

    public static ImageIcon getCertificateIcon(int size) {
        return IconLoader.getIcon("cert.png", size);
    }

    public static ImageIcon getKeyIcon() {
        return IconLoader.getIcon("key.png");
    }

    public static ImageIcon getKeyIcon(int size) {
        return IconLoader.getIcon("key.png", size);
    }

    public static ImageIcon getSmartCardIcon() {
        return IconLoader.getIcon("smartcard.png");
    }

    public static ImageIcon getSmartCardIcon(int size) {
        return IconLoader.getIcon("smartcard.png", size);
    }

    public static ImageIcon getAnchorIcon() {
        return IconLoader.getIcon("anchor.png");
    }

    public static ImageIcon getAnchorIcon(int size) {
        return IconLoader.getIcon("anchor.png", size);
    }

    public static ImageIcon getClockIcon() {
        return IconLoader.getIcon("clock.png");
    }

    public static ImageIcon getClockIcon(int size) {
        return IconLoader.getIcon("clock.png", size);
    }

    protected static ImageIcon getIcon(String name) {
        return new ImageIcon(ClassLoader.getSystemClassLoader().getResource(iconFolder + name));
    }

    protected static ImageIcon getIcon(String name, int size) {
        return new ImageIcon(ClassLoader.getSystemClassLoader().getResource(iconFolder + size + "x" + size + "/" + name));
    }
}
