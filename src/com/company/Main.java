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
        String [] nameID = new String[364];

        while (keyInTeams.hasNextLine())
        {
            maxIndxTeams++;
            nameID[maxIndx] = keyInTeams.nextLine();
        }

        int wins = 0;
        int losses = 0;
        String name = "";
        int id = 1100;
        String [] listTeams = new String[364];

        for (int n = 0; n < 365 ; n++)
        {
            id = id + 1;
            name = Integer.toString(id);
            listTeams[n] = name;
        }
        for (int k = 0; k < 365; k++)
        {
            for (int i = 0; i < maxIndx ; i++)
            {
                String line = sStats[i + 1];
                String [] lineItem = line.split(",");
                String wteam = lineItem[2];
                String lTeam = lineItem[4];

                if (wteam.equalsIgnoreCase(listTeams[k]))
                {
                    wins++;
                }
                else if (lTeam.equalsIgnoreCase(listTeams[k]))
                {
                    losses++;
                }

            }

            Team t = new Team(listTeams[k],wins,losses);

            stats.add(t);
        }

        keyIn.close();
        //System.out.println(stats);

    }
}
