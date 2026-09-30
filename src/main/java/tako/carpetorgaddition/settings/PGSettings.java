package tako.carpetorgaddition.settings;

import carpet.api.settings.Rule;
import carpet.api.settings.RuleCategory;

public class PGSettings {
    @Rule(
            categories = {RuleCategory.CLIENT},  // 使用 categories，且必需
            strict = false
    )
    public static boolean openPlayerCommand = false;

    @Rule(
            categories = {RuleCategory.CLIENT},
            strict = false
    )
    public static boolean openCarpetCommand = false;
}
