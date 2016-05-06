package id.arieridwan.kafedoo.model;

public class DetailModel {

    private boolean STATUS;
    private int STATUSCODE;
    private id.arieridwan.kafedoo.model.MESSAGE MESSAGE;
    private id.arieridwan.kafedoo.model.DetailDATA DATA;

    /**
     *
     * @return
     * The STATUS
     */
    public boolean isSTATUS() {
        return STATUS;
    }

    /**
     *
     * @param STATUS
     * The STATUS
     */
    public void setSTATUS(boolean STATUS) {
        this.STATUS = STATUS;
    }

    /**
     *
     * @return
     * The STATUSCODE
     */
    public int getSTATUSCODE() {
        return STATUSCODE;
    }

    /**
     *
     * @param STATUSCODE
     * The STATUS_CODE
     */
    public void setSTATUSCODE(int STATUSCODE) {
        this.STATUSCODE = STATUSCODE;
    }

    /**
     *
     * @return
     * The MESSAGE
     */
    public id.arieridwan.kafedoo.model.MESSAGE getMESSAGE() {
        return MESSAGE;
    }

    /**
     *
     * @param MESSAGE
     * The MESSAGE
     */
    public void setMESSAGE(id.arieridwan.kafedoo.model.MESSAGE MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    /**
     *
     * @return
     * The DATA
     */
    public id.arieridwan.kafedoo.model.DetailDATA getDATA() {
        return DATA;
    }

    /**
     *
     * @param DATA
     * The DATA
     */
    public void setDATA(id.arieridwan.kafedoo.model.DetailDATA DATA) {
        this.DATA = DATA;
    }

}
