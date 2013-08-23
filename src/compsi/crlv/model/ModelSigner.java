/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.model;

import compsi.icpbrasil.ICPBrasilSigner;
import compsi.icpbrasil.command.SignType;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import compsi.crlv.controller.signer.SignOption;

/**
 *
 * @author ettore
 */
public class ModelSigner {

    public ModelSigner() {
        this.signType = SignType.ADRB1V0;
        this.signOption = SignOption.FirstSignature;
    }
    private List<File> toSign = org.jdesktop.observablecollections.ObservableCollections.observableList(new LinkedList<File>());
    public static final String PROP_TOSIGN = "toSign";

    public List<File> getToSign() {
        return this.toSign;
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    private List<ICPBrasilSigner> signers = org.jdesktop.observablecollections.ObservableCollections.observableList(new LinkedList<ICPBrasilSigner>());
    public static final String PROP_SIGNERS = "signers";

    public List<ICPBrasilSigner> getSigners() {
        return this.signers;
    }
    private SignType signType;
    public static final String PROP_SIGNTYPE = "signType";

    public SignType getSignType() {
        return signType;
    }

    public void setSignType(SignType signType) {
        SignType oldSignType = this.signType;
        this.signType = signType;
        propertyChangeSupport.firePropertyChange(PROP_SIGNTYPE, oldSignType, signType);
    }
    private SignOption signOption;
    public static final String PROP_SIGNOPTION = "signOption";

    public SignOption getSignOption() {
        return signOption;
    }

    public void setSignOption(SignOption signOption) {
        SignOption oldSignOption = this.signOption;
        this.signOption = signOption;
        propertyChangeSupport.firePropertyChange(PROP_SIGNOPTION, oldSignOption, signOption);
    }
}
