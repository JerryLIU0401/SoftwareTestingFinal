package org.example;

public class Player {
  private double points;
  private double orb; // offensive rebounds
  private double drb; // defensive rebounds
  private double assists;
  private double blocks; // 火鍋
  private double steals; // 抄截
  private double turnovers; // 失誤
  private double tpa; // 3-pointer attempts
  private double tpm; // 3-pointer made
  private double fga; // field goal attempts
  private double fgm; // field goal made
  private double fta; // free throw attempts
  private double ftm; // free throw made

  public Player(double points, double orb, double drb, double assists,
                double blocks, double steals, double turnovers,
                double tpa, double tpm, double fga, double fgm, double fta, double ftm) {
    this.points = points;
    this.orb = orb;
    this.drb = drb;
    this.assists = assists;
    this.blocks = blocks;
    this.steals = steals;
    this.turnovers = turnovers;
    this.tpa = tpa;
    this.tpm = tpm;
    this.fga = fga;
    this.fgm = fgm;
    this.fta = fta;
    this.ftm = ftm;
  }

  // ft
  public Player(){

  }

  public void setFta(double fta) {
    this.fta = fta;
  }

  public void setFtm(double ftm) {
    this.ftm = ftm;
  }

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
  public double tfg(){
    return tpa / tpm;
  }

  // efficiency
  public double eff(){
    return (points + drb + orb + assists + steals + blocks)
            - (fgm - fga) + (ftm - fta) + turnovers;
  }
}
