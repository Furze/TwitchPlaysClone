package com.github.xordash.twitchplaysclone.gba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xor-
 */
public class VisualBoyAdvanceThread implements Runnable  {
    private static String GAME_FILE = "/home/troy/gba/MetroidFusion.gba";
    private static String VBA_ARGS = "-2";

    /**
     * run() starts the VisualBoyAdvance emulator in its own process
     * and redirects its standard output into the console
     */
    @Override
    public void run() {
        String[] command = {"vba",VBA_ARGS,GAME_FILE};
        try{
            Process vbaProcess = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(vbaProcess.getInputStream()));
            String line = "";
            while ((line = reader.readLine())!= null)
                System.out.println(line);

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
