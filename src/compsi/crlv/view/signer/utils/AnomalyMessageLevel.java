/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compsi.crlv.view.signer.utils;

import compsi.icpbrasil.cert.utils.CertificateAnomaly;
import compsi.icpbrasil.cms.utils.SignatureAnomaly;
import compsi.icpbrasil.cms.utils.SignedDataAnomaly;

/**
 *
 * @author ettore
 */
public class AnomalyMessageLevel implements MessageLevel {

    int level;
    String message;

    public AnomalyMessageLevel(CertificateAnomaly anomaly) {
        level = anomaly.getLevel();
        message = anomaly.getMessage();
    }

    public AnomalyMessageLevel(SignedDataAnomaly anomaly) {
        level = anomaly.getLevel();
        message = anomaly.getMessage();
    }

    public AnomalyMessageLevel(SignatureAnomaly anomaly) {
        this.level = anomaly.getLevel();
        this.message = anomaly.getMessage();
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
