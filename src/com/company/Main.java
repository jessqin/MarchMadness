package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        String csvFile = "TourneyCompactResults.csv";
        //BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)));
        Scanner keyIn = new Scanner(new File(csvFile));


        int maxIndx = -1;
        ArrayList stats = new ArrayList();
        String [] sStats = new String[3000];
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
        String teamID = "";
        String names [] = new String[365];
        String college = "";
        String ids[] = new String[365];
        int id = 1100;
        //String [] listTeams = new String[364];

//           id = id + 1;
//           teamID = Integer.toString(id);
//          listTeams[n] = teamID;
        for (int counter = 0; counter < 364; counter++)
        {
            String team_ID_Name = nameID[counter + 1];
            String [] IDNameOpt = team_ID_Name.split(",");
            names[counter] = IDNameOpt[1];
            ids [counter] = IDNameOpt[0];

        }


        for (int k = 0; k < maxIndxTeams; k++)
        {
            for (int i = 0; i < maxIndx ; i++)
            {
                String line = sStats[i + 1];
                String [] lineItem = line.split(",");
                String wteam = lineItem[2];
                String lTeam = lineItem[4];

                if (wteam.equalsIgnoreCase(ids[k]))
                {
                    wins++;
                }
                else if (lTeam.equalsIgnoreCase(ids[k]))
                {
                    losses++;
                }

            }

            for (int j = 0; j < maxIndxTeams; j++)
            {
                if (ids[k].equalsIgnoreCase(ids[j]))
                {
                    college = names[j];
                }
            }

            Team t = new Team(ids[k],college, wins,losses);
            stats.add(t);
        }

        for (int b = 0; b < stats.size(); b++)
        {

        }

        keyIn.close();
        //System.out.println(stats);

    }
}
