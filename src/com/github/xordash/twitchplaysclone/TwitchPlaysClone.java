package com.github.xordash.twitchplaysclone;

import com.github.xordash.twitchplaysclone.gba.VisualBoyAdvanceHandler;
import com.github.xordash.twitchplaysclone.irc.InternetRelayChatHandler;

/**
 * @author xor-
 */
public class TwitchPlaysClone {

    /**
     * Initialises and starts VisualBoyAdvanceHandler and InternetRelayChatHandler
     * @param args args
     * @throws Exception
     */
    public static void main (String... args)throws Exception{
        VisualBoyAdvanceHandler vbaHandler = new VisualBoyAdvanceHandler();
        vbaHandler.start();
        InternetRelayChatHandler ircHandler = new InternetRelayChatHandler(vbaHandler);
        ircHandler.connect();
    }
}
