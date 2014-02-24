package com.github.xordash.twitchplaysclone.irc;

import com.github.xordash.twitchplaysclone.gba.GbaKeyEnum;
import com.github.xordash.twitchplaysclone.gba.VisualBoyAdvanceHandler;

/**
 * @author xor-
 */
public class IrcToGBAThread implements Runnable  {
    private GbaKeyEnum key;
    private VisualBoyAdvanceHandler vba;

    /**
     * Initialises variables needed to send the command to the VisualBoyAdvance emulator
     * @param key Key to send on
     * @param vba vba handler to send to
     */
    public IrcToGBAThread(GbaKeyEnum key, VisualBoyAdvanceHandler vba) {
        this.key = key;
        this.vba = vba;
    }

    /**
     * Sends the key to the VisualBoyAdvanceHandler
     */
    @Override
    public void run() {
        vba.sendKey(key);
    }
}
