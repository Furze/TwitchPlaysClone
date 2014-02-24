package com.github.xorDash.twitchplaysclone.gba;

/**
 * @author xor-
 */
public enum GbaKeyEnum {
    A      ("z", "a"),
    B      ("x", "b"),
    L      ("a", "l"),
    R      ("s", "r"),
    UP     ("Up",  "up"),
    DOWN   ("Down",  "down"),
    LEFT   ("Left",  "left"),
    RIGHT  ("Right",  "right"),
    START  ("Return",  "start"),
    SELECT ("space",  "select");
    private String keyboardKey;
    private String chatText;
    GbaKeyEnum(String keyboardKey, String chatText){
        this.keyboardKey = keyboardKey;
        this.chatText = chatText;
    }
    public String getKeyboardKey(){
        return keyboardKey;
    }
    public String getChatText(){
        return chatText;
    }

    /**
     * Returns true if the param str is a valid GbaKey in the enum
     * @param str
     * @return
     */
    public static boolean isValidKey(String str){
        for(GbaKeyEnum gbaKeyEnum : GbaKeyEnum.values()){
            if(str.toLowerCase().equals(gbaKeyEnum.getChatText())){
                return true;
            } else if (str.length() == 1 && (""+str.charAt(0)).equals(gbaKeyEnum.getChatText())){
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the key if the param str is a valid GbaKey in the enum
     * @param str
     * @return
     */
    public static GbaKeyEnum getKeyFromString(String str){
        for(GbaKeyEnum gbaKeyEnum : GbaKeyEnum.values()){
            if(str.toLowerCase().equals(gbaKeyEnum.getChatText())){
                return gbaKeyEnum;
            } else if (str.length() == 1 && (""+str.charAt(0)).equals(gbaKeyEnum.getChatText())){
                return gbaKeyEnum;
            }
        }
        return null;
    }
}
