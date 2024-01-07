package org.example;

public class PlayerData {
  private int id;
  private double points = 0;
  private double orb = 0; // offensive rebounds
  private double drb = 0; // defensive rebounds
  private double assists = 0;
  private double blocks = 0; // 火鍋
  private double steals = 0; // 抄截
  private double turnovers = 0; // 失誤
  private double pf = 0; // 犯規
  private double tpa = 0; // 3-pointer attempts
  private double tpm = 0; // 3-pointer made
  private double fga = 0; // field goal attempts
  private double fgm = 0; // field goal made
  private double fta = 0; // free throw attempts
  private double ftm = 0; // free throw made
  private int plusminus = 0; // plus / minus

  public PlayerData(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPoints() {
    return points;
  }

  public void setPoints(double points) {
    this.points = points;
  }

  public double getOrb() {
    return orb;
  }

  public void setOrb(double orb) {
    this.orb = orb;
  }
  public void addOrb(){ this.orb++; }

  public double getDrb() {
    return drb;
  }

  public void setDrb(double drb) {
    this.drb = drb;
  }
  public void addDrb(){ this.drb++; }

  public double getAssists() {
    return assists;
  }

  public void setAssists(double assists) {
    this.assists = assists;
  }
  public void addAssists(){ this.assists++; }

  public double getBlocks() {
    return blocks;
  }

  public void setBlocks(double blocks) {
    this.blocks = blocks;
  }
  public void addBlocks(){ this.blocks++; }

  public double getSteals() {
    return steals;
  }

  public void setSteals(double steals) {
    this.steals = steals;
  }
  public void addSteals(){ this.steals++; }

  public double getTurnovers() {
    return turnovers;
  }

  public void setTurnovers(double turnovers) {
    this.turnovers = turnovers;
  }
  public void addTurnovers(){ this.turnovers++; }

  public double getTpa() {
    return tpa;
  }

  public void setTpa(double tpa) {
    this.tpa = tpa;
  }
  public void addTpa(){ this.tpa++; }

  public double getTpm() {
    return tpm;
  }

  public void setTpm(double tpm) {
    this.tpm = tpm;
  }
  public void addTpm(){ this.tpm++; }

  public double getFga() {
    return fga;
  }

  public void setFga(double fga) {
    this.fga = fga;
  }
  public void addFga(){ this.fga++; }

  public double getFgm() {
    return fgm;
  }

  public void setFgm(double fgm) {
    this.fgm = fgm;
  }
  public void addFgm(){ this.fgm++; }

  public void setFta(double fta) {
    this.fta = fta;
  }
  public void addFta(){ this.fta++; }

  public void setFtm(double ftm) {
    this.ftm = ftm;
  }
  public void addFtm(){ this.ftm++; }

  public double getFta() {
    return fta;
  }

  public double getFtm() {
    return ftm;
  }

  public double getPf() {
    return pf;
  }

  public void setPf(double pf) {
    this.pf = pf;
  }
  public void addPf(){ this.pf++; }

  // plus / minus
  public void setPlusminus(int score) {
    plusminus += score;
  }

  public int getPlusminus() {
    return plusminus;
  }

  /*
  -----------------
   After game data
  -----------------
*/

  // Effective Field-Goal Percentage
  public double eFG() {
    return (fgm + 0.5 * tpm) / fga;
  }

  // True Shooting Percentage
  public double ts() {
    return points / 2 * (fga + 0.44 * fta);
  }

  // Free throw percentage
  public double ft() {
    return fta / ftm;
  }

  // field goal percentage
  public double fg() {
    return fga / fgm;
  }

  // 3-points percentage
  public double tfg() {
    return tpa / tpm;
  }

  // efficiency
  public double eff() {
    return (points + drb + orb + assists + steals + blocks)
            - (fgm - fga) + (ftm - fta) + turnovers;
  }

  public double totalRb(){
    return orb + drb;
  }
}
