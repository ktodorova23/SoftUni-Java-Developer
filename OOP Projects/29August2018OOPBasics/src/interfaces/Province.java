package interfaces;

public interface Province {
    public String addGuild(Guild guild);
    public String removeGuild(Guild guild);
    public Guild getGuildByName(String guildName);
    public boolean contains(String guildName);
}
