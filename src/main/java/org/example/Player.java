package org.example;

public class Player {
  private int id;
  private double points;
  private double orb; // offensive rebounds
  private double drb; // defensive rebounds
  private double assists;
  private double blocks; // 火鍋
  private double steals; // 抄截
  private double turnovers; // 失誤
  private double pf; // 犯規
  private double tpa; // 3-pointer attempts
  private double tpm; // 3-pointer made
  private double fga; // field goal attempts
  private double fgm; // field goal made
  private double fta; // free throw attempts
  private double ftm; // free throw made
  private int plusminus; // plus / minus

  public Player(int id) {
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

  public double getDrb() {
    return drb;
  }

  public void setDrb(double drb) {
    this.drb = drb;
  }

  public double getAssists() {
    return assists;
  }

  public void setAssists(double assists) {
    this.assists = assists;
  }

  public double getBlocks() {
    return blocks;
  }

  public void setBlocks(double blocks) {
    this.blocks = blocks;
  }

  public double getSteals() {
    return steals;
  }

  public void setSteals(double steals) {
    this.steals = steals;
  }

  public double getTurnovers() {
    return turnovers;
  }

  public void setTurnovers(double turnovers) {
    this.turnovers = turnovers;
  }

  public double getTpa() {
    return tpa;
  }

  public void setTpa(double tpa) {
    this.tpa = tpa;
  }

  public double getTpm() {
    return tpm;
  }

  public void setTpm(double tpm) {
    this.tpm = tpm;
  }

  public double getFga() {
    return fga;
  }

  public void setFga(double fga) {
    this.fga = fga;
  }

  public double getFgm() {
    return fgm;
  }

  public void setFgm(double fgm) {
    this.fgm = fgm;
  }

  public void setFta(double fta) {
    this.fta = fta;
  }

  public void setFtm(double ftm) {
    this.ftm = ftm;
  }

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
}
