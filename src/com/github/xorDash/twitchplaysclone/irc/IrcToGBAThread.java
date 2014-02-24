package com.github.xorDash.twitchplaysclone.irc;

import com.github.xorDash.twitchplaysclone.gba.GbaKeyEnum;
import com.github.xorDash.twitchplaysclone.gba.VisualBoyAdvanceHandler;

/**
 * @author xor-
 */
public class IrcToGBAThread implements Runnable  {
    private GbaKeyEnum key;
    private VisualBoyAdvanceHandler vba;

    /**
     * Initialises variables needed to send the command to the VisualBoyAdvance emulator
     * @param key
     * @param vba
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
