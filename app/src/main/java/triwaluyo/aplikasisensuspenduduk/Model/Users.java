package triwaluyo.aplikasisensuspenduduk.Model;

public class Users {
    private String id,idProv, idKota, idKecamatan, idKelurahan,
            idRW, idRT, idJmlKeluarga, idJlmPend,email;

    public Users()
    {

    }

    public Users(String id, String idProv, String idKota, String idKecamatan, String idKelurahan,
                 String idRW, String idRT, String idJmlKeluarga, String idJlmPend, String email) {
        this.id = id;
        this.idProv = idProv;
        this.idKota = idKota;
        this.idKecamatan = idKecamatan;
        this.idKelurahan = idKelurahan;
        this.idRW = idRW;
        this.idRT = idRT;
        this.idJmlKeluarga = idJmlKeluarga;
        this.idJlmPend = idJlmPend;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getIdKota() {
        return idKota;
    }

    public void setIdKota(String idKota) {
        this.idKota = idKota;
    }

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(String idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public String getIdRW() {
        return idRW;
    }

    public void setIdRW(String idRW) {
        this.idRW = idRW;
    }

    public String getIdRT() {
        return idRT;
    }

    public void setIdRT(String idRT) {
        this.idRT = idRT;
    }

    public String getIdJmlKeluarga() {
        return idJmlKeluarga;
    }

    public void setIdJmlKeluarga(String idJmlKeluarga) {
        this.idJmlKeluarga = idJmlKeluarga;
    }

    public String getIdJlmPend() {
        return idJlmPend;
    }

    public void setIdJlmPend(String idJlmPend) {
        this.idJlmPend = idJlmPend;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
