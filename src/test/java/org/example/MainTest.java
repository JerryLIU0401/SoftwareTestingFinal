package org.example;


import org.example.Login;
import org.example.Main;
//import org.example.MyJFrameTest;
import org.junit.jupiter.api.Test;

import static org.example.fit_player.*;

import static org.example.fit_start.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends Main {
  @Test
  public void testSetUsername() {
    Main.mainpart = new Mainpart();
    Main.login = new Login();
    Main.login.setVisible(true);
    start_setName("5adaw1da3caascascascascascasd1");
    start_setDate("5ss");
    start_setPlace("5adaw1da3caascascascascascasd1");
    start_setReferce("xx5");
    start_setUmpire("5xx");
    for(int i=0;i<6;i++){
      set_teamA(i);
      set_teamB(i);
    }

    start();
    player_A2();
    player_score(3,5,0,1);
    player_A2();
    player_score(3,5,1,1);
    player_A2();
    player_score(3,5,1,1);
    player_A2();
    player_score(2,1,0,1);
    player_A2();
    player_score(2,1,0,1);
    player_A2();
    player_score(2,1,0,1);
    player_A2();
    player_score(2,1,1,1);
    player_A2();
    player_score(2,1,1,1);
    player_A2();
    player_score(2,1,1,1);
    player_A2();
    player_mistake(1);
    player_A2();
    player_foul(1);
    player_A2();
    player_foul(1);
    player_A2();
    player_foul(1);
    player_A2();
    player_steal(1);
    player_A2();
    player_rebound(0,1);
    player_A2();
    player_rebound(0,1);
    player_A2();
    player_rebound(1,1);
    player_A2();
    player_rebound(1,1);
    player_A2();
    player_rebound(1,1);

    player_A1();
    player_score(2,5,1,1);
    player_A1();
    player_score(2,5,0,1);
    player_A1();
    player_score(2,1,0,1);
    player_A1();
    player_score(2,1,0,1);
    player_A1();
    player_score(2,1,0,1);
    player_A1();
    player_score(2,1,1,1);
    player_A1();
    player_score(2,1,1,1);
    player_A1();
    player_score(2,1,1,1);
    player_A1();
    player_rebound(0,1);
    player_A1();
    player_rebound(0,1);
    for(int i=0;i<17;i++) {
      if(i<3){
        player_A1();
        player_foul(1);
      }
      if(i<4){
        player_A1();
        player_steal(1);
      }
      if(i<5){
        player_A1();
        player_mistake(1);
      }
      player_A1();
      player_rebound(1, 1);
    }

    assertAll(
            () -> assertEquals(5,Main.mainpart.playerDataA.get(0).getTurnovers(), "Turnovers erroe"),
            () -> assertEquals(3,Main.mainpart.playerDataA.get(0).getPf(), "Pf erroe"),
            () ->  assertEquals(17,Main.mainpart.playerDataA.get(0).getDrb(), "Drb erroe"),
            () -> assertEquals(2,Main.mainpart.playerDataA.get(0).getOrb(), "Orb erroe")
    );

  }



}