package repository;

import interfaces.Guild;
import interfaces.Province;

import java.util.Map;
import java.util.TreeMap;

public class ProvinceImpl implements Province {
    private Map<String, Guild> guilds;
    private String name;

    //TODO Comparator: by the guilds total points. If there are guilds with equal points they should be ordered alphabetically.
    public ProvinceImpl(String name) {
        this.guilds = new TreeMap<>();
        this.name = name;
    }

    @Override
    public String addGuild(Guild guild) {
        this.guilds.put(guild.getName(), guild);
        return "Added Guild: " + guild.getName();
    }

    @Override
    public String removeGuild(Guild guild) {
        this.guilds.remove(guild.getName());
        return String.format("Removed guild [%s] with %d members.", guild.getName(), guild.getGuildSize());
    }

    @Override
    public Guild getGuildByName(String guildName) {
        return this.guilds.get(guildName);
    }

    @Override
    public boolean contains(String guildName) {
        return this.guilds.containsKey(guildName);
    }
}
