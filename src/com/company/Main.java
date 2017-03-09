package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        String csvFile = "TourneyCompactResults.csv";
        Scanner keyIn = new Scanner(new File(csvFile));


        int maxIndx = -1;
        ArrayList<Team> stats = new ArrayList();
        String [] sStats = new String[10000];
        while(keyIn.hasNextLine())
        {
            maxIndx++;

            sStats [maxIndx] = keyIn.nextLine();

        }

        Scanner keyInTeams = new Scanner(new File("Teams.csv"));

        int maxIndxTeams = -1;
        String [] nameID = new String[366];

        while (keyInTeams.hasNextLine())
        {
            maxIndxTeams++;
            nameID[maxIndxTeams] = keyInTeams.nextLine();
        }


        int wins = 0;
        int losses = 0;
        String names [] = new String[365];
        String college = "";
        String ids[] = new String[365];


        for (int counter = 0; counter < 364; counter++)
        {
            String team_ID_Name = nameID[counter + 1];
            String [] IDNameOpt = team_ID_Name.split(",");
            names[counter] = IDNameOpt[1];
            ids [counter] = IDNameOpt[0];

        }

        FileWriter fw = new FileWriter(new File("Win-Loss.txt"));
        PrintWriter pw = new PrintWriter("Win-Loss.txt");


        for (int k = 0; k < maxIndxTeams; k++)
        {
            for (int i = 0; i < maxIndx ; i++)
            {
                String line = sStats[i + 1];
                String [] lineItem = line.split(",");
                String wteam = lineItem[2];
                String lTeam = lineItem[4];

                if (ids[k].equalsIgnoreCase(wteam))
                {
                    wins++;
                }
                else if (ids[k].equalsIgnoreCase(lTeam))
                {
                    losses++;
                }

            }

            for (int j = 0; j < maxIndxTeams; j++)
            {
                if (ids[k].equalsIgnoreCase(ids[j]))
                {
                    college = names[j];
                    break;
                }
            }

            //Team t = new Team(college,ids[k], wins,losses);
            int win_loss = wins - losses;
            Team t = new Team(college, win_loss);
            stats.add(t);

        }


        for (int b = 0; b < stats.size(); b++)
        {
            int winLoss = stats.get(b).win_loss_ratio;
            String name = stats.get(b).name;
            pw.println(winLoss + " " + name);
        }


        pw.close();
        keyIn.close();
        //System.out.println(stats);

    }
}
