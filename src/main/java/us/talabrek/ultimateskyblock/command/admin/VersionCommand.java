package us.talabrek.ultimateskyblock.command.admin;

import java.util.Map;
import java.util.UUID;
import org.bukkit.command.CommandSender;
import us.talabrek.ultimateskyblock.util.command.AbstractCommand;
import us.talabrek.ultimateskyblock.uSkyBlock;
import static us.talabrek.ultimateskyblock.util.po.I18nUtil.marktr;

/**
 * Displays detailed version information.
 */
public class VersionCommand extends AbstractCommand {
    private final uSkyBlock plugin;

    public VersionCommand(uSkyBlock plugin) {
        super("version|v", "usb.admin.version", null, marktr("displays version information"), null, UUID.fromString("97e8584c-438c-43cf-8b58-4e56c52398ed"));
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String alias, Map<String, Object> data, String... args) {
        sender.sendMessage(plugin.getVersionInfo(true).split("\n"));
        return true;
    }

}
