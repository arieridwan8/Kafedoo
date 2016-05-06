package id.arieridwan.kafedoo.model;

import java.util.ArrayList;
import java.util.List;

public class DetailDATA {

    private String nama;
    private Location location;
    private String alamat;
    private String deskripsi;
    private List<DetailFasilitas> fasilitas = new ArrayList<DetailFasilitas>();

    /**
     *
     * @return
     * The nama
     */
    public String getNama() {
        return nama;
    }

    /**
     *
     * @param nama
     * The nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     *
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     *
     * @param alamat
     * The alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     *
     * @return
     * The deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     *
     * @param deskripsi
     * The deskripsi
     */
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    /**
     *
     * @return
     * The fasilitas
     */
    public List<DetailFasilitas> getFasilitas() {
        return fasilitas;
    }

    /**
     *
     * @param fasilitas
     * The fasilitas
     */
    public void setFasilitas(List<DetailFasilitas> fasilitas) {
        this.fasilitas = fasilitas;
    }

}
