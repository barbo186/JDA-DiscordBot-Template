package PackageName;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;

public class SMS extends ListenerAdapter
{
    public static void main(String[] args)
            throws LoginException
    {
        JDA jda = JDABuilder.createDefault("ODQ4NTM3OTIxMjU4Mzg5NTA0.G0JxBg.r3en3yzGLVLv6UMFCVBsH-j9QP4zZBqgTsxGWU").build();
        jda.addEventListener(new SMS()); //Add: //bot.addEventListener(new SMS()); in "Configuration".
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.PRIVATE))
        {
            System.out.printf("[MP 186] %s: %s\n", event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
            //Write any private messages in the terminal that receives specifying the person's name.
        }
        else
        {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
            //Write all messages to discord servers where the bot is present in the terminal. Specifying server and person's name-
        }
    }
}
