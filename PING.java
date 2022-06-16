package PackageName;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import javax.security.auth.login.LoginException;

public class PING extends ListenerAdapter
{
    public static void main(String[] args) throws LoginException
    {
        JDABuilder.createLight(args[0], GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new PING()) //Add: //bot.addEventListener(new PING()); in "Configuration".
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message msg = event.getMessage();
        if (msg.getContentRaw().equals("Ping")) //Command that works with private messages and messages on discord servers where the bot is present.
        {
            MessageChannel channel = event.getChannel();
            long time = System.currentTimeMillis();
            channel.sendMessage("Pong") //Reply "Pong"
                    .queue(response -> {    //Edit the message with the ping of the bot.
                        response.editMessageFormat("Ping: %d ms", System.currentTimeMillis() - time).queue();
                    });
        }
    }
}