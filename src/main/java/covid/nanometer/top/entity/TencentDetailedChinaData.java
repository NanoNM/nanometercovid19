package covid.nanometer.top.entity;


public class TencentDetailedChinaData {

  private long id;
  private String province;
  private long confirm;
  private double healRate;
  private long wzz;
  private long heal;
  private long nowConfirm;
  private long dead;
  private long suspect;
  private double deadRate;
  private long todayConfirm;
  private long wzzAdd;
  private String lastUpdateTime;
  private TencentCityHisData[] tencentCityHisData;


  public TencentCityHisData[] getTencentCityHisData() {
    return tencentCityHisData;
  }

  public void setTencentCityHisData(TencentCityHisData[] tencentCityHisData) {
    this.tencentCityHisData = tencentCityHisData;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  public long getConfirm() {
    return confirm;
  }

  public void setConfirm(long confirm) {
    this.confirm = confirm;
  }


  public double getHealRate() {
    return healRate;
  }

  public void setHealRate(double healRate) {
    this.healRate = healRate;
  }


  public long getWzz() {
    return wzz;
  }

  public void setWzz(long wzz) {
    this.wzz = wzz;
  }


  public long getHeal() {
    return heal;
  }

  public void setHeal(long heal) {
    this.heal = heal;
  }


  public long getNowConfirm() {
    return nowConfirm;
  }

  public void setNowConfirm(long nowConfirm) {
    this.nowConfirm = nowConfirm;
  }


  public long getDead() {
    return dead;
  }

  public void setDead(long dead) {
    this.dead = dead;
  }


  public long getSuspect() {
    return suspect;
  }

  public void setSuspect(long suspect) {
    this.suspect = suspect;
  }


  public double getDeadRate() {
    return deadRate;
  }

  public void setDeadRate(double deadRate) {
    this.deadRate = deadRate;
  }


  public long getTodayConfirm() {
    return todayConfirm;
  }

  public void setTodayConfirm(long todayConfirm) {
    this.todayConfirm = todayConfirm;
  }


  public long getWzzAdd() {
    return wzzAdd;
  }

  public void setWzzAdd(long wzzAdd) {
    this.wzzAdd = wzzAdd;
  }


  public String getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

}
