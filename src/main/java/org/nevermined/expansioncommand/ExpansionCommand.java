package org.nevermined.expansioncommand;

import org.jetbrains.annotations.NotNull;
import org.nevermined.worldevents.api.WorldEventsApi;
import org.nevermined.worldevents.api.core.WorldEventAction;
import org.nevermined.worldevents.api.expansion.WorldEventExpansion;

import java.util.function.Supplier;

public class ExpansionCommand extends WorldEventExpansion {

    @Override
    public @NotNull String getKey() {
        return "command";
    }

    @Override
    public @NotNull Supplier<WorldEventAction> getAction() {
        return CommandAction::new;
    }

}
