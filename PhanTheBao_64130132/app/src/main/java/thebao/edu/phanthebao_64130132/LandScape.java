package thebao.edu.phanthebao_64130132;

public class LandScape {
    int landImageFileName;
    String landCation;
    String Thongtin;

    public LandScape(int landImageFileName, String landCation , String Thongtin) {
        this.landImageFileName = landImageFileName;
        this.landCation = landCation;
        this.Thongtin = Thongtin;

    }
    public int getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(int landImageFileName) {
        this.landImageFileName = landImageFileName;
    }

    public String getLandCation() {
        return landCation;
    }

    public void setLandCation(String landCation) {
        this.landCation = landCation;
    }

    public LandScape(String thongtin) {
        this.Thongtin = thongtin;
    }

    public String getThongtin() {
        return Thongtin;
    }

    public void setThongtin(String thongtin) {
        Thongtin = thongtin;
    }
}
