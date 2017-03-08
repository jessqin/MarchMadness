package com.company;

/**
 * Created by jq210 on 3/1/17.
 */
public class Team
{
    private int wins;
    private int losses;
    public String name;
    public String ID;
    private int win_loss_ratio;

    public Team(String n, String i, int wTeam, int lTeam)
    {
        wins = wTeam;
        losses = lTeam;
        name = n;
        ID = i;
    }
    public String returnInfoTest()
    {
        String print = (name + " ID: " + ID + " Number of wins: " + wins + " Number of losses: " + losses);
        return print;
    }
    public int calculateWinLossRatio()
    {
        win_loss_ratio = wins - losses;
        return win_loss_ratio;
    }
    public boolean compareTeams(Team a, Team b)
    {
        boolean tf = a.win_loss_ratio >= b.win_loss_ratio;
        return tf;
    }

}
