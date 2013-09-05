/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author ettore
 */
public class MessageLevelRenderer implements ListCellRenderer<MessageLevel>{

    Icon errorIcon;
    Icon alertIcon;
    Icon sucessIcon;

    Color errorColor[];
    Color alertColor[];
    Color sucessColor[];

    ListCellRenderer<Object>  cellRenderer;

    public MessageLevelRenderer(){
        this.errorIcon = IconLoader.getErrorIcon(16);
        this.alertIcon = IconLoader.getAlertIcon(16);
        this.sucessIcon = IconLoader.getSucessIcon(16);
        errorColor = new Color[2];
        alertColor = new Color[2];
        sucessColor = new Color[2];
        errorColor[0] = new Color(255,138,138);
        errorColor[1] = new Color(255,192,192);
        alertColor[0] = new Color(255,255,138);
        alertColor[1] = new Color(255,255,172);
        sucessColor[0] = new Color(148,255,148);
        sucessColor[1] = new Color(192,255,192);

        cellRenderer = new JList<>().getCellRenderer();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends MessageLevel> jlist, MessageLevel e, int i, boolean isSelected, boolean hasFocus) {
        //JLabel label = new JLabel(e.getMessage());
        JLabel label = (JLabel) cellRenderer.getListCellRendererComponent(jlist, e.getMessage(), i, hasFocus, hasFocus);
       // label.setOpaque(true);
        switch(e.getLevel()){
            case 0:
                label.setIcon(this.sucessIcon);
                //label.setBackground(this.sucessColor[i&0x1]);
                //label.setForeground(Color.BLACK);
                break;
            case 1:
                label.setIcon(this.alertIcon);
                //label.setBackground(this.alertColor[i&0x01]);
                //label.setForeground(Color.BLACK);
                break;
            case 2:
                label.setIcon(this.errorIcon);
                //label.setBackground(this.errorColor[i&0x1]);
                //label.setForeground(Color.BLACK);
                break;
            default:
//                label.setBackground(Color.WHITE);
//                label.setForeground(Color.BLACK);
        }
        if(isSelected){
//            label.setBackground(label.getBackground().darker());
        }
        return label;
    }
}
