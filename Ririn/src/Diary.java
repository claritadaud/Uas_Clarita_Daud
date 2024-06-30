public class Diary {
    private String tanggal;
    private String catatan;

    public Diary(String tanggal, String catatan) {
        this.tanggal = tanggal;
        this.catatan = catatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }
}
