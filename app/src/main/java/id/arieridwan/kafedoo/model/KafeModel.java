
package id.arieridwan.kafedoo.model;

import java.util.ArrayList;
import java.util.List;



public class KafeModel {

    private boolean STATUS;
    private int STATUSCODE;
    private id.arieridwan.kafedoo.model.MESSAGE MESSAGE;
    private List<DATum> DATA = new ArrayList<DATum>();

    /**
     * 
     * @return
     *     The STATUS
     */
    public boolean isSTATUS() {
        return STATUS;
    }

    /**
     * 
     * @param STATUS
     *     The STATUS
     */
    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    /**
     * 
     * @return
     *     The STATUSCODE
     */
    public int getSTATUSCODE() {
        return STATUSCODE;
    }

    /**
     * 
     * @param STATUSCODE
     *     The STATUS_CODE
     */
    public void setSTATUSCODE(int STATUSCODE) {
        this.STATUSCODE = STATUSCODE;
    }

    /**
     * 
     * @return
     *     The MESSAGE
     */
    public id.arieridwan.kafedoo.model.MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    /**
     * 
     * @param MESSAGE
     *     The MESSAGE
     */
    public void setMESSAGE(id.arieridwan.kafedoo.model.MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    /**
     * 
     * @return
     *     The DATA
     */
    public List<DATum> getDATA() {
        return DATA;
    }

    /**
     * 
     * @param DATA
     *     The DATA
     */
    public void setDATA(List<DATum> DATA) {
        this.DATA = DATA;
    }

    public static class KafeResult {
        private List<DATum> results;

        public List<DATum> getResults() {
            return results;
        }
    }

}
