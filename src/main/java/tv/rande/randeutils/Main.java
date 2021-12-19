package tv.rande.randeutils;

import tv.rande.randeutils.GUIs.ChallengeGUI;
import tv.rande.randeutils.GUIs.GravChallengeGUI;
import tv.rande.randeutils.GUIs.MenuGUI;
import tv.rande.randeutils.GUIs.TimerGUI;
import tv.rande.randeutils.commands.*;
import tv.rande.randeutils.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    //STARTUP AND SHUTDOWN LOGIC
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().fine("loading RND-Utils");

        ChallengeBooleans.getCurrentChallenge = "None";
        ChallengeBooleans.getCurrentChallengeInformation = "Activate Challenges with /challenge settings";
        ChallengeBooleans.PlainMC = true;
        ChallengeBooleans.GravityChallenge = false;
        ChallengeBooleans.RandomMobChallenge = false;

        listenerRegistration();
        commandRegistration();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().fine("shutting down RND-Utils");
    }

    //PLUGIN PREFIXES/SUFFIXES
    public static String getRndPrefix() {
        return ChatColor.DARK_AQUA + "[" + ChatColor.AQUA + "RND-Utils" + ChatColor.DARK_AQUA + "] " + ChatColor.GRAY;
    }

    //REGISTRATIONS
    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        //pluginManager.registerEvents(new HealthListener(), this);
        //pluginManager.registerEvents(new DropListener(), this);
        //pluginManager.registerEvents(new ItemUseListener(), this);
        // pluginManager.registerEvents(new FallListener(), this);
        pluginManager.registerEvents(new ClickListener(), this);
        pluginManager.registerEvents(new MovementListener(), this);
        pluginManager.registerEvents(new SandFallListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
    }

    private void commandRegistration() {
        getCommand("date").setExecutor(new DateCommand());
        getCommand("info").setExecutor(new InfoCommand());
        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("challenge").setExecutor(new ChallengeCommand());
        getCommand("help").setExecutor(new HelpCommand());
        getCommand("rndebug").setExecutor(new RNDebugCommand());
        getCommand("randemode").setExecutor(new RandeModeCommand());
        //getCommand("menu").setExecutor(new MenuCommand());
        //getCommand("profile").setExecutor(new ProfileCommand());
        myMenu = new MenuGUI();
        myTimer = new TimerGUI();
        myChallenge = new ChallengeGUI();
        myGravChallenge = new GravChallengeGUI();
    }

    private static MenuGUI myMenu;
    public static MenuGUI getMyMenu() {
        return myMenu;
    }

    private static TimerGUI myTimer;
    public static TimerGUI getMyTimer() {
        return myTimer;
    }

    private static ChallengeGUI myChallenge;
    public static ChallengeGUI getMyChallenge() {
        return myChallenge;
    }

    private static GravChallengeGUI myGravChallenge;
    public static GravChallengeGUI getMyGravChallenge() {
        return myGravChallenge;
    }

    //private static ProfileGUI myProfile;
    //public static ProfileGUI getMyProfile() { return myProfile; }

}