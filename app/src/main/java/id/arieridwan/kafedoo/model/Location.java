
package id.arieridwan.kafedoo.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private List<String> latitude = new ArrayList<String>();
    private List<String> longitude = new ArrayList<String>();

    /**
     * 
     * @return
     *     The latitude
     */
    public List<String> getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(List<String> latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public List<String> getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(List<String> longitude) {
        this.longitude = longitude;
    }

}
