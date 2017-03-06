package com.company;

/**
 * Created by jq210 on 3/1/17.
 */
public class Team
{
    private int wins;
    private int losses;
    private String name;
    private String ID;

    public Team(String n, String i, int wTeam, int lTeam)
    {
        wins = wTeam;
        losses = lTeam;
        name = n;
        ID = i;
    }
    public String returnInfoTest()
    {
        String print = (name + "ID: " + ID + "Number of wins: " + wins + "Number of losses: " + losses);
        return print;
    }
}
