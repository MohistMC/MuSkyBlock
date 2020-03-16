package us.talabrek.ultimateskyblock.command.completion;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.bukkit.command.CommandSender;
import us.talabrek.ultimateskyblock.util.command.completion.AbstractTabCompleter;
import us.talabrek.ultimateskyblock.uSkyBlock;

/**
 * Lists ALL players (both offline and online).
 */
public class AllPlayerTabCompleter extends AbstractTabCompleter {
    private final OnlinePlayerTabCompleter online;

    public AllPlayerTabCompleter(OnlinePlayerTabCompleter online) {
        this.online = online;
    }

    @Override
    protected List<String> getTabList(CommandSender commandSender, String term) {
        Set<String> allPlayers = new LinkedHashSet<>(online.getTabList(commandSender, term));
        allPlayers.addAll(uSkyBlock.getInstance().getPlayerDB().getNames(term));
        return new ArrayList<>(allPlayers);
    }
}
