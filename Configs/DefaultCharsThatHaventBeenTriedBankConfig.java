package Configs;

import Configs.DefaultCharsBankConfig;

import java.awt.*;

public class DefaultCharsThatHaventBeenTriedBankConfig extends DefaultCharsBankConfig
{

    public DefaultCharsThatHaventBeenTriedBankConfig(String borderTitle) {
        super(borderTitle);
    }

    @Override
    public Color getBackColor() {
        return  Color.lightGray;
    }

}
