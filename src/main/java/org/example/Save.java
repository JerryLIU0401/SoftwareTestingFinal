package org.example;

public interface Save {
  public static void setData(String team, int n, PlayerData playerData) {
    if (team.equals("A")) {
      for (PlayerData p : Mainpart.playerDataA) {
        if (p.getId() == n) {
          Mainpart.playerDataA.set(Mainpart.playerDataA.lastIndexOf(p), playerData);
          break;
        }
      }
    } else {
      for (PlayerData p : Mainpart.playerDataB) {
        if (p.getId() == n) {
          Mainpart.playerDataB.set(Mainpart.playerDataB.lastIndexOf(p), playerData);
          break;
        }
      }
    }
  }

  public static boolean searchTeamAData(PlayerData playerData) {
    for (PlayerData p : Mainpart.playerDataA) {
      if (p.getId() == playerData.getId()) {
        return true;
      }
    }
    return false;
  }
  public static boolean searchTeamBData(PlayerData playerData) {
    for (PlayerData p : Mainpart.playerDataB) {
      if (p.getId() == playerData.getId()) {
        return true;
      }
    }
    return false;
  }
}
