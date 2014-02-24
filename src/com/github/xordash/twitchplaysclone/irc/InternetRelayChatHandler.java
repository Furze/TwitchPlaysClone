package com.github.xordash.twitchplaysclone.irc;

import com.github.xordash.twitchplaysclone.gba.GbaKeyEnum;
import com.github.xordash.twitchplaysclone.gba.VisualBoyAdvanceHandler;
import jerklib.ConnectionManager;
import jerklib.Profile;
import jerklib.Session;
import jerklib.events.ChannelMsgEvent;
import jerklib.events.IRCEvent;
import jerklib.events.IRCEvent.Type;
import jerklib.events.listeners.IRCEventListener;


/**
 * @author xor-
 */
public class InternetRelayChatHandler implements IRCEventListener {

    private VisualBoyAdvanceHandler visualBoyAdvanceHandler;
    private ConnectionManager manager;
    private static String IRC_SERVER = "irc.ss23.geek.nz";
    private static String IRC_CHANNEL = "#xorspamchan";

    /**
     * Initialise InternetRelayChatHandler with an initialised VisualBoyAdvanceHandler
     * for handling sending commands to the VisualBoyAdvanceHandler emulator
     * @param visualBoyAdvanceHandler
     */
    public InternetRelayChatHandler(VisualBoyAdvanceHandler visualBoyAdvanceHandler) {
        this.visualBoyAdvanceHandler = visualBoyAdvanceHandler;
    }

    /**
     * Sets up and starts the connect to a irc server set in IRC_SERVER
     */
    public void connect(){
        manager = new ConnectionManager(new IrcProfile());
        Session session = manager.requestConnection(IRC_SERVER);
        session.addIRCEventListener(this);
    }


    /**
     * recieveEvent handles the messages sent from the server to the client.
     * This is where we recieve the commands from players and send them on to the VisualBoyAdvanceEmulator
     *
     * This also handles joining the channel on connection
     *
     * If you wanted to make a gui for this you would also send the commands on to the gui from here.
     * @param ircEvent
     */
    public void recieveEvent(IRCEvent ircEvent) {
        if (ircEvent.getType() == Type.CONNECT_COMPLETE){
            ircEvent.getSession().joinChannel(IRC_CHANNEL);
        } else if (ircEvent.getType() == Type.CHANNEL_MESSAGE){
            ChannelMsgEvent cme = (ChannelMsgEvent) ircEvent;
            System.out.println(cme.getNick() + ":" + cme.getMessage());
            if(GbaKeyEnum.isValidKey(cme.getMessage())){
                Runnable ircToGBAThread = new IrcToGBAThread(GbaKeyEnum.getKeyFromString(cme.getMessage()), visualBoyAdvanceHandler);
                Thread thread = new Thread(ircToGBAThread);
                thread.start();
            }
        }else {
            System.out.println(ircEvent.getType() + " " + ircEvent.getRawEventData());
        }
    }
}

/**
 * @author xor-
 * Sets the Realname, actual nick and alternative nicks
 */
class IrcProfile implements Profile {

    @Override
    public String getActualNick() {
        return "kiwiheadbot";
    }

    @Override
    public String getFirstNick() {
        return "kiwiheadbot";
    }

    @Override
    public String getSecondNick() {
        return "xorbot";
    }

    @Override
    public String getThirdNick() {
        return "fuckthisshit";

    }

    @Override
    public String getName() {
        return "KiwiHeadBot YO";
    }
}