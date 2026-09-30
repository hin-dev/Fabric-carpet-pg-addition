package tako.carpetorgaddition;

import carpet.CarpetExtension;
import carpet.api.settings.SettingsManager;
import carpet.utils.Translations;
import tako.carpetorgaddition.settings.PGSettings;

import java.util.Map;

public class CarpetPGExtension implements CarpetExtension {
    private static final String MOD_ID = "carpet-pg-addition";

    private SettingsManager settingsManager;

    @Override
    public void onGameStarted() {
        settingsManager = new SettingsManager("1.0", MOD_ID, "Carpet PG Addition");
        settingsManager.parseSettingsClass(PGSettings.class);
    }

    @Override
    public SettingsManager extensionSettingsManager() {
        return settingsManager;
    }

    @Override
    public Map<String, String> canHasTranslations(String language) {
        return Translations.getTranslationFromResourcePath(
                String.format("assets/%s/lang/%s.json", MOD_ID, language));
    }
}
