package nanometer.covid19.nanometercovid19.entity;


public class CsseCovid19AllReportsDailyUpdate {

  private long id;
  private String provinceState;
  private String countryRegion;
  private String lastUpdate;
  private long confirmed;
  private long deaths;
  private long recovered;
  private long active;
  private String combinedKey;
  private double incidentRate;
  private double caseFatalityRatio;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getProvinceState() {
    return provinceState;
  }

  public void setProvinceState(String provinceState) {
    this.provinceState = provinceState;
  }


  public String getCountryRegion() {
    return countryRegion;
  }

  public void setCountryRegion(String countryRegion) {
    this.countryRegion = countryRegion;
  }


  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }


  public long getConfirmed() {
    return confirmed;
  }

  public void setConfirmed(long confirmed) {
    this.confirmed = confirmed;
  }


  public long getDeaths() {
    return deaths;
  }

  public void setDeaths(long deaths) {
    this.deaths = deaths;
  }


  public long getRecovered() {
    return recovered;
  }

  public void setRecovered(long recovered) {
    this.recovered = recovered;
  }


  public long getActive() {
    return active;
  }

  public void setActive(long active) {
    this.active = active;
  }


  public String getCombinedKey() {
    return combinedKey;
  }

  public void setCombinedKey(String combinedKey) {
    this.combinedKey = combinedKey;
  }


  public double getIncidentRate() {
    return incidentRate;
  }

  public void setIncidentRate(double incidentRate) {
    this.incidentRate = incidentRate;
  }


  public double getCaseFatalityRatio() {
    return caseFatalityRatio;
  }

  public void setCaseFatalityRatio(double caseFatalityRatio) {
    this.caseFatalityRatio = caseFatalityRatio;
  }

}
