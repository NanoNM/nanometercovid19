package covid.nanometer.top.entity;


public class TencentCityHisData {

  private long provinceId;
  private String cityName;
  private long confirm;
  private double healRate;
  private long wzz;
  private long heal;
  private long nowConfirm;
  private long todayConfirm;
  private long dead;
  private long deadRate;
  private long suspect;
  private String lastUpdateTime;


  public long getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(long provinceId) {
    this.provinceId = provinceId;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
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


  public long getTodayConfirm() {
    return todayConfirm;
  }

  public void setTodayConfirm(long todayConfirm) {
    this.todayConfirm = todayConfirm;
  }


  public long getDead() {
    return dead;
  }

  public void setDead(long dead) {
    this.dead = dead;
  }


  public long getDeadRate() {
    return deadRate;
  }

  public void setDeadRate(long deadRate) {
    this.deadRate = deadRate;
  }


  public long getSuspect() {
    return suspect;
  }

  public void setSuspect(long suspect) {
    this.suspect = suspect;
  }


  public String getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

}
