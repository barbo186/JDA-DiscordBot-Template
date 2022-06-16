package PackageName;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class ClassName {

    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault("token-here") // The token must be taken from the "Discord Developer Portal" and must remain secret.
                .setStatus(OnlineStatus.ONLINE) //SET STATUS BOT
                //You can use other status: OFFLINE, DO_NOT_DISTURB and UNKNOWN
                .setActivity(Activity.playing("example")) //SET BOT "ACTION"
                //You can use: playing, listening, streaming, watching, ecc...
                .build();
        System.out.println("API READY!"); //Send message in the terminal
    }

}