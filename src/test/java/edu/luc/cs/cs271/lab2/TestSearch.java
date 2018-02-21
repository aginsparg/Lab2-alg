package edu.luc.cs.cs271.lab2;

import org.junit.Test;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TestSearch {

  Team[] makeArrayFixture(final int size) {
    final Team[] array = new Team[size];
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      array[i] = new Team("Team " + s, "Coach " + s, i * 100 + 50);
    }
    return array;
  }

 List<Team> makeListFixture(final int size) {
   final List<Team> list = new ArrayList<>();
   for (int i = 0; i < size; i++) {
     final String s = Integer.toString(i);
     list.add(new Team("Team " + s, "Coach " + s, i * 100 + 50));
   }
   return list;
 }

  @Test
  public void testFindPositionArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10s() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10f() {
    final Team[] arr = makeArrayFixture(10);
    assertFalse(Search.findTeamPosition(arr, "Team 11").isPresent());
  }

  @Test
  public void testFindPositionList() {
    final List<Team> list= makeListFixture(0);
    assertFalse(Search.findTeamPosition(list, "Team 3").isPresent());
  }


  @Test
  public void testFindPositionListII() {
    final List<Team> list= makeListFixture(10);
    assertFalse(Search.findTeamPosition(list, "Team 13").isPresent());
  }


  @Test
  public void testFindPositionListIII() {
    final List<Team> list= makeListFixture(10);
    assertTrue(Search.findTeamPosition(list,"Team 6").isPresent());
    }

  @Test
    public void testFindMinFundingArrayI()
  {
      final Team[] arr = makeArrayFixture(10);
      assertEquals(Optional.of(4), Search.findTeamMinFunding(arr, 350));
  }

  // TODO: testFindMinFundingArray for several sizes and scenarios

  // TODO: testFindMinFundingArrayFast for several sizes and scenarios
}
