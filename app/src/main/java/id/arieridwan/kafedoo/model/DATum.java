
package id.arieridwan.kafedoo.model;


import android.os.Parcel;
import android.os.Parcelable;

public class DATum implements Parcelable {

    private String id;
    private String rating;
    private String nama;
    private String jenis;
    private String alamat;
    private String url_foto;
    private Location location;

    public DATum() {

    }

    protected DATum(Parcel in) {
        id = in.readString();
        url_foto = in.readString();
        nama = in.readString();
        alamat = in.readString();
    }

    public static final Creator<DATum> CREATOR = new Creator<DATum>() {
        @Override
        public DATum createFromParcel(Parcel in) {
            return new DATum(in);
        }

        @Override
        public DATum[] newArray(int size) {
            return new DATum[size];
        }
    };

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * 
     * @param nama
     *     The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * 
     * @return
     *     The jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * 
     * @param jenis
     *     The jenis
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * 
     * @return
     *     The alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * 
     * @param alamat
     *     The alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(url_foto);
        parcel.writeString(nama);
        parcel.writeString(alamat);
    }
}
